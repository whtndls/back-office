package backoffice_server.backoffice_server.user.controller;

import backoffice_server.backoffice_server.user.dto.UserSignUpRequestDto;
import backoffice_server.backoffice_server.user.dto.UserSignUpResponseDto;
import backoffice_server.backoffice_server.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserSignUpResponseDto> createUser(@RequestBody @Valid UserSignUpRequestDto requestDto) {
        UserSignUpResponseDto responseDto = userService.signUp(requestDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(responseDto);
    }
}
