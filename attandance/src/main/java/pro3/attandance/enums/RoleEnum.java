package pro3.attandance.enums;

public enum RoleEnum {
    ATTENDEE(0),
    TRAINER(1),
    EXTERN(2),
    MANAGER(3),
    ADMIN (4)
    ;

    private final int code;

    RoleEnum(int code) {
        this.code = code;
    }
}
