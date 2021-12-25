package backgroundObject;

public class Pine extends BackgroundObject{
    private boolean startPosition;
    public Pine(String name, int count){
        super(name, count);
        startPosition = true;
    }

    public boolean changeStartPosition(){
        return startPosition = !startPosition;
    }

    public String Msg(){
        if (!startPosition){
            return "The little inhabitants of the forest moved the pine.";
        } else {
            return "The little inhabitants of the forest did not moved the pine.";
        }
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
