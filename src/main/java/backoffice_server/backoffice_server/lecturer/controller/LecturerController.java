package backoffice_server.backoffice_server.lecturer.controller;

import backoffice_server.backoffice_server.lecturer.dto.*;
import backoffice_server.backoffice_server.lecturer.service.LecturerService;
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
@RequestMapping("lecturers")
@RequiredArgsConstructor
public class LecturerController {

    private final LecturerService lecturerService;


    @Secured({UserRole.Authority.STAFF, UserRole.Authority.MANAGER})
    @PostMapping
    public ResponseEntity<LecturerRegisterResponseDto> registerLecturer(@RequestBody @Valid LecturerRegisterRequestDto requestDto) {
        LecturerRegisterResponseDto responseDto = lecturerService.registerLecturer(requestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDto);
    }

    @Secured(UserRole.Authority.MANAGER)
    @PutMapping("/{id}")
    public ResponseEntity<LecturerUpdateResponseDto> updateLecturer(@PathVariable(name = "id") Long id, @RequestBody @Valid LecturerUpdateRequestDto requestDto) {
        LecturerUpdateResponseDto responseDto = lecturerService.updateLecturer(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDto);
    }

    @Secured({UserRole.Authority.STAFF, UserRole.Authority.MANAGER})
    @GetMapping("/{id}")
    public ResponseEntity<FindLecturerResponseDto> findLecturer(@PathVariable(name = "id") Long id) {
        FindLecturerResponseDto responseDto = lecturerService.findLecturer(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDto);
    }

    @Secured({UserRole.Authority.STAFF, UserRole.Authority.MANAGER})
    @GetMapping("/{id}/lectures")
    public ResponseEntity<List<LectureListResponseDto>> findAllLecturersLecture(@PathVariable(name = "id") Long id) {
        List<LectureListResponseDto> responseDtos = lecturerService.findAllLecturersLecture(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDtos);
    }

    @Secured(UserRole.Authority.MANAGER)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecturer(@PathVariable(name = "id") Long id) {
        lecturerService.deleteLecturer(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
