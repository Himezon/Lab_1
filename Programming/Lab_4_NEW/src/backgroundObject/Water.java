package backgroundObject;

import java.util.Objects;

public class Water extends BackgroundObject{

    public Water(String name){
        super(name, "river");
    }

//    public boolean speedMeter(){
//        return this.getCount() > 20;
//    }

    @Override
    public int hashCode(){
        return Objects.hash(getName(), getCount());
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Water other = (Water) obj;
        return Objects.equals(getName(), other.getName()) && getCount() == other.getCount();
    }

    @Override
    public boolean getVisibility() {
        if (this.isVisible){
            System.out.println("Water is invisible.");
            return true;
        } else {
            System.out.println("Water is visible.");
        }
        return false;
    }
}
