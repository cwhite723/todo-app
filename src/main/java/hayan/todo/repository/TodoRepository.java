package hayan.todo.repository;

import hayan.todo.domain.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todos, Long> {

}
