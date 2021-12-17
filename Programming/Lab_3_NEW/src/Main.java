import Animals.AbstractAnimals;
import Animals.Cuckoos;
import Animals.Mosquitoes;
import TIme.TimeEnum;
import TIme.TimeImpl;
import backgroundObject.*;
import mumiTroll.MumiTrollImpl;
import mumiTroll.ObjectMumiTroll;

public class Main {
    public static void main(String[] args) {
        MumiTrollImpl mumiTroll = new MumiTrollImpl("Муми-Тролль");
        Earth earth = new Earth("земле");
        Moss moh = new Moss("мох", "мягкий");
        Forest forest = new Forest("лес", "еловый");
        Evening evening = new Evening("вечерней", "тишине");
        Cuckoos cuckoos = new Cuckoos("Кукушки");
        Evening evening1 = new Evening("вечерней", "тишине");
        Fir fir = new Fir("елей/ями", "плотной сенью");
        Mosquitoes mosquitoes = new Mosquitoes("комар/ов", "полчища");
        Water water = new Water("поток воды", "быстрый");
        Sun sun = new Sun("Солнце");
        Darkness darkness = new Darkness("темноты", "июне");
        Night night = new Night("Ночь");
        Spark spark = new Spark("искорка");
        Twinkle twinkle = new Twinkle("огонек");
        Fair fair = new Fair("костер", "крохотный");
        AbstractAnimals abstractAnimals = new AbstractAnimals("обитателей леса", "крохотных");
        Pine pine = new Pine("шишку", "еловую");
        TimeImpl time = new TimeImpl();
        Move move = new Move();

        mumiTroll.stand(earth);
        mumiTroll.bury(ObjectMumiTroll.PAWS, moh);
        forest.overgrow();

        move.choice();
        move.scan();
        if (move.next.trim().equals("День") || move.next.trim().equals("день")) {
            System.out.println("Жуки ползают, ветки трещат, ничего такого не происходит.");
        } else {
            if (move.next.trim().equals("Вечер") || move.next.trim().equals("вечер")) {

                time.changeTime(TimeEnum.EVENING);
                cuckoos.cuckoo(evening);
                mosquitoes.curled(fir);
                mosquitoes.notBite(ObjectMumiTroll.SKIN, mumiTroll);
                mumiTroll.layDown(earth, earth, moh);
                mumiTroll.seems();
                mumiTroll.dizzy(ObjectMumiTroll.HEAD);
                water.rushed();
                sun.down();
                darkness.notBe();
                night.was(NightEnum.TRANSPARENT, NightEnum.FABLED, NightEnum.MAGIC);
                spark.shallow(fir);
                twinkle.fair();
                fair.was(FairEnum.FIRS, FairEnum.STICK);
                abstractAnimals.see();
                abstractAnimals.push(pine, fair);
            } else {
                System.out.println("Некорректно введена строка");
            }

        }
    }
}
