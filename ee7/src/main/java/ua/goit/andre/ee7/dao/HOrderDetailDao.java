package ua.goit.andre.ee7.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.model.OrderDetail;
import ua.goit.andre.ee7.model.OrderNum;

import java.util.List;

/**
 * Created by Andre on 12.06.2016.
 */
public class HOrderDetailDao extends Dao<OrderDetail> {

    @Override
    @Transactional
    public OrderDetail getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from OrderDetail o where o.id = :id");
        query.setParameter("id",id);
        return (OrderDetail) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<OrderDetail> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from OrderDetail e").list();
    }

}
