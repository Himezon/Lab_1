package night;

public class Fuel {

    protected final String name;

    protected Fuel(String name) {
        this.name = name;
    }

    protected Fuel() {
        this.name = this.getClass().getSimpleName();
    }

    public void burn() {
        System.out.println("A " + name + " was burning in the fire.");
    }


}