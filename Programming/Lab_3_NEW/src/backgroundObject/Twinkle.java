package backgroundObject;

public class Twinkle extends BackgroundObject{

    public Twinkle(String name){
        super(name);
    }

    public void fair(){
        System.out.println("вспыхнул " + this.getName() + ".");
    }
}
