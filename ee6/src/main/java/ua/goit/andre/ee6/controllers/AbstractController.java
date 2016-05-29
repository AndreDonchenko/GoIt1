package ua.goit.andre.ee6.controllers;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.dao.AbstractDao;


import java.util.List;

/**
 * Created by Andre on 29.05.2016.
 */
public class AbstractController <E, K> {
    private PlatformTransactionManager txManager;
    private AbstractDao dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List <E> getAll() {
        return dao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void add(E e) {
        dao.add(e);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delById(K id) {
        dao.delById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<E> getByName(String name) {
        return dao.getByName(name);
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDao(AbstractDao dao) {
        this.dao = dao;
    }
}
