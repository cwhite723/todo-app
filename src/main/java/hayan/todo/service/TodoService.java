package hayan.todo.service;

import hayan.todo.domain.Todos;
import hayan.todo.dto.PostRequestDto;
import hayan.todo.dto.ResponseDto;
import hayan.todo.dto.UpdateRequestDto;
import hayan.todo.exception.CustomException;
import hayan.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static hayan.todo.exception.ErrorInformation.*;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public ResponseDto post(PostRequestDto requestDto) {
        Todos todo = toEntity(requestDto);
        todo = todoRepository.save(todo);

        return ResponseDto.of(todo);
    }

    @Transactional(readOnly = true)
    public List<ResponseDto> findAll() {
        List<Todos> todos = todoRepository.findAll();

        return toResponses(todos);
    }

    @Transactional(readOnly = true)
    public ResponseDto findById(Long id) {
        Todos todo = getTodoById(id);

        return ResponseDto.of(todo);
    }

    public ResponseDto update(Long id, UpdateRequestDto requestDto) {
        Todos todo = getTodoById(id);
        todo.update(requestDto.getTitle(), requestDto.getCompleted());

        return ResponseDto.of(todo);
    }

    public void deleteAll() {
        todoRepository.deleteAll();
    }

    public void deleteById(Long id) {
        Todos todo = getTodoById(id);
        todoRepository.delete(todo);
    }

    private Todos getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new CustomException(POST_NOT_FOUND));
    }

    private Todos toEntity(PostRequestDto requestDto) {
        return Todos.builder()
                .title(requestDto.getTitle())
                .todoOrder(requestDto.getTodoOrder())
                .completed(requestDto.getCompleted())
                .build();
    }

    private List<ResponseDto> toResponses(List<Todos> todos) {
        return todos.stream()
                .map(todo -> ResponseDto.of(todo))
                .collect(Collectors.toList());
    }
}
