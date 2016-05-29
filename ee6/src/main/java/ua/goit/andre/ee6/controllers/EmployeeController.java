package ua.goit.andre.ee6.controllers;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.dao.EmployeeDao;
import ua.goit.andre.ee6.model.Employee;

import java.util.List;

/**
 * Created by Andre on 29.05.2016.
 */
public class EmployeeController {

    private PlatformTransactionManager txManager;
    private EmployeeDao employeeDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delEmployeeById(int id) {
        employeeDao.delEmployeeById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
