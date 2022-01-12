package backgroundObject;

public abstract class BackgroundObject {
    private String name;
    private int count;

    public BackgroundObject(String name){
        this.name = name;
    }

    public BackgroundObject(String name, int count){
        this.name = name;
        this.count = count;
    }


    public String getName(){
        return this.name;
    }

    public int getCount(){
        return count;
    }

    public String hardnessTest(int density){
        if (count < density){
            return name + " is soft";
        } else {
            return name + " is solid";
        }
    }
}
