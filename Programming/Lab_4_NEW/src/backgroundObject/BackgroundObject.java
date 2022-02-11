package backgroundObject;

import misc.Placeable;
import misc.Visible;
import misc.Moveable;

public abstract class BackgroundObject implements Visible, Placeable {
    protected final String name;
    protected final String position;
    protected int count;
    protected boolean isVisible;
    protected Moveable moveable;

    public BackgroundObject(String name, int count, String position) {
        this.name = name;
        this.count = count;
        this.position = position;
    }

    public BackgroundObject(String name, String position) {
        this.name = name;
        this.position = position;
    }


    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public String getPosition() {
        return position;
    }

    public boolean setVisibility(Boolean isVisible) {
        this.isVisible = isVisible;
        if (isVisible) {
            System.out.println(this.name + " became visible.");
            return true;
        } else {
            System.out.println(this.name + " became invisible.");
        }
        return false;
    }

    @Override
    public void moveInside(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void moveOutside() {
        this.moveable = null;
    }

    public abstract boolean getVisibility();

}

