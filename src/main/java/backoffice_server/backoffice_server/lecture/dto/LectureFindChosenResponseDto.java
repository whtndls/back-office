package backoffice_server.backoffice_server.lecture.dto;

import backoffice_server.backoffice_server.lecture.entity.Lecture;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LectureFindChosenResponseDto {
    private final Long id;
    private final String teacher;
    private final String title;
    private final int price;
    private final String introduction;
    private final String category;
    private final LocalDateTime createdAt;

    public LectureFindChosenResponseDto(Lecture lecture) {
        this.id = lecture.getId();
        this.teacher = lecture.getLecturer().getName();
        this.title = lecture.getTitle();
        this.price = lecture.getPrice();
        this.introduction = lecture.getIntroduction();
        this.category = lecture.getCategory().getCategoryName();
        this.createdAt = lecture.getCreatedAt();
    }
}
