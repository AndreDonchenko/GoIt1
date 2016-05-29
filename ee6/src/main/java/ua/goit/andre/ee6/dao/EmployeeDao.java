package ua.goit.andre.ee6.dao;

import ua.goit.andre.ee6.model.Employee;

import java.util.List;

/**
 * Created by Andre on 29.05.2016.
 */
public interface EmployeeDao {
    public void addEmployee (Employee employee);
    public void delEmployeeById (int id);
    public List<Employee> getEmployeeByName (String name);
    public List<Employee> getAllEmployee();
}
