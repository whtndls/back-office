package backoffice_server.backoffice_server.lecture.service;

import backoffice_server.backoffice_server.lecture.dto.*;
import backoffice_server.backoffice_server.lecture.entity.Lecture;
import backoffice_server.backoffice_server.lecture.entity.LectureCategory;
import backoffice_server.backoffice_server.lecture.repository.LectureRepository;
import backoffice_server.backoffice_server.lecturer.entity.Lecturer;
import backoffice_server.backoffice_server.lecturer.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final LecturerRepository lecturerRepository;

    @Override
    @Transactional
    public LectureRegisterResponseDto registerLecture(LectureRegisterRequestDto requestDto) {

        Long lecturerId = requestDto.getLecturerId();
        Lecturer findLecturer = lecturerRepository.findById(lecturerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강사입니다."));

        Lecture lecture = new Lecture(findLecturer, requestDto);
        lectureRepository.save(lecture);

        return new LectureRegisterResponseDto(lecture);
    }

    @Override
    @Transactional
    public LectureUpdateResponseDto updateLecture(Long id, LectureUpdateRequestDto requestDto) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        lecture.update(requestDto);

        return new LectureUpdateResponseDto(lecture);
    }

    @Override
    public LectureFindChosenResponseDto findChosenLecture(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));

        return new LectureFindChosenResponseDto(lecture);
    }

    @Override
    public List<LectureCategoryListResponseDto> findLectureByCategory(LectureCategory category) {
        List<Lecture> lectures = lectureRepository.findAllByCategoryOrderByCreatedAtDesc(category);
        if (lectures.isEmpty()) {
            throw new IllegalArgumentException(category + "해당 카테고리 강의가 없습니다.");
        }

        return lectures.stream().map(LectureCategoryListResponseDto::new).toList();

    }

    @Override
    @Transactional
    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }
}
