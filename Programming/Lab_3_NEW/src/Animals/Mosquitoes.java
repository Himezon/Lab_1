package Animals;

import backgroundObject.BackgroundObject;
import mumiTroll.ObjectMumiTroll;

public class Mosquitoes extends Animals{

    private int attack;

    public Mosquitoes(String name){
        super(name);
        attack = 1;
    }

    public void damage(ObjectMumiTroll objectMumiTroll){
        objectMumiTroll.health = objectMumiTroll.getHealth() - attack;
    }

    public void flew(BackgroundObject backgroundObject){
        System.out.println(this.getName() + " flew under the " + backgroundObject.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
