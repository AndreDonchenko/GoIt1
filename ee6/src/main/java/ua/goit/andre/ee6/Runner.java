package ua.goit.andre.ee6;

import org.apache.log4j.chainsaw.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.andre.ee6.controllers.EmployeeController;
import ua.goit.andre.ee6.dao.EmployeeDao;
import ua.goit.andre.ee6.model.Employee;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Andre on 29.05.2016.
 */
public class Runner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        EmployeeController employeeDao = (EmployeeController) context.getBean("employeeController");
        employeeDao.getAllEmployee().forEach(System.out::println);
        System.out.println("---------------");
        Employee newEmployee = new Employee();
        newEmployee.setName("Test");
        newEmployee.setSurname("Test");
        newEmployee.setPositionId(1);
        newEmployee.setPhone("test");
        newEmployee.setBirthDay(new Timestamp(new GregorianCalendar(1971,1, 1).getTimeInMillis()));
        newEmployee.setSalary(1000);
        employeeDao.addEmployee(newEmployee);
        employeeDao.getAllEmployee().forEach(System.out::println);
        System.out.println("---------------");
        employeeDao.getEmployeeByName("Test").forEach(employee -> employeeDao.delEmployeeById(employee.getId()));
        employeeDao.getAllEmployee().forEach(System.out::println);

    }

}
