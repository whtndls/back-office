package backoffice_server.backoffice_server.lecture.entity;

import backoffice_server.backoffice_server.lecture.dto.LectureRegisterRequestDto;
import backoffice_server.backoffice_server.lecture.dto.LectureUpdateRequestDto;
import backoffice_server.backoffice_server.lecturer.entity.Lecturer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Lecture extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String introduction;

    @Enumerated(value = EnumType.STRING)
    private LectureCategory category;

    public Lecture(Lecturer lecturer, LectureRegisterRequestDto requestDto) {
        this.lecturer = lecturer;
        this.title = requestDto.getTitle();
        this.price = requestDto.getPrice();
        this.introduction = requestDto.getIntroduction();
        this.category = LectureCategory.convertStringToCategory(requestDto.getCategory());
    }

    public void update(LectureUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.price = requestDto.getPrice();
        this.introduction = requestDto.getIntroduction();
        this.category = LectureCategory.convertStringToCategory(requestDto.getCategory());
    }
}
