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

    public static String webalizeRole(int code) {
        return code == 0 ? "Docházející" : code == 1 ? "Trenér" : code == 2 ? "Návštěvník" : code == 3 ? "Manažer" : "Admin";
    }
}
