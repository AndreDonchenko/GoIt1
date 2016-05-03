package ua.goit.andre.ee5.firstspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Bootstrap {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "aop-context.xml");
        ConsoleCalculator calculator = applicationContext.getBean("calculator", ConsoleCalculator.class);
        calculator.execute();
    }
}
