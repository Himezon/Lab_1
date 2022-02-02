package time;

public enum TimeEnum{
    EVENING("Evening"),
    NIGHT("Night");
    private final String name;
    TimeEnum(String name){this.name = name;}
    public String getName(){
        return name;
    }
}
