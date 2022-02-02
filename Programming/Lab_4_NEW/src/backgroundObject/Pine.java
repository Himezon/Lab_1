package backgroundObject;

import java.util.Objects;

public class Pine extends BackgroundObject{

    public Pine(String name, int count, String position){
        super(name, count, position);
    }

    @Override
    public boolean getVisibility() {
        if (this.isVisible){
            System.out.println("Pine is visible.");
            return true;
        } else {
            System.out.println("Pine is invisible");
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName(), getCount(), position);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Pine otherPine = (Pine) obj;
        return Objects.equals(getName(), otherPine.getName()) && getCount() == otherPine.getCount() && position == otherPine.position;
    }
}
