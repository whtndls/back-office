package backoffice_server.backoffice_server.lecturer.dto;

import backoffice_server.backoffice_server.lecturer.entity.Lecturer;
import lombok.Getter;

@Getter
public class FindLecturerResponseDto {

    private final String name;
    private final int career;
    private final String company;
    private final String phoneNumber;
    private final String introduction;

    public FindLecturerResponseDto(Lecturer lecturer) {
        this.name = lecturer.getName();
        this.career = lecturer.getCareer();
        this.company = lecturer.getCompany();
        this.phoneNumber = lecturer.getPhoneNumber();
        this.introduction = lecturer.getIntroduction();
    }


}
