package backoffice_server.backoffice_server.lecturer.service;

import backoffice_server.backoffice_server.lecturer.dto.*;

import java.util.List;

public interface LecturerService {

    LecturerRegisterResponseDto registerLecturer(LecturerRegisterRequestDto requestDto);

    LecturerUpdateResponseDto updateLecturer(Long id, LecturerUpdateRequestDto requestDto);

    FindLecturerResponseDto findLecturer(Long id);

    List<LectureListResponseDto> findAllLecturersLecture(Long id);

    void deleteLecturer(Long id);
}
