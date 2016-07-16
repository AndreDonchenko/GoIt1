package ua.goit.andre.ee7.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.dao.Dao;

import java.util.List;

/**
 * Created by Andre on 27.06.2016.
 */
public abstract class Controller <E> {
    protected Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public void create(E item) {
        dao.add(item);
    };

    @Transactional
    public List<E> getAll() {
        return dao.getAll();
    }

    @Transactional
    public E getById(Integer id) {
        return (E) dao.getById(id);
    }

    @Transactional
    public List<E> getByName(String name) {
        return (List <E>) dao.getByName(name);
    }

    @Transactional
    public void delAll() {
        dao.delAll();
    }
}
