package ua.goit.andre.ee7.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.dao.Dao;
import ua.goit.andre.ee7.model.Employee;
import ua.goit.andre.ee7.model.Position;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class EmployeeController extends Controller <Employee>{

    private Dao positionDao;

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setName("Andre");
        employee.setSurname("Donchenko");
        employee.setBirthDay(new Timestamp(new GregorianCalendar(1971,04,30).getTimeInMillis()));
        employee.setPhone("223-322-223");
        employee.setPosition((Position) positionDao.getById(1));
        employee.setSalary(25000);
        System.out.println(employee);
        create(employee);
    }


    public void delAll() {
        super.delAll();
        positionDao.delAll();
    }


    public void setPositionDao(Dao positionDao) {
        this.positionDao = positionDao;
    }

}
