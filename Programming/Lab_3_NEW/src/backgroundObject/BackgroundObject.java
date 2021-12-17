package backgroundObject;

public abstract class BackgroundObject {
    private String name;
    private String status;

    public BackgroundObject(String name){
        this.name = name;
    }

    public BackgroundObject(String name, String status){
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
