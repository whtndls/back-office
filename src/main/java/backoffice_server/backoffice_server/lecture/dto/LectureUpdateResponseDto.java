package backoffice_server.backoffice_server.lecture.dto;

import backoffice_server.backoffice_server.lecture.entity.Lecture;
import backoffice_server.backoffice_server.lecture.entity.LectureCategory;
import lombok.Getter;

@Getter
public class LectureUpdateResponseDto {

    private final String title;
    private final int price;
    private final String introduction;
    private final LectureCategory category;

    public LectureUpdateResponseDto(Lecture lecture) {
        this.title = lecture.getTitle();
        this.price = lecture.getPrice();
        this.introduction = lecture.getIntroduction();
        this.category = LectureCategory.convertStringToCategory(String.valueOf(lecture.getCategory()));
    }

}
