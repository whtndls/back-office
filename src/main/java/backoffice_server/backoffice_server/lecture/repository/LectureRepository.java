package backoffice_server.backoffice_server.lecture.repository;

import backoffice_server.backoffice_server.lecture.entity.Lecture;
import backoffice_server.backoffice_server.lecture.entity.LectureCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findAllByLecturerIdOrderByCreatedAtDesc(Long Id);
    List<Lecture> findAllByCategoryOrderByCreatedAtDesc(LectureCategory category);
}
