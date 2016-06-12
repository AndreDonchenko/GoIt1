package ua.goit.andre.ee7.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.dao.HDishDao;
import ua.goit.andre.ee7.dao.HEmployeeDao;
import ua.goit.andre.ee7.dao.HOrderDao;
import ua.goit.andre.ee7.model.Dish;
import ua.goit.andre.ee7.model.Employee;
import ua.goit.andre.ee7.model.OrderNum;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Andre on 12.06.2016.
 */
public class OrderController {

    private HEmployeeDao employeeDao;
    private HDishDao dishDao;
    private HOrderDao orderDao;

    public void setOrderDao(HOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    public void createOrder (String waiterName, List<String> dishesName, int tableNum) {
        OrderNum orderNum = new OrderNum();
        List<Employee> employees = employeeDao.getByName(waiterName);
        if (employees.size() > 0) {
            orderNum.setEmployee(employees.get(0));
        } else return;

        List<Dish> dishes = new ArrayList();
        dishesName.forEach(dish -> dishes.addAll(dishDao.getByName(dish)));
        if (dishes.size() > 0) {
            orderNum.setDishes(dishes);
        } else return;

        orderNum.setTableNum(tableNum);
        orderNum.setOpen(true);
        orderNum.setDateOrder(new Timestamp(new Date().getTime()));
        orderDao.add(orderNum);
    }

    @Transactional
    public List<OrderNum> getAll() {
        return orderDao.getAll();
    }

    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(HDishDao dishDao) {
        this.dishDao = dishDao;
    }
}
