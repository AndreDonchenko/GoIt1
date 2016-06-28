package ua.goit.andre.ee7.controllers;

import org.hibernate.annotations.Fetch;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.dao.HDishDao;
import ua.goit.andre.ee7.dao.HEmployeeDao;
import ua.goit.andre.ee7.dao.HOrderDao;
import ua.goit.andre.ee7.dao.HOrderDetailDao;
import ua.goit.andre.ee7.model.Dish;
import ua.goit.andre.ee7.model.Employee;
import ua.goit.andre.ee7.model.OrderDetail;
import ua.goit.andre.ee7.model.OrderNum;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Andre on 12.06.2016.
 */
public class OrderController extends Controller<OrderNum> {

    private HEmployeeDao employeeDao;
    private HDishDao dishDao;
    private HOrderDetailDao orderDetailDao;
    private HOrderDao orderDao;

    @Transactional
    public OrderNum createOrder (String waiterName, int tableNum) {
        OrderNum orderNum = new OrderNum();
        List<Employee> employees = employeeDao.getByName(waiterName);
        if (employees.size() > 0) {
            orderNum.setEmployee(employees.get(0));
        } else return null;


        orderNum.setTableNum(tableNum);
        orderNum.setOpen(true);
        orderNum.setDateOrder(new Timestamp(new Date().getTime()));
        create(orderNum);
        return orderNum;
    }

    @Transactional
    public void addDishToOrder(OrderNum orderNum, String dishName, double qty) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNum(orderNum);
        List<Dish> dishes = dishDao.getByName(dishName);
        if (dishes.size() > 0) {
            orderDetail.setDish(dishes.get(0));
            orderDetail.setQty(qty);
            orderDetailDao.add(orderDetail);
        }
    }

    public List<OrderNum> getOpenOrders() {
        HOrderDao orderDao = (HOrderDao) dao;
        return orderDao.getOpenOrders();
    }

    public void setOrderDetailDao(HOrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }

    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(HDishDao dishDao) {
        this.dishDao = dishDao;
    }
}
