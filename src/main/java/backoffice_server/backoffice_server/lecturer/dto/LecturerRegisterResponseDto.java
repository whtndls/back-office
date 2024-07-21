package backoffice_server.backoffice_server.lecturer.dto;

import backoffice_server.backoffice_server.lecturer.entity.Lecturer;
import lombok.Getter;

@Getter
public class LecturerRegisterResponseDto {

    private final String name;
    private final int career;
    private final String company;
    private final String phoneNumber;
    private final String introduction;

    public LecturerRegisterResponseDto(Lecturer teacher) {
        this.name = teacher.getName();
        this.career = teacher.getCareer();
        this.company = teacher.getCompany();
        this.phoneNumber = teacher.getPhoneNumber();
        this.introduction = teacher.getIntroduction();
    }

}
