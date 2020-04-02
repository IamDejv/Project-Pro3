package pro3.attandance.enums;

public enum TrainingTypeEnum {
    PARKOUR (0),
    OTHER(1)
    ;

    private final int code;

    TrainingTypeEnum(int code) {
        this.code = code;
    }

    public static TrainingTypeEnum getEnum(int code) {
        return code == 1 ? TrainingTypeEnum.OTHER : TrainingTypeEnum.PARKOUR;
    }

    public static String webalizeEnum(int code) {
        return code == 0 ? "Parkour" : "Other";
    }
}
