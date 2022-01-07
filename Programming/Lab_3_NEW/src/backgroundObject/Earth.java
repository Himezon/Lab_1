package backgroundObject;

import mumiTroll.MumiTrollImpl;

import java.util.Objects;

public class Earth extends BackgroundObject {

    public Earth(String name, int density){
        super(name, density);
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
        Earth other = (Earth) obj;
        return Objects.equals(getName(), other.getName());
    }
}
