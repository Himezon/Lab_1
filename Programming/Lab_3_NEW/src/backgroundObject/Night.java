package backgroundObject;

public class Night extends BackgroundObject{

    public Night(String name){
        super(name);
    }

    public void was(NightEnum nightEnum1, NightEnum nightEnum2, NightEnum nightEnum3){
        System.out.println(this.getName() + " была " + nightEnum1.getName() + ", " + nightEnum2.getName()
                + ", " + nightEnum3.getName() + ".");
    }
}
