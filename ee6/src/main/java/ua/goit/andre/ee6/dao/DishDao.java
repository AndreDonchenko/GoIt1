package ua.goit.andre.ee6.dao;

import ua.goit.andre.ee6.model.Dish;

import java.util.List;

/**
 * Created by Andre on 29.05.2016.
 */
public interface DishDao {
    public void addDish (Dish dish);
    public void delDishById(int id);
    public List<Dish> getDishByName(String dishName);
    public List<Dish> getAllDish();
}
