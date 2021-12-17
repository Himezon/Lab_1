package Animals;

import backgroundObject.BackgroundObject;
import mumiTroll.MumiTrollImpl;
import mumiTroll.ObjectMumiTroll;

public class Mosquitoes extends Animals{

    public Mosquitoes(String name, String status){
        super(name, status);
    }

    public void curled(BackgroundObject backgroundObject){
        System.out.println("Под " + backgroundObject.getStatus() + " " + backgroundObject.getName() +
                " вились " + this.getStatus() + " " + this.getName() + ".");
    }

    public void notBite(ObjectMumiTroll objectMumiTroll, MumiTrollImpl mumiTroll){
        System.out.println("К счастью, " + this.getName() + " не может прокусть " + objectMumiTroll.getName()
                + " " + mumiTroll.getName() + ".");
    }
}
