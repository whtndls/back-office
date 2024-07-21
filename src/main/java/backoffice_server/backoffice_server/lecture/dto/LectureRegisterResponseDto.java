package backoffice_server.backoffice_server.lecture.dto;

import backoffice_server.backoffice_server.lecture.entity.Lecture;
import backoffice_server.backoffice_server.lecture.entity.LectureCategory;
import backoffice_server.backoffice_server.lecturer.entity.Lecturer;
import lombok.Getter;

@Getter
public class LectureRegisterResponseDto {

    private final Long lecturerId;
    private final String title;
    private final int price;
    private final String introduction;
    private final LectureCategory category;

    public LectureRegisterResponseDto(Lecture lecture) {
        this.lecturerId = lecture.getLecturer().getId();
        this.title = lecture.getTitle();
        this.price = lecture.getPrice();
        this.introduction = lecture.getIntroduction();
        this.category = lecture.getCategory();
    }
}
