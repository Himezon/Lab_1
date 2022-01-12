
import animals.AbstractAnimals;
import animals.Cuckoos;
import animals.Mosquitoes;
import tIme.Time;
import tIme.TimeImpl;
import tIme.TimeEnum;
import backgroundObject.*;

import mumiTroll.MumiTrollImpl;
import mumiTroll.ObjectMumiTroll;
import night.*;
import night.Source;

public class Main {
    public static void main(String[] args) {
        MumiTrollImpl mumiTroll = new MumiTrollImpl("Mumitroll", 3);
        Moss moss = new Moss("Moss", 2);
        Earth ground = new Earth("Ground", 5);
        ObjectMumiTroll paw = new ObjectMumiTroll("Paw");
        Tree tree = new Tree("Coniferous", 120);
        Mosquitoes[] mosquitoes = new Mosquitoes[100];
        ObjectMumiTroll skin = new ObjectMumiTroll("Skin");
        Time time = new TimeImpl("summer");
        Cuckoos cuckoos = new Cuckoos("Cuckoos");
        Fir fir = new Fir("Firs");
        ObjectMumiTroll head = new ObjectMumiTroll("Head");
        Water water = new Water("Water", 30);
        Sun sun = new Sun("Sun");
        AbstractAnimals abstractAnimals = new AbstractAnimals("Abstract animals", 10);
        Pine pine = new Pine("Pine", 70);

        for (int i = 1; i < mosquitoes.length; i++){
            mosquitoes[i] = new Mosquitoes("Mosquito" + i);
        }
        for (int i = 1; i < mosquitoes.length; i++){
            mosquitoes[i].damage(skin);
        }

        mumiTroll.stand(paw, ground, moss);
        tree.grow();

        time.changeTime(TimeEnum.EVENING);
        skin.setSkinThickness("hard");
        cuckoos.cuckoo();
        for (int i = 1; i < mosquitoes.length; i++){
            mosquitoes[i].flew(tree);
        }
        for (int i = 1; i < mosquitoes.length; i++){
            mosquitoes[i].damage(skin);
        }
        skin.checkStatus();
        mumiTroll.layDown(head, water);
        sun.down(time);

        time.changeTime(TimeEnum.NIGHT);

        Location location = new Source();
        Bonfire fire = new Bonfire(location, 10);
        fire.addFuel(new Needles());
        fire.addFuel(new Needles());
        fire.addFuel(new Needles());
        fire.addFuel(new Twig());
        fire.startBurning(abstractAnimals);
        abstractAnimals.chekVisible();

        abstractAnimals.move(pine);
    }
}
