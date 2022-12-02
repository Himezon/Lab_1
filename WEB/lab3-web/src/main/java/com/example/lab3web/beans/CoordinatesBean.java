package com.example.lab3web.beans;

import java.io.Serializable;

public class CoordinatesBean implements Serializable {
    private int x=-5;
    private float y=-5;
    private float r=1;

    public CoordinatesBean() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
}
