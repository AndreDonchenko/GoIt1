package ua.goit.andre.ee6.dao;

import ua.goit.andre.ee6.model.Employee;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Andre on 29.05.2016.
 */
public abstract class AbstractDao<E,K> {
    public abstract void add (E entity);
    public abstract void delById (K id);
    public abstract void update(K id, E entity);
    public abstract E getById(K id);
    public abstract List<E> getByName (String name);
    public abstract List<E> getAll();

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
