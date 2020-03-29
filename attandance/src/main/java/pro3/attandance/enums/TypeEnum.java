package pro3.attandance.enums;

public enum TypeEnum {
    PARKOUR (0),
    OTHER(1)
    ;

    private final int code;

    TypeEnum(int code) {
        this.code = code;
    }

    public static TypeEnum getEnum(int code) {
        return code == 1 ? TypeEnum.OTHER : TypeEnum.PARKOUR;
    }
}
