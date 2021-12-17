package backgroundObject;

public enum FairEnum {
    FIRS("хвои"),
    STICK("веточек");
    private final String name;
    FairEnum(String name){this.name = name;}
    public String getName(){
        return name;
    }
}
