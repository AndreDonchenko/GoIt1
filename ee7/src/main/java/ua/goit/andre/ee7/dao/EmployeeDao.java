package ua.goit.andre.ee7.dao;

import ua.goit.andre.ee7.model.Employee;

import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */

public interface EmployeeDao {
    void add(Employee employee);

    Employee get(int id);

    List<Employee> getAll();
}
