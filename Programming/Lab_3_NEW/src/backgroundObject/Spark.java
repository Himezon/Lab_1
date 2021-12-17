package backgroundObject;

public class Spark extends BackgroundObject{

    public Spark(String name){
        super(name);
    }

    public void shallow(BackgroundObject backgroundObject){
        System.out.print("Под " + backgroundObject.getName() + " мелькнула " + this.getName() + " и ");
    }
}
