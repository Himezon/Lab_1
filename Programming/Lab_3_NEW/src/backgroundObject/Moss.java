package backgroundObject;

import java.util.Objects;

public class Moss extends BackgroundObject{

    public Moss(String name, int density){
        super(name, density);
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
        Moss other = (Moss) obj;
        return Objects.equals(getName(), other.getName()) && getCount() == other.getCount();
    }
}
