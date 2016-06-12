package ua.goit.andre.ee7.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee7.dao.Dao;
import ua.goit.andre.ee7.model.Dish;
import ua.goit.andre.ee7.model.Employee;

import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class DishController {

    private Dao dishDao;

    public void setDishDao(Dao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public void createDish() {
        Dish dish = new Dish();

/*        dish.setCategoryDish().setName("Andre");
        dish.setSurname("Donchenko");
        employee.setBirthDay(new Timestamp(new GregorianCalendar(1971,04,30).getTimeInMillis()));
        employee.setPhone("223-322-223");
        //employee.setPositionId(1);
        employee.setSalary(25000);
*/
        dishDao.add(dish);
    }

    @Transactional
    public List<Dish> getAll() {
        return dishDao.getAll();
    }

    @Transactional
    public Dish getById(Integer id) {
        return (Dish) dishDao.getById(id);
    }

    @Transactional
    public List<Dish> getByName(String name) {
        return dishDao.getByName(name);
    }

}
