package backoffice_server.backoffice_server.user.service;

import backoffice_server.backoffice_server.user.dto.UserSignUpRequestDto;
import backoffice_server.backoffice_server.user.dto.UserSignUpResponseDto;

public interface UserService {
    UserSignUpResponseDto signUp(UserSignUpRequestDto requestDto);
}
