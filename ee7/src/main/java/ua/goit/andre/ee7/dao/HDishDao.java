package ua.goit.andre.ee7.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.model.Dish;
import ua.goit.andre.ee7.model.Employee;

import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class HDishDao extends Dao<Dish> {

    @Override
    @Transactional
    public Dish getById(Integer id) {
        return sessionFactory.getCurrentSession().load(Dish.class, id);
    }

    @Override
    @Transactional
    public List<Dish> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Dish e where e.dishName like :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    @Transactional
    public List<Dish> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Dish e").list();
    }

    @Override
    @Transactional
    public void delAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Dish").executeUpdate();
    }

}
