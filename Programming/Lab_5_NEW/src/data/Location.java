package data;

import exceptions.IncorrectValueException;

/**
 * A class that implements work with storing the values of the coordinates of the territory of the location of persons in the collection
 */
public class Location {
    private int x;
    private double y;
    private Integer z; //Поле не может быть null

    Location() {

    }

    Location (final Location location) {
        x = location.x;
        y = location.y;
        z = location.z;
    }

    public void setX (int x) {
        this.x = x;
    }

    public int getX () {
        return x;
    }

    public void setY (double y) {
        this.y = y;
    }

    public double getY () {
        return y;
    }

    public void setZ (Integer z) throws IncorrectValueException {
        if (z == null) {
            throw new IncorrectValueException("поле не может быть пустым");
        }
        this.z = z;
    }

    public Integer getZ () {
        return z;
    }

    @Override
    public String toString () {
        return "{\"x\" : " + Integer.toString(x) + ", \"y\" : " + Double.toString(y) + ", \"z\" : " + Integer.toString(z) + "}";
    }
}
