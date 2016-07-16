package ua.goit.andre.ee7.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.model.Dish;

import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */

public abstract class Dao <E>{

    protected SessionFactory sessionFactory;

    @Transactional
    public void add(E entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public abstract E getById(Integer id);

    public List<E> getByName(String name) {
        return null;
    };

    public abstract List<E> getAll();

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public abstract void delAll();
}
