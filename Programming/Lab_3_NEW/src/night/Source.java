package night;

public class Source implements Location{
    private boolean environmentVisible;

    public void notifyAboutFire(Bonfire fire){
        environmentVisible = true;
    }

    public EnvironmentObject[] getVisibleObjects(){
        if (!environmentVisible) {
            return new EnvironmentObject[0];
        }
        return new EnvironmentObject[0];
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
