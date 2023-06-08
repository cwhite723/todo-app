package hayan.todo.repository;

import hayan.todo.domain.Todos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DataJpaTest
class TodoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;

    @MockBean
    private TodoRepository mockTodoRepository;

    @Test
    void todo_1개_저장_테스트() {
        // Given
        Todos todo = Todos.builder()
                .title("Sample")
                .todoOrder(1)
                .completed(false)
                .build();

        when(mockTodoRepository.save(any(Todos.class))).thenReturn(todo);

        // When
        Todos savedTodo = todoRepository.save(todo);

        // Then
        verify(mockTodoRepository, times(1)).save(todo);
        assertThat(savedTodo).isEqualTo(todo);
    }
}