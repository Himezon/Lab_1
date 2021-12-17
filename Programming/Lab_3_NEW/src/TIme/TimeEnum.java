package TIme;

public enum TimeEnum {
    EVENING("вечер"),
    NIGHT("ночь");
    private final String name;
    TimeEnum(String name){this.name = name;}
    public String getName(){
        return name;
    }
}
