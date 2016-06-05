package ua.goit.andre.ee6.controllers;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.dao.AbstractDao;
import ua.goit.andre.ee6.dao.AbstractM2MDao;

import java.util.List;

/**
 * Created by Andre on 05.06.2016.
 */
public class AbstractM2MController <E, K1, K2> {
    private PlatformTransactionManager txManager;
    private AbstractM2MDao dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List <E> getAll() {
        return dao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void add(E e) {
        dao.add(e);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delByEntity(E entity) {
        dao.delByEntity(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<E> getByid(K1 id ) {
        return dao.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<E> getByValue(K2 value) {
        return dao.getByValue(value);
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDao(AbstractM2MDao dao) {
        this.dao = dao;
    }

}
