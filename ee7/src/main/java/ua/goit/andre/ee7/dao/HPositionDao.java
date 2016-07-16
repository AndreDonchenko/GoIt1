package ua.goit.andre.ee7.dao;

import javafx.geometry.Pos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.model.Dish;
import ua.goit.andre.ee7.model.Employee;
import ua.goit.andre.ee7.model.Position;

import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class HPositionDao extends Dao<Position> {

    @Override
    @Transactional
    public Position getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Position e where e.id = :id");
        query.setParameter("id",id);
        return (Position) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Position> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Position e where e.position_name like :name");
        query.setParameter("name", name);
        return query.list();
    }


    @Override
    @Transactional
    public List<Position> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Position e").list();
    }

    @Override
    @Transactional
    public void delAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Position").executeUpdate();
    }
}
