package backgroundObject;

import java.util.Objects;

public class Twinkle extends BackgroundObject{

    public Twinkle(String name){
        super(name);
    }

    public void fair(){
        System.out.print("вспыхнул " + this.getName() + ".");
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
        Twinkle other = (Twinkle) obj;
        return Objects.equals(getName(), other.getName());
    }
}
