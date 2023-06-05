package hayan.todoApp.repository;

import hayan.todoApp.domain.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todos, Long> {

}
