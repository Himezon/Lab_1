package backgroundObject;

public enum NightEnum {
    TRANSPARENT("прозрачной"),
    FABLED("сказочной"),
    MAGIC("волшебной");
    private final String name;
    NightEnum(String name){this.name = name;}
    public String getName(){
        return name;
    }
}
