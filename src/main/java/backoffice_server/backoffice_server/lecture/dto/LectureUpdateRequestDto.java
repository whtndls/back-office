package backoffice_server.backoffice_server.lecture.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LectureUpdateRequestDto {

    @NotBlank
    private String title;

    @NotNull
    private int price;

    @NotBlank
    private String introduction;

    @NotBlank
    private String category;

}
