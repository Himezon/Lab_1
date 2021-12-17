package backgroundObject;

public class Forest extends BackgroundObject{

    public Forest(String name, String status){
        super(name, status);
    }

    public void overgrow(){

        System.out.println("Тут рос " + this.getStatus() + " " + this.getName() + ".");
    }
}
