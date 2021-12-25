package backgroundObject;

import TIme.Time;

public class Sun extends BackgroundObject{

    public Sun(String name){
        super(name);
    }

    public void down(Time time){
        System.out.println(this.getName() + " went down but it " + time.getMsg(time.getSeason()) + ".");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
