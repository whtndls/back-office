package backoffice_server.backoffice_server.lecturer.service;

import backoffice_server.backoffice_server.lecture.entity.Lecture;
import backoffice_server.backoffice_server.lecture.repository.LectureRepository;
import backoffice_server.backoffice_server.lecturer.dto.*;
import backoffice_server.backoffice_server.lecturer.entity.Lecturer;
import backoffice_server.backoffice_server.lecturer.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;
    private final LectureRepository lectureRepository;

    @Override
    @Transactional
    public LecturerRegisterResponseDto registerLecturer(LecturerRegisterRequestDto requestDto) {
        Lecturer lecturer = new Lecturer(requestDto);
        lecturerRepository.save(lecturer);

        return new LecturerRegisterResponseDto(lecturer);
    }

    @Override
    @Transactional
    public LecturerUpdateResponseDto updateLecturer(Long id, LecturerUpdateRequestDto requestDto) {

        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강사입니다"));

        lecturer.updateLecturer(requestDto);
        return new LecturerUpdateResponseDto(lecturer);
    }

    @Override
    public FindLecturerResponseDto findLecturer(Long id) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강사입니다."));

        return new FindLecturerResponseDto(lecturer);
    }

    @Override
    public List<LectureListResponseDto> findAllLecturersLecture(Long id) {
        List<Lecture> lectures = lectureRepository.findAllByLecturerIdOrderByCreatedAtDesc(id);
        if (lectures.isEmpty()) {
            throw new IllegalArgumentException("해당 강사의 강의가 존재하지 않습니다.");
        }

        return lectures.stream().map(LectureListResponseDto::new).toList();
    }

    @Override
    @Transactional
    public void deleteLecturer(Long id) {
        lecturerRepository.deleteById(id);
    }


}
