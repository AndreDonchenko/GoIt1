package ua.goit.andre.ee7.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.model.Dish;
import ua.goit.andre.ee7.model.PreparedDish;

import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class HPreparedDishDao extends Dao<PreparedDish> {

    @Override
    @Transactional
    public PreparedDish getById(Integer id) {
        return sessionFactory.getCurrentSession().load(PreparedDish.class, id);
    }

    @Override
    @Transactional
    public List<PreparedDish> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from PreparedDish e").list();
    }

    @Override
    @Transactional
    public void delAll() {
        sessionFactory.getCurrentSession().createQuery("delete from PreparedDish").executeUpdate();
    }
}
