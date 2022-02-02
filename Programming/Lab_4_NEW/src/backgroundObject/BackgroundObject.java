package backgroundObject;

import misc.Visible;

public abstract class BackgroundObject implements Visible {
    protected final String name;
    protected final String position;
    protected int count;
    protected boolean isVisible;

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

    public abstract boolean getVisibility();

}

