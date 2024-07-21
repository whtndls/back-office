package backoffice_server.backoffice_server.user.entity;

import lombok.Getter;

@Getter
public enum UserRole {

    MANAGER(Authority.MANAGER),
    STAFF(Authority.STAFF);

    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

    public static class Authority {
        public static final String MANAGER = "ROLE_MANAGER";
        public static final String STAFF = "ROLE_STAFF";
    }
}