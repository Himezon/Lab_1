package mumiTroll;

import backgroundObject.BackgroundObject;
import backgroundObject.Water;

import java.util.Objects;

public class MumiTrollImpl{
    private String name;
    private int density;

    public MumiTrollImpl(String name, int density){
        this.name = name;
        this.density = density;
    }



    public void stand(ObjectMumiTroll objectMumiTroll, BackgroundObject backgroundObject1, BackgroundObject backgroundObject2) {
        System.out.println( this.name + " standing on the " + backgroundObject1.getName() + ". "
        + backgroundObject1.hardnessTest(density) + ". "
        + objectMumiTroll.bury(backgroundObject2) + ". "
        + backgroundObject2.hardnessTest(density) + ". ");
    }

    public void layDown(ObjectMumiTroll objectMumiTroll, Water water) {
        System.out.println(this.getName() + " lay down and " + this.thinks(objectMumiTroll, water));
    }

    public String thinks(ObjectMumiTroll objectMumiTroll, Water water){
        return "thinks that " + objectMumiTroll.dizzy(water);
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, density);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        MumiTrollImpl other = (MumiTrollImpl) obj;
        return Objects.equals(name, other.name) && density == other.density;
    }
}
