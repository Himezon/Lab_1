package backgroundObject;

public class Water extends BackgroundObject{

    public Water(String name, int count){
        super(name, count);
    }

    public boolean speedMeter(){
        if ( this.getCount() > 20){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
