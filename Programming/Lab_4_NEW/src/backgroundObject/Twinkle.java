package backgroundObject;

import night.Bonfire;

import java.util.Objects;

public class Twinkle extends BackgroundObject{

    public Twinkle(String name){
        super(name, "bonfire");
    }



    @Override
    public int hashCode(){
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

    @Override
    public boolean getVisibility() {
        if (this.isVisible){
            System.out.println("Twinkle sparks and everybody can see it.");
            return true;
        } else {
            System.out.println("Twinkle went out.");
        }
        return false;
    }
}
