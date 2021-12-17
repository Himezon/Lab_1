package mumiTroll;

import backgroundObject.BackgroundObject;
import backgroundObject.Earth;

public class MumiTrollImpl implements MumiTroll{
    private String name;
    private ObjectMumiTroll objectMumiTroll;

    public MumiTrollImpl(String name){
        this.name = name;
    }


    @Override
    public void stand(BackgroundObject backgroundObject) {
        System.out.print(this.name + " твердо стоял на " + backgroundObject.getName() + ", ");
    }

    @Override
    public void bury(ObjectMumiTroll objectMumiTroll, BackgroundObject backgroundObject) {
        System.out.println("зарываясь " + objectMumiTroll.getName() + " в " + backgroundObject.getStatus() + " " + backgroundObject.getName() + ".");
    }

    @Override
    public void layDown(BackgroundObject backgroundObject, Earth earth, BackgroundObject backgroundObject1) {
        System.out.println(this.name + " плашмя лежал на " + backgroundObject.getName() + ", которую" + earth.overgrown() + backgroundObject1.getName() + ".");
    }

    @Override
    public void dizzy(ObjectMumiTroll objectMumiTroll) {
        System.out.print(objectMumiTroll.getName() + " все еще кружится, потому что");
    }

    @Override
    public void seems() {
        System.out.print(this.name + " думает, ");
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
