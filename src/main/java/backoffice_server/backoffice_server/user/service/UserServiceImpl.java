package backoffice_server.backoffice_server.user.service;


import backoffice_server.backoffice_server.user.dto.UserSignUpRequestDto;
import backoffice_server.backoffice_server.user.dto.UserSignUpResponseDto;
import backoffice_server.backoffice_server.user.entity.User;
import backoffice_server.backoffice_server.user.entity.UserRole;
import backoffice_server.backoffice_server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserSignUpResponseDto signUp(UserSignUpRequestDto requestDto) {
        String email = requestDto.getEmail();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String department = requestDto.getDepartment();

        Optional<User> checkEmail = userRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }


        UserRole role;
        if (department.equals("마케팅"))
            role = UserRole.STAFF;
        else
            role = UserRole.MANAGER;

        User user = new User(email, password, department, role);
        userRepository.save(user);

        log.info("회원가입 성공");
        return new UserSignUpResponseDto(user);


    }

}
