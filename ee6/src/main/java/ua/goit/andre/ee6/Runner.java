package ua.goit.andre.ee6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.andre.ee6.controllers.AbstractController;
import ua.goit.andre.ee6.model.Dish;
import ua.goit.andre.ee6.model.Employee;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

/**
 * Created by Andre on 29.05.2016.
 */
public class Runner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);
    static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("application-context.xml");
        testEmployee();
        testDish();
    }

    private static void testEmployee (){
        AbstractController employeeDao = (AbstractController) context.getBean("employeeController");
        employeeDao.getAll().forEach(System.out::println);
        System.out.println("---------------");
        Employee newEmployee = new Employee();
        newEmployee.setName("Test");
        newEmployee.setSurname("Test");
        newEmployee.setPositionId(1);
        newEmployee.setPhone("test");
        newEmployee.setBirthDay(new Timestamp(new GregorianCalendar(1971,1, 1).getTimeInMillis()));
        newEmployee.setSalary(1000);
        employeeDao.add(newEmployee);
        employeeDao.getAll().forEach(System.out::println);
        System.out.println("---------------");
        employeeDao.getByName("Test").forEach(employee -> employeeDao.delById(((Employee) employee).getId()));
        employeeDao.getAll().forEach(System.out::println);
    }

    private static void testDish (){
        AbstractController dishController = (AbstractController) context.getBean("dishController");
        dishController.getAll().forEach(System.out::println);
        System.out.println("---------------");
        Dish newDish = new Dish();
        newDish.setDishName("Test");
        newDish.setCategoryId(1);
        newDish.setPrice(1);
        newDish.setWeight(1);
        dishController.add(newDish);
        dishController.getAll().forEach(System.out::println);
        System.out.println("---------------");
        dishController.getByName("Test").forEach(dish -> dishController.delById(((Dish) dish).getId()));
        dishController.getAll().forEach(System.out::println);
    }

}
