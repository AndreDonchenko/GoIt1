package ua.goit.andre.ee10.service;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee10.dao.HEmployeeDao;
import ua.goit.andre.ee10.dao.HPositionDao;
import ua.goit.andre.ee10.model.Employee;
import ua.goit.andre.ee10.model.Position;

import java.util.List;

public class EmployeeService {

    private HEmployeeDao employeeDao;
    private HPositionDao positionDao;

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    @Transactional
    public Employee getEmployeesById(Integer id) {
        return employeeDao.getById(id);
    }

    public void save(Employee employee) {
        employeeDao.add(employee);
    }

    public void delEmployee(Employee employee) {
        employeeDao.del(employee);
    }

    public Position getPositionById(Integer id) {
        return positionDao.getById(id);
    }

    public List<Position> getAllPositions() {
        return positionDao.getAll();
    }

    public void addPosition(Position position) {positionDao.add(position);}

    public void delPosition(Position position) {positionDao.del(position);}

    public List<Employee> getEmployeesByPosition(Position position) {
        return employeeDao.getAllByPosition(position);
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeDao.getByName(name);
    }

    public List<Employee> getEmployeesBySurname(String name) {
        return employeeDao.getBySurname(name);
    }
    public List<Employee> getEmployeesByNameSurname(String name, String Surname) {
        return employeeDao.getByNameSurname(name, Surname);
    }



    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setPositionDao(HPositionDao positionDao) {
        this.positionDao = positionDao;
    }
}


