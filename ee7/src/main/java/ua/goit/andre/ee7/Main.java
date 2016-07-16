package ua.goit.andre.ee7;

import org.hibernate.SessionFactory;
import org.hibernate.dialect.Sybase11Dialect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.andre.ee7.controllers.*;
import ua.goit.andre.ee7.model.Dish;
import ua.goit.andre.ee7.model.Employee;
import ua.goit.andre.ee7.model.Menu;
import ua.goit.andre.ee7.model.OrderNum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;
    private MenuController menuController;
    private PreparedDishController preparedDishController;

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setPreparedDishController(PreparedDishController preparedDishController) {
        this.preparedDishController = preparedDishController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.delAll();
        //main.start();
    }

    private void delAll() {
        preparedDishController.delAll();
        orderController.delAll();
        menuController.delAll();
        dishController.delAll();
        employeeController.delAll();
    }

    private void start() {
        //employeeController.createEmployee();
        employeeController.getAll().forEach(System.out::println);
        System.out.println(employeeController.getById(33));
        employeeController.getByName("Andre").forEach(System.out::println);

        dishController.getAll().forEach(System.out::println);
        dishController.getByName("Salad").forEach(System.out::println);

        OrderNum orderNum = orderController.createOrder("Lena",1);
        orderController.addDishToOrder(orderNum,"Salad", 1.0);
        orderController.addDishToOrder(orderNum,"Meat", 2.0);

        orderController.getAll().forEach(System.out::println);


        Menu menu = menuController.createMenu("Main dishes");
        menuController.addDishToMenu(menu,"Meat");
        List<Menu> menuList = menuController.getByName("Meat dishes");
        if (menuList.size()>0) {
            menuController.addDishToMenu(menuList.get(0), "Meat");
        }

        menuController.getAll().forEach(System.out::println);


        List<OrderNum> orders = orderController.getOpenOrders();
        Dish dish=new Dish();
        OrderNum order = new OrderNum();
        for (int i = 0; i < orders.size(); i++) {
            order = orders.get(i);
            for (int j = 0; j < order.getOrderDetails().size(); j++) {
                dish = order.getOrderDetails().get(j).getDish();
                preparedDishController.createPreparedDish("John",dish.getDishName(),order);
            }
        }


        preparedDishController.getAll().forEach(System.out::println);
    }


}
