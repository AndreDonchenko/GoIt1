package ua.goit.andre.ee7;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.andre.ee7.controllers.DishController;
import ua.goit.andre.ee7.controllers.EmployeeController;
import ua.goit.andre.ee7.controllers.OrderController;
import ua.goit.andre.ee7.model.Dish;
import ua.goit.andre.ee7.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {
        //employeeController.createEmployee();
        employeeController.getAll().forEach(System.out::println);
        System.out.println(employeeController.getById(33));
        employeeController.getByName("Andre").forEach(System.out::println);

        dishController.getAll().forEach(System.out::println);
        dishController.getByName("Salad").forEach(System.out::println);

        List<String> dishes = new ArrayList<>();
        dishes.add("Salad");
        dishes.add("Meat");
        orderController.createOrder("Lena",dishes,1);
        //orderController.getAll().forEach(System.out::println);
        //sessionFactory.getCurrentSession().save(employee);
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
