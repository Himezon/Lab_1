package animals;

import backgroundObject.BackgroundObject;
import misc.BiteException;
import mumiTroll.MumiTroll;
import misc.SkinThicknessEnum;
import java.util.Objects;

public class Mosquitoes extends Animals{

    private final int attack;

    public Mosquitoes(String name, int attack){
        super(name);
        this.attack = attack;
    }

    public void Bite(MumiTroll objectMumiTroll){
        if (objectMumiTroll.getSkinThickness() == SkinThicknessEnum.LOW) {
            objectMumiTroll.decHealth(this.attack);
        }
        else {
            throw new BiteException();
        }
    }

    public void flew(BackgroundObject backgroundObject){
        System.out.println(this.getName() + " flew under the " + backgroundObject.getName() + ".");
    }

    public int getAttack(){
        return attack;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName(), attack);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Mosquitoes other = (Mosquitoes) obj;
        return Objects.equals(getName(), other.getName()) && attack == other.attack;
    }

    @Override
    public boolean setVisibility(Boolean visibility) {
        visible = visibility;
        return true;
    }

    @Override
    public boolean getVisibility() {
        return visible;
    }
}
