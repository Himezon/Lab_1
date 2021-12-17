package backgroundObject;

public class Water extends BackgroundObject{

    public Water(String name, String status){
        super(name, status);
    }

    public void rushed(){
        System.out.println("мимо несся " + this.getStatus() + " " + this.getName() + ".");
    }
}
