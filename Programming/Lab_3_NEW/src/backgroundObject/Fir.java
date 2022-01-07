package backgroundObject;

import java.util.Objects;

public class Fir extends BackgroundObject {

    public Fir(String name){
        super(name);
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
        Fir other = (Fir) obj;
        return Objects.equals(getName(), other.getName());
    }
}
