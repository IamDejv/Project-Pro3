package pro3.attandance.enums;

public enum SexEnum {
    FEMALE (0),
    MALE(1)
    ;

    private final int code;

    SexEnum(int code) {
        this.code = code;
    }

    public static SexEnum getEnum(int code) {
        return code == 1 ? SexEnum.FEMALE : SexEnum.MALE;
    }

    public static String webalizeSex(int code) {
        return code == 0 ? "Žena" : "Muž";
    }
}
