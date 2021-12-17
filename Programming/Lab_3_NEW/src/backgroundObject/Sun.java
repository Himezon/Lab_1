package backgroundObject;

public class Sun extends BackgroundObject{

    public Sun(String name){
        super(name);
    }

    public void down(){
        System.out.print(this.getName() + " зашло, ");
    }
}
