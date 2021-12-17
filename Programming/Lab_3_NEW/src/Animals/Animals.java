package Animals;

public abstract class Animals {
    private String name;
    private String status;

    public Animals(String name){
        this.name = name;
    }

    public Animals(String name, String status){
        this.name = name;
        this.status = status;
    }

    public String getName(){
        return this.name;
    }

    public String getStatus(){
        return this.status;
    }
}
