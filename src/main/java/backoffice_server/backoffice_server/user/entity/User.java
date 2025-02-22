package backoffice_server.backoffice_server.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String department;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    public User(String email, String password, String department, UserRole role) {
        this.email = email;
        this.password = password;
        this.department = department;
        this.role = role;
    }
}
