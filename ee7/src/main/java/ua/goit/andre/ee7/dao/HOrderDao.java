package ua.goit.andre.ee7.dao;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.model.OrderNum;

import java.util.List;

/**
 * Created by Andre on 12.06.2016.
 */
public class HOrderDao extends Dao<OrderNum> {

    @Override
    @Transactional
    public OrderNum getById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public List<OrderNum> getByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public List<OrderNum> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from OrderNum e").list();
    }
}
