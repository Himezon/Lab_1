package animals;

import backgroundObject.BackgroundObject;

import java.util.Objects;
import java.util.Random;

public class AbstractAnimals extends Animals{


    public AbstractAnimals(String name){
        super(name);
        visible = false;
    }


    public boolean move(BackgroundObject object, String newPosition) {
        if (new Random().nextFloat() < 0.5) {
            System.out.println(object.getName() + " was moved from " + object.getPosition() + " to " + newPosition);
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName(), getCount(), visible);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        AbstractAnimals other = (AbstractAnimals) obj;
        return Objects.equals(getName(), other.getName()) && getCount() == other.getCount() && visible == other.visible;
    }

    @Override
    public boolean setVisibility(Boolean visibility) {
        visible = visibility;
        return true;
    }

    @Override
    public boolean getVisibility() {
        if (visible) {
            System.out.println("Forest dwellers can be seen now.");
            return true;
        }
        else {
            System.out.println("Forest dwellers can't be seen now.");
            return false;
        }
    }
}
