package mumiTroll;

public enum ObjectMumiTroll {
    PAWS("лапами"),
    HEAD("голова"),
    SKIN("шкура");
    private final String name;
    ObjectMumiTroll(String name){this.name = name;}
    public String getName(){
        return name;
    }

}
