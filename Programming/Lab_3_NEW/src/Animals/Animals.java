package animals;

public abstract class Animals {
    private String name;
    private int count;

    public Animals(String name){
        this.name = name;
    }

    public Animals(String name, int count){
        this.name = name;
        this.count = count;
    }

    public String getName(){
        return this.name;
    }

    public int getCount(){
        return this.count;
    }
}
