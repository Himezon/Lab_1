package database;

import com.example.lab3web.data.Point;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PointDAO implements AbstractPointDAO {
    public void addPoint(Point point) {
        SessionFactory factory = HibernateSessionFactoryUtil.getSessionFactory();

        if (factory == null)
            throw new DataBaseException("Cannot connect to database");

        Session session = factory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.persist(point);

            transaction.commit();

        } catch (RuntimeException e) {
            if (transaction != null)
                transaction.rollback();
            throw new DataBaseException("Cannot add this point to database");
        } finally {
            session.close();
        }

    }

    public List<Point> getPoints() {
        SessionFactory factory = HibernateSessionFactoryUtil.getSessionFactory();

        if (factory == null)
            throw new DataBaseException("Cannot connect to database");

        Session session = factory.openSession();

        Query query = session.createQuery("FROM Point", Point.class);

        List<Point> result = query.getResultList();
        session.close();

        return result;
    }
}
