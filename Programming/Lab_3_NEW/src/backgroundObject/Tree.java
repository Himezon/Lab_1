package backgroundObject;

public class Tree extends BackgroundObject{
    public Tree(String name, int count){
        super(name, count);
    }

    public void grow(){
        if (this.getCount() < 100){
            System.out.println(this.getName() + " garden grows.");
        } else {
            System.out.println(this.getName() + " forest grows.");
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
