package backgroundObject;

public class Fair extends BackgroundObject{

    public Fair(String name, String status){
        super(name, status);
    }

    public void was(FairEnum fairEnum1, FairEnum fairEnum2){
        System.out.print("Это был " + this.getStatus() + " " + this.getName() + " из " +
                fairEnum1.getName() + " и " + fairEnum2.getName() + ", и ");
    }
}
