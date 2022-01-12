package backgroundObject;

import java.util.Objects;

public class Water extends BackgroundObject{

    public Water(String name, int count){
        super(name, count);
    }

    public boolean speedMeter(){
        if ( this.getCount() > 20){
            return true;
        } else {
            return false;
        }
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
        Water other = (Water) obj;
        return Objects.equals(getName(), other.getName()) && getCount() == other.getCount();
    }
}
