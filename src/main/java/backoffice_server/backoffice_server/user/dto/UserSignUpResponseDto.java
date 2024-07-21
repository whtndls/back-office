package backoffice_server.backoffice_server.user.dto;

import backoffice_server.backoffice_server.user.entity.User;
import backoffice_server.backoffice_server.user.entity.UserRole;
import lombok.Getter;

@Getter
public class UserSignUpResponseDto {
    private final String email;
    private final String department;
    private final UserRole role;

    public UserSignUpResponseDto(User user) {
        this.email = user.getEmail();
        this.department = user.getDepartment();
        this.role = user.getRole();
    }
}
