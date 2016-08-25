package ua.goit.andre.ee10.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.andre.ee10.Person;
import ua.goit.andre.ee10.model.Employee;
import ua.goit.andre.ee10.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Person> employee() {
        List<Person> persons = new ArrayList<>();
        for (Employee e:employeeService.getAllEmployees()) {
            persons.add(new Person(e.getName(), e.getSurname()));
        }
        return persons;
    }

    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
    public Employee employeeByID(@PathVariable(value = "employeeId") Integer employeeId) {
         return employeeService.getEmployeesById(employeeId);
    }

    @RequestMapping(value = "/employee/name/{name},{surname}", method = RequestMethod.GET)
    public List<Employee> employeeByName(@PathVariable(value = "name") String name, @PathVariable(value = "surname") String surname) {
        if(surname.equals("")) {
            return employeeService.getEmployeesByName(name);
        }
        if(name.equals("")) {
            return employeeService.getEmployeesBySurname(surname);
        }
        return employeeService.getEmployeesByNameSurname(name, surname);
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
