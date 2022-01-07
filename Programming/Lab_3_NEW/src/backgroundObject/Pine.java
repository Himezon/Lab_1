package backgroundObject;

import Animals.AbstractAnimals;

import java.util.Objects;

public class Pine extends BackgroundObject {
    private boolean startPosition;
    public Pine(String name, int count) {
        super(name, count);
        startPosition = true;
    }

    public boolean changeStartPosition(){
       return startPosition = !startPosition;
    }

    public String Msg(int animalsCount) {
        if (animalsCount < 1) {
            return "The pine is lying quietly in place";
        } else if (!startPosition) {
            return "They pushed the pine into the fire.";
        } else {
            return "They tried to push the pine into the fire.";
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
        Pine other = (Pine) obj;
        return Objects.equals(getName(), other.getName());
    }
}
