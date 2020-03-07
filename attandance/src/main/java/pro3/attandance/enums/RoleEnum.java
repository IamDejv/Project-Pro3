package pro3.attandance.enums;

public enum RoleEnum {
    ADMIN (0),
    ATTENDEE(1),
    TRAINER(2),
    EXTERN(3),
    MANAGER(4)
    ;

    private final int code;

    RoleEnum(int code) {
        this.code = code;
    }
}
