package backoffice_server.backoffice_server.lecture.service;

import backoffice_server.backoffice_server.lecture.dto.*;
import backoffice_server.backoffice_server.lecture.entity.LectureCategory;

import java.util.List;

public interface LectureService {

    LectureRegisterResponseDto registerLecture(LectureRegisterRequestDto requestDto);

    LectureUpdateResponseDto updateLecture(Long id, LectureUpdateRequestDto requestDto);

    LectureFindChosenResponseDto findChosenLecture(Long id);

    List<LectureCategoryListResponseDto> findLectureByCategory(LectureCategory category);

    void deleteLecture(Long id);


}
