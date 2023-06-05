package hayan.todoApp.dto;

import hayan.todoApp.domain.Todos;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
