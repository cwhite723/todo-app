package hayan.todoApp.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Todos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String title;

    @Column(name = "todo_order")
    private Integer todoOrder;

    private Boolean completed;

    @Builder
    public Todos(String title, Integer todoOrder, Boolean completed) {
        this.title = title;
        this.todoOrder = todoOrder;
        this.completed = completed;
    }

    public void update(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }
}
