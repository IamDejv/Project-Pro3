package pro3.attandance.enums;

public enum TypeEnum {
    EXHIBITION (0),
    WORKSHOP(1),
    OTHER(1)
    ;

    private final int code;

    TypeEnum(int code) {
        this.code = code;
    }

    public static String webalizeEnum(int code) {
        return code == 0 ? "Vystoupení" : code == 1 ? "Workshop" : "Ostatní";
    }
}
