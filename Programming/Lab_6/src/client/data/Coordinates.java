package client.data;

import server.exceptions.IncorrectValueException;

/**
 * A class that implements work with storing the values of the coordinates of the location of persons in the collection
 */
public class Coordinates {
    private Float x; //Значение поля должно быть больше -645, Поле не может быть null
    private int y; //Максимальное значение поля: 727
    Coordinates (final Coordinates coordinates) {
        x = coordinates.x;
        y = coordinates.y;
    }
    Coordinates () {}

    public void setX (final Float x) throws IncorrectValueException {
        if (x <= -645)
            throw new IncorrectValueException("значение координаты x должно быть больше -645");
        if (x == null)
            throw new IncorrectValueException("координата x не может быть пустым");
        this.x = x;
    }

    public Float getX() {
        return x;
    }

    public void setY (final int y) throws IncorrectValueException {
        if (y > 727)
            throw new IncorrectValueException("значение координаты y должно быть не больше 727");
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString () {
        return "{\"x\" : " + Float.toString(x) + ", \"y\" : " + Integer.toString(y) + "}";
    }
}

