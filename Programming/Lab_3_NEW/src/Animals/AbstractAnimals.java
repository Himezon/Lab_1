package Animals;

import backgroundObject.BackgroundObject;

public class AbstractAnimals extends Animals{

    public AbstractAnimals(String name, String status){
        super(name, status);
    }

    public void see(){
        System.out.println("было видно " + this.getStatus() + " " + this.getName() + ".");
    }

    public void push(BackgroundObject backgroundObject, BackgroundObject backgroundObject1){
        System.out.print("Они пытались столкнуть " + backgroundObject.getStatus() + " " + backgroundObject.getName()
                + " в " + backgroundObject1.getName() + ".");
    }
}
