package hayan.todoApp.controller;

import hayan.todoApp.dto.PostRequestDto;
import hayan.todoApp.dto.ResponseDto;
import hayan.todoApp.dto.UpdateRequestDto;
import hayan.todoApp.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseDto post(@Valid @RequestBody PostRequestDto postRequestDto) {
        return todoService.post(postRequestDto);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ResponseDto> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ResponseDto findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    public ResponseDto update(@PathVariable Long id, @Valid @RequestBody UpdateRequestDto requestDto) {
        return todoService.update(id, requestDto);
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void deleteAll() {
        todoService.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        todoService.deleteById(id);
    }
}
