package ua.goit.andre.ee7.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.dao.EmployeeDao;
import ua.goit.andre.ee7.model.Employee;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setName("Andre");
        employee.setSurname("Donchenko");
        employee.setBirthDay(new Timestamp(new GregorianCalendar(1971,04,30).getTimeInMillis()));
        employee.setPhone("223-322-223");
        //employee.setPositionId(1);
        employee.setSalary(25000);

        employeeDao.add(employee);
    }

    @Transactional
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


}
