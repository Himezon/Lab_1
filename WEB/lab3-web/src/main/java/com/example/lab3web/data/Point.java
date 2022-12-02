package com.example.lab3web.data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="gdapoints")
public class Point implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private int x;
    private float y;
    private float r;
    private boolean isHit;
    private String timeScript;

    public Point() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public String getTimeScript() {
        return timeScript;
    }

    public void setTimeScript(String timeScript) {
        this.timeScript = timeScript;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
