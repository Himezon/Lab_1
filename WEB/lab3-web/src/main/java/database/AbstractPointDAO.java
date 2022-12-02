package database;

import com.example.lab3web.data.Point;

import java.util.List;

public interface AbstractPointDAO {
    void addPoint(Point point);

    List<Point> getPoints();
}
