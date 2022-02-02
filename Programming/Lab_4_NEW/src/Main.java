import animals.AbstractAnimals;
import animals.Cuckoos;
import animals.Mosquitoes;
import backgroundObject.*;
import misc.BiteException;
import misc.Feeling;
import misc.SkinThicknessEnum;
import mumiTroll.MumiTroll;
import night.Bonfire;
import night.Needles;
import night.Twig;
import time.TimeEnum;
import time.TimeImpl;
import time.TimeInterface;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        
        MumiTroll mumiTroll = new MumiTroll("Mumitroll", SkinThicknessEnum.HARD);
        MumiTroll frekenSnork = new MumiTroll("Freken Snork", SkinThicknessEnum.MIDDLE);

        Ground ground = new Ground("Ground", 2, "ground");
        ground.grass = new Ground.Grass("Moss") {
            public void grow() {
                System.out.println("Moss grows out of water.");
            }
        };

        Tree tree = new Tree("Coniferous", ground);
        Pine pine = new Pine("Pine", 70, "on tree");
        TimeInterface time = new TimeImpl("summer");

        Mosquitoes[] mosquitoes = new Mosquitoes[4];


        Cuckoos cuckoos = new Cuckoos("Cuckoos");
        AbstractAnimals abstractAnimals = new AbstractAnimals("Abstract animals");

        Water water = new Water("Water");
        Sun sun = new Sun("Sun");

        mumiTroll.move("one tree", "another tree");
        frekenSnork.move("one tree", "another tree");
        time.changeTime(TimeEnum.NIGHT);
        ground.grass.grow();
        mumiTroll.seeObject(ground);
        frekenSnork.seeObject(ground);

        mumiTroll.stand(ground, Feeling.NICE);
        mumiTroll.bury(ground);
        tree.grow();

        time.changeTime(TimeEnum.EVENING);
        cuckoos.cuckoo();

        mumiTroll.setHealth(7);

        for (int i = 1; i < mosquitoes.length; i++) {
            mosquitoes[i] = new Mosquitoes("Mosquito" + i, i);
            mosquitoes[i].flew(tree);
        }
        for (int i = 1; i < mosquitoes.length; i++) {
            try {
                mosquitoes[i].Bite(mumiTroll);
            }
            catch(BiteException biteException){
                System.out.println(mosquitoes[i].getName() +" could not bite through the skin");
            }
        }

        mumiTroll.layDown(ground);
        mumiTroll.feelDizzy(water);

        sun.down(time);
        ground.getVisibility();

        Bonfire fire = new Bonfire(new ArrayList<>());
        fire.addFuel(new Needles());
        fire.addFuel(new Twig());

        fire.burn();

        fire.show(abstractAnimals);
        abstractAnimals.getVisibility();

        abstractAnimals.move(pine, "campfire");
    }
}
