package hayan.todoApp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequestDto {

    @NotNull(message = "변경할 할 일을 입력해주세요.")
    private String title;
    @NotNull(message = "완료 여부를 입력해주세요.")
    private Boolean completed;

    public UpdateRequestDto(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }
}
