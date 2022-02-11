package mumiTroll;

import backgroundObject.BackgroundObject;
import backgroundObject.Ground;
import misc.*;

import java.util.Objects;

public class MumiTroll implements Moveable {

    protected int health = 4;
    private final String name;
    private SkinThicknessEnum skinThickness;
    protected Placeable place;


    public MumiTroll(String name, SkinThicknessEnum skinThickness) {
        this.name = name;
        this.health = skinThickness.ordinal() + 1;
    }

    public SkinThicknessEnum getSkinThickness(){
        return skinThickness;
    }

    public void bury(Ground ground) {
        try {
                if (ground.hardnessTest()) {
                    System.out.println(name + " buried in the " + ground.getName() + ".");
                }
                else {
                    throw new BuryException();
                }
            }
        catch (BuryException buryException) {
            System.out.println("Bury exception happened!");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public void move(BackgroundObject place) {
        if (this.place != null) {
            this.place.moveOutside();
        }
        this.place = place;
        place.moveInside(this);
        System.out.printf("Объект %s переместился в область %s %n", this.getClass().getSimpleName(), place.getName());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) throws HealthException {
        if (health < 1 || health > 999) {
            throw new HealthException();
        }
        this.health = health;
    }

    /*
    public void addHealth(int health) {
        if (health < 1 || health > 999) {
            throw new HealthException();
        }
        this.health += health;
    }
    */

    public void decHealth(int health){
        if (health < 1 || health > 999) {
            throw new HealthException();
        }
        if (this.health > health) {
            this.health -= health;
        }
        else {
            throw new RipException();
        };
    }
    /*
    public void checkStatus() {
        if (getHealth() <= 0) {
            System.out.println("Hordes of mosquitoes bit through the skin of a MumiTroll");
        } else {
            System.out.println("Hordes of mosquitoes did not bite through the skin of the MumiTroll");
        }
    }
    */
    public void stand(Ground ground, Feeling feeling) {
        System.out.println(this.name + " standing on the " + ground.getName() + " and feels " + feeling + ".");
    }

    public void layDown(Ground ground) {
        System.out.println(name + " laid down on a " + ground.getName() + ".");
    }

    public void feelDizzy(BackgroundObject causeOfDizziness) {
        System.out.println(name + " feels dizzy because of " + causeOfDizziness.getName());
    }

    public void seeObject(BackgroundObject object) {
        System.out.println(name + " sees a " + object.getName() + ".");
    }

//    public void move(String currentPosition, String destination) {
//        System.out.println(name + " moved from " + currentPosition + " to " + destination + ".");
//    };

    @Override
    public int hashCode() {
        return Objects.hash(name, skinThickness, health);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        MumiTroll other = (MumiTroll) obj;
        return Objects.equals(name, other.name) && Objects.equals(skinThickness, other.skinThickness) && health == other.health;
    }
}
