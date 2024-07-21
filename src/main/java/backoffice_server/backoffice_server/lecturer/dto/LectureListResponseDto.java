package backoffice_server.backoffice_server.lecturer.dto;

import backoffice_server.backoffice_server.lecture.entity.Lecture;
import backoffice_server.backoffice_server.lecture.entity.LectureCategory;
import backoffice_server.backoffice_server.lecturer.entity.Lecturer;
import lombok.Getter;

@Getter
public class LectureListResponseDto {

    private final Long id;
    private final Lecturer lecturer;
    private final String title;
    private final int price;
    private final String introduction;
    private final LectureCategory category;

    public LectureListResponseDto(Lecture lecture) {
        this.id = lecture.getId();
        this.lecturer = lecture.getLecturer();
        this.title = lecture.getTitle();
        this.price = lecture.getPrice();
        this.introduction = lecture.getIntroduction();
        this.category = lecture.getCategory();
    }


}
