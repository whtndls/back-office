package backoffice_server.backoffice_server.lecturer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LecturerUpdateRequestDto {

    @NotBlank
    private String name;

    @NotNull
    private int career;

    @NotBlank
    private String company;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String introduction;

}
