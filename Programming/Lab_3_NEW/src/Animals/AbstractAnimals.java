package animals;

import backgroundObject.Pine;

import java.util.Objects;

public class AbstractAnimals extends Animals{

    private int thrustCounter;
    private boolean visible;

    public AbstractAnimals(String name, int count){
        super(name, count);
        thrustCounter = 1;
        visible = false;
    }

    public int summaryThrust(){
        return this.thrustCounter * this.getCount();
    }

    public void move(Pine pine){
        if (pine.getCount() - this.summaryThrust() < 0){
            pine.changeStartPosition();
        }
        System.out.println(pine.Msg());
    }

    public void  setVisible(boolean visible){
        this.visible = visible;
    }

    public boolean getVisible(){
        return visible;
    }

    public String chekVisible(){
        if (this.getVisible()){
            return "Beasts can be seen around the fire";
        } else {
            return "Beasts are not visible around the fire";
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName(), getCount(), thrustCounter, visible);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        AbstractAnimals other = (AbstractAnimals) obj;
        return Objects.equals(getName(), other.getName()) && getCount() == other.getCount() &&
                thrustCounter == other.thrustCounter && visible == other.visible;
    }
}
