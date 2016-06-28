package ua.goit.andre.ee7.controllers;

import ua.goit.andre.ee7.model.OrderNum;
import ua.goit.andre.ee7.model.PreparedDish;

import java.util.Date;
import java.sql.Timestamp;


/**
 * Created by Andre on 27.06.2016.
 */
public class PreparedDishController extends Controller<PreparedDish>{

    DishController dishController;
    EmployeeController employeeController;

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void createPreparedDish(String coockerName, String dishName, OrderNum orderNum) {
        PreparedDish preparedDish = new PreparedDish();
        preparedDish.setDish(dishController.getByName(dishName).get(0));
        preparedDish.setEmployee(employeeController.getByName(coockerName).get(0));
        preparedDish.setOrder(orderNum);
        preparedDish.setPrepareDate(new Timestamp(new Date().getTime()));
        dao.add(preparedDish);
    }
}
