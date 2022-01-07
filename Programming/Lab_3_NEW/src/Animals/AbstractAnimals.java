package Animals;

import backgroundObject.Earth;
import backgroundObject.Pine;

import java.util.Objects;

public class AbstractAnimals extends Animals {
    private int thrustCounter;
    public AbstractAnimals(String name, int count) {
        super(name, count);
        thrustCounter = 1;
    }

    public int summaryThrust(){
        return this.thrustCounter * this.getCount();
    }

    public void move(Pine pine) {
        if (pine.getCount() - this.summaryThrust() < 0) {
            pine.changeStartPosition();
        }
        System.out.println(pine.Msg(this.getCount()));
    }

    public void visibility() {
        if (this.getCount() < 1) {
            System.out.println("There were no living creatures around");
        } else {
            System.out.println("Many tiny inhabitants of the forest could be seen around");
        }
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
        AbstractAnimals other = (AbstractAnimals) obj;
        return Objects.equals(getName(), other.getName());
    }
}
