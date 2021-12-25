package Animals;

import backgroundObject.Pine;

public class AbstractAnimals extends Animals{
    private int thrustCounter;
    public AbstractAnimals(String name, int count){
        super(name, count);
        thrustCounter = 1;
    }

    public int summaryThrust(){
        return this.thrustCounter * this.getCount();
    }

    public void move(Pine pine){
        if (pine.getCount() - this.summaryThrust() < 0){
            pine.changeStartPosition();
        }
        System.out.println(pine.Msg());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
