package animals;

import misc.Visible;

public abstract class Animals implements Visible {
    private final String name;
    private int count;
    protected boolean visible;


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
