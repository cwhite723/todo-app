package hayan.todoApp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {

    private String title;
    private Integer todoOrder;

    private Boolean completed;

    @Builder
    public PostRequestDto(String title, Integer todoOrder, Boolean completed) {
        this.title = title;
        this.todoOrder = todoOrder;
        this.completed = completed;
    }
}
