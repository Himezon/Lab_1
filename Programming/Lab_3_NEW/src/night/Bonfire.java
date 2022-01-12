package night;

import animals.AbstractAnimals;

import java.util.Objects;

public class Bonfire{
    private Fuel[] fuels;
    private int fuelCount;
    private Location position;

    public Bonfire(Location position, int size){
        this.fuels = new Fuel[size];
        this.position = position;
    }

    public void startBurning(AbstractAnimals animals){
        Fuel next = findNextNotBurntFuel();
        next.burn();
        position.notifyAboutFire(this);
        animals.setVisible(true);
    }

    public void burn(){
        findNextNotBurntFuel().burn();
    }

    public void addFuel(Fuel fuel){
        this.fuels[fuelCount] = fuel;
        fuelCount++;
    }

    public boolean hasFuel(){
        return true;
    }

    private Fuel findNextNotBurntFuel(){
        for (int i = 0; i < fuelCount; ++i) {
            if (!fuels[i].isBurnt()) {
                return fuels[i];
            }
        }
        return null;
    }

    @Override
    public int hashCode(){
        return Objects.hash(fuels);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Bonfire other = (Bonfire) obj;
        return Objects.equals(fuels, other.fuels);
    }
}
