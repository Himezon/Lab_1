package com.example.lab3web.beans;

import com.example.lab3web.data.Point;
import database.PointDAO;

import java.io.Serializable;
import java.util.List;

public class PointsBean implements Serializable {
    private final PointDAO pointDAO = new PointDAO();
    private List<Point> points;

    public PointsBean() {
        points = pointDAO.getPoints();
    }

    public void addPoint(Point point) {
        pointDAO.addPoint(point);
        points = pointDAO.getPoints();
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
