package backgroundObject;

public class Darkness extends BackgroundObject{

    public Darkness(String name, String status){
        super(name, status);
    }

    public void notBe(){
        System.out.println("но " + this.getName() + " в " + this.getStatus() + " никогда не бывает.");
    }
}
