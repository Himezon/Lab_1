package backgroundObject;

import java.util.Objects;

public class Ground extends BackgroundObject implements GroundInteface {

    protected final int density;
    public Grass grass;

    public Ground(String name, int density, String grassName){
        super(name, "everywhere");
        this.density = density;
        this.grass = new Grass(grassName);
    }

    public Ground(String name, int density) {
        super(name, "everywhere");
        this.density = density;
    }


    public static class Grass extends BackgroundObject {

        public Grass(String name) {
            super(name, "ground");
        }

        public void grow(){
            System.out.println("Grass grows.");
        }

        @Override
        public boolean getVisibility() {
            if (this.isVisible) {
                System.out.println("Grass can be seen around the fire");
                return true;
            } else {
                System.out.println("Grass can not be seen around the fire");
            }
            return false;
        }
    }

    @Override
    public boolean hardnessTest() {
        if (density < 3) {
            System.out.println(name + " is soft.");
            return true;
        } else {
            System.out.println(name + " is solid.");
        }
        return false;
    }

    @Override
    public boolean getVisibility() {
        if (this.isVisible) {
            System.out.println("Ground can be seen around the fire");
            return true;
        } else {
            System.out.println("Ground can not be seen around the fire");
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCount());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Ground other = (Ground) obj;
        return Objects.equals(getName(), other.getName()) && getCount() == other.getCount();
    }
}
