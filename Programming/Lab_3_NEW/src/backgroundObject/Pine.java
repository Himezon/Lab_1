package backgroundObject;

import java.util.Objects;

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
        return Objects.hash(getName(), getCount(), startPosition);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Pine other = (Pine) obj;
        return Objects.equals(getName(), other.getName()) && getCount() == other.getCount() && startPosition == other.startPosition;
    }
}
