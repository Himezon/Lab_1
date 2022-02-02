package backgroundObject;

import time.TimeInterface;

import java.util.Objects;

public class Sun extends BackgroundObject{

    public Sun(String name){
        super(name, "space");
    }

    public void down(TimeInterface time){
        System.out.println(this.getName() + " went down but it " + time.getMsg(time.getSeason()) + ".");
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Sun other = (Sun) obj;
        return Objects.equals(getName(), other.getName());
    }

    @Override
    public boolean getVisibility() {
        if (this.isVisible){
            System.out.println("Sun is shining.");
            return true;
        } else {
            System.out.println("Sun is gone.");
        }
        return false;
    }
}
