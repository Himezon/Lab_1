package Animals;

import backgroundObject.BackgroundObject;

public class Cuckoos extends Animals{

    public Cuckoos(String name){
        super(name);
    }

    public void cuckoo(BackgroundObject backgroundObject){
        System.out.println(this.getName() + " куковали в " + backgroundObject.getName()
                + " " + backgroundObject.getStatus() + ".");
    }
}
