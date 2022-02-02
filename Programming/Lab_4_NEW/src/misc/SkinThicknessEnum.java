package misc;

public enum  SkinThicknessEnum {

    LOW("Low"),
    MIDDLE("Middle"),
    HARD("Hard");

    private final String title;
    private final int thickness;

    SkinThicknessEnum(String title) {
        this.title = title;
        thickness = this.ordinal() + 1;
    };
}
