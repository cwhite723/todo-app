package hayan.todoApp.service;

import hayan.todoApp.domain.Todos;
import hayan.todoApp.dto.PostRequestDto;
import hayan.todoApp.dto.ResponseDto;
import hayan.todoApp.dto.UpdateRequestDto;
import hayan.todoApp.exception.CustomException;
import hayan.todoApp.exception.ErrorInformation;
import hayan.todoApp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ResponseDto> findAll() {
        List<Todos> todos = todoRepository.findAll();

        return toResponses(todos);
    }

    public ResponseDto findById(Long id) {
        validate(id);
        Todos todo = todoRepository.findById(id).get();

        return ResponseDto.of(todo);
    }

    public ResponseDto update(Long id, UpdateRequestDto requestDto) {
        validate(id);
        Todos todo = todoRepository.findById(id).get();
        todo.update(requestDto.getTitle(), requestDto.getCompleted());

        return ResponseDto.of(todo);
    }

    public void deleteAll() {
        todoRepository.deleteAll();
    }

    public void deleteById(Long id) {
        validate(id);
        todoRepository.deleteById(id);
    }

    private void validate(Long id) {
        final boolean isExist = todoRepository.existsById(id);
        if (!isExist) {
            // TODO: 예외 처리 구현 후 수정
            throw new CustomException(ErrorInformation.POST_NOT_FOUND);
        }
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
