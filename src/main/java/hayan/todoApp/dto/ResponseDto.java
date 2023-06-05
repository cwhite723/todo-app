package hayan.todoApp.dto;

import hayan.todoApp.domain.Todos;
import lombok.Getter;

import java.util.Optional;

@Getter
public class ResponseDto {

    private Long id;
    private String title;
    private Integer todoOrder;
    private Boolean completed;

    public ResponseDto(Todos entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.todoOrder = entity.getTodoOrder();
        this.completed = entity.getCompleted();
    }

    public static ResponseDto of(Todos data) {
        return new ResponseDto(data);
    }

    public static ResponseDto of(Optional<Todos> data) {
        return new ResponseDto(data.get());
    }
}
