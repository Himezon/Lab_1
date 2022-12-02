package com.example.lab3web.beans;

import com.example.lab3web.HitChecker;
import com.example.lab3web.data.Point;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ProcessBean implements Serializable {
    private CoordinatesBean coordinatesBean;
    private PointsBean pointsBean;

    private final HitChecker hitChecker = new HitChecker();

    public ProcessBean() {

    }

    public void processNewValue() {
        long startTime = System.nanoTime();

        Point point = new Point();

        point.setDate(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss - VV O")));
        point.setX(coordinatesBean.getX());
        point.setY(coordinatesBean.getY());
        point.setR(coordinatesBean.getR());

        point.setHit(hitChecker.isHit(point.getX(), point.getY(), point.getR()));

        long endTime = System.nanoTime();
        point.setTimeScript(new DecimalFormat("#0.00").format((endTime-startTime)*Math.pow(10, -6)));

        pointsBean.addPoint(point);
    }

    public CoordinatesBean getCoordinatesBean() {
        return coordinatesBean;
    }

    public void setCoordinatesBean(CoordinatesBean coordinatesBean) {
        this.coordinatesBean = coordinatesBean;
    }

    public PointsBean getPointsBean() {
        return pointsBean;
    }

    public void setPointsBean(PointsBean pointsBean) {
        this.pointsBean = pointsBean;
    }
}
