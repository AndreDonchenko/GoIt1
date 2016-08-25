package ua.goit.andre.ee10.service;

import ua.goit.andre.ee10.dao.HEmployeeDao;
import ua.goit.andre.ee10.dao.HOrderDao;
import ua.goit.andre.ee10.dao.HOrderDetailDao;
import ua.goit.andre.ee10.model.OrderNum;

import java.util.List;

/**
 * Created by Andre on 16.08.2016.
 */
public class OrderService {
    private HOrderDao orderDao;
    private HOrderDetailDao orderDetailDao;
    private HEmployeeDao employeeDao;

    public List<OrderNum> getAllOrders() {
        return orderDao.getAll();
    }

    public List<OrderNum> getOpenOrders() {
        return orderDao.getOpenOrders();
    }

    public List<OrderNum> getClosedOrders() {
        return  orderDao.getClosedOrders();
    }

    public OrderNum getOrder(Integer id) {
        return orderDao.getById(id);
    }

    public void setOrderDao(HOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setOrderDetailDao(HOrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }

    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
