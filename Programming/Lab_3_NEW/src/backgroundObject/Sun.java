package backgroundObject;

import tIme.Time;

import java.util.Objects;

public class Sun extends BackgroundObject{

    public Sun(String name){
        super(name);
    }

    public void down(Time time){
        System.out.println(this.getName() + " went down bot it " + time.getMsg(time.getSeason()) + ".");
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
}
