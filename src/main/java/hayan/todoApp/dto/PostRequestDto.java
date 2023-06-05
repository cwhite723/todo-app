package hayan.todoApp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {

    @NotNull(message = "할 일을 입력해주세요.")
    private String title;
    @NotNull(message = "우선 순위를 입력해주세요.")
    private Integer todoOrder;

    @NotNull(message = "완료 여부를 입력해주세요.")
    private Boolean completed;

    @Builder
    public PostRequestDto(String title, Integer todoOrder, Boolean completed) {
        this.title = title;
        this.todoOrder = todoOrder;
        this.completed = completed;
    }
}
