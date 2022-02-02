package night;

import animals.Animals;
import backgroundObject.BackgroundObject;
import misc.Visible;

import java.util.ArrayList;
import java.util.Objects;

public class Bonfire extends BackgroundObject {
    private final ArrayList<Fuel> fuel;

    public Bonfire(ArrayList<Fuel> fuel){
        super("Bonfire", "Forest");
        this.fuel = fuel;
        if (!fuel.isEmpty()) {
            burn();
        }
    }


    public void burn() {

        class Twinkle {
            public void flash(){
                System.out.println("Twinkle flared up."); }
        }

        Twinkle twinkle = new Twinkle();

        twinkle.flash();
        for (Fuel fuelElement : fuel) {
            fuelElement.burn();
        }
    }

    public void show(Animals... animals) {
        for (Animals animal : animals) {
            animal.setVisibility(true);
        }
    }

    public void addFuel(Fuel fuel){
        this.fuel.add(fuel);
    }

    @Override
    public int hashCode(){
        return Objects.hash(fuel);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Bonfire other = (Bonfire) obj;
        return Objects.equals(fuel, other.fuel);
    }

    @Override
    public boolean setVisibility(Boolean visibility) {
        if (visibility) {
            System.out.println("Bonfire can be seen now.");
            return true;
        }
        else {
            System.out.println("Bonfire can't be seen now.");
        };
        return false;
    }

    @Override
    public boolean getVisibility() {
        return isVisible;
    }
}
