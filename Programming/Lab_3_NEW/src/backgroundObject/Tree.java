package backgroundObject;

import java.util.Objects;

public class Tree extends BackgroundObject {
    public Tree(String name, int count){
        super(name, count);
    }

    public void grow() {
        if (this.getCount() < 100) {
            System.out.println(this.getName() + " garden grows.");
        } else {
            System.out.println(this.getName() + " forest grows.");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Tree other = (Tree) obj;
        return Objects.equals(getName(), other.getName());
    }
}
