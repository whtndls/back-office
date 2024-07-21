package backoffice_server.backoffice_server.lecturer.repository;

import backoffice_server.backoffice_server.lecture.entity.Lecture;
import backoffice_server.backoffice_server.lecturer.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {


}
