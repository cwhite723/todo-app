package hayan.todoApp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequestDto {

    private String title;
    private Boolean completed;

    public UpdateRequestDto(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }
}
