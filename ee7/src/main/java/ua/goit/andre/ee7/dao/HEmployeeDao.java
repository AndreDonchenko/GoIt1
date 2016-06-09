package ua.goit.andre.ee7.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.model.Employee;

import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void add(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee get(int id) {
        return null;
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list();

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
