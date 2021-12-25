package night;

public class Bonfire {
    private Fuel[] fuels;
    private int fuelCount;
    private Location position;

    public Bonfire(Location position, int size) {
        this.fuels = new Fuel[size];
        this.position = position;
    }

    public void startBurning() {
        Fuel next = findNextNotBurntFuel();
        next.burn();
        position.notifyAboutFire(this);
    }

    public void burn() {
        findNextNotBurntFuel().burn();
    }

    public void addFuel(Fuel fuel) {
        this.fuels[fuelCount] = fuel;
        fuelCount++;
    }

    public boolean hasFuel() {
        return true;
    }

    private Fuel findNextNotBurntFuel() {
        for (int i = 0; i < fuelCount; ++i) {
            if (!fuels[i].isBurnt()) {
                return fuels[i];
            }
        }
        return null;
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
