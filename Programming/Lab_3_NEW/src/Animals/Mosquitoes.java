package Animals;

import backgroundObject.BackgroundObject;
import backgroundObject.Earth;
import mumiTroll.ObjectMumiTroll;

import java.util.Objects;

public class Mosquitoes extends Animals {

    private int attack;

    public Mosquitoes(String name) {
        super(name);
        attack = 0;
    }

    public void damage(ObjectMumiTroll objectMumiTroll) {
        objectMumiTroll.setHealth(objectMumiTroll.getHealth() - getAttack());
    }

    public void flew(BackgroundObject backgroundObject) {
        System.out.println(this.getName() + " flew under the " + backgroundObject.getName());
    }

    public int getAttack(){
        return attack;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Mosquitoes other = (Mosquitoes) obj;
        return Objects.equals(getName(), other.getName());
    }

}
