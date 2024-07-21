package backoffice_server.backoffice_server.lecture.controller;

import backoffice_server.backoffice_server.lecture.dto.*;
import backoffice_server.backoffice_server.lecture.entity.LectureCategory;
import backoffice_server.backoffice_server.lecture.service.LectureService;
import backoffice_server.backoffice_server.user.entity.UserRole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;

    @Secured({UserRole.Authority.STAFF, UserRole.Authority.MANAGER})
    @PostMapping
    public ResponseEntity<LectureRegisterResponseDto> registerLecture(@RequestBody @Valid LectureRegisterRequestDto requestDto) {

        LectureRegisterResponseDto responseDto = lectureService.registerLecture(requestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDto);
    }

    @Secured(UserRole.Authority.MANAGER)
    @PutMapping("/{id}")
    public ResponseEntity<LectureUpdateResponseDto> updateLecture(@PathVariable(name = "id") Long id, @RequestBody @Valid LectureUpdateRequestDto requestDto) {
        LectureUpdateResponseDto responseDto = lectureService.updateLecture(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectureFindChosenResponseDto> findChosenLecture(@PathVariable(name = "id") Long id) {
        LectureFindChosenResponseDto responseDto = lectureService.findChosenLecture(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<LectureCategoryListResponseDto>> findLectureByCategory(@RequestParam(name="category") String category) {
        LectureCategory role = LectureCategory.convertStringToCategory(category);
        List<LectureCategoryListResponseDto> responseDtos = lectureService.findLectureByCategory(role);

        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDtos);
    }

    @Secured(UserRole.Authority.MANAGER)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecture(@PathVariable(name = "id") Long id) {
        lectureService.deleteLecture(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
