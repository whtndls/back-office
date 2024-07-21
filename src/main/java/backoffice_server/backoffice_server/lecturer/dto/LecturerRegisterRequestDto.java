package backoffice_server.backoffice_server.lecturer.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LecturerRegisterRequestDto {

    @NotBlank
    private String name;

    @Min(0)
    private int career;

    @NotBlank
    private String company;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String introduction;

}
