package backgroundObject;

public class Twinkle extends BackgroundObject{

    public Twinkle(String name){
        super(name);
    }

    public void fair(){
        System.out.print("вспыхнул " + this.getName() + ".");
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
