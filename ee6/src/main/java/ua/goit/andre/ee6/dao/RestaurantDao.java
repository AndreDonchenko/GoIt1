package ua.goit.andre.ee6.dao;

import ua.goit.andre.ee6.model.*;

import java.util.List;

/**
 * Created by Andre on 28.05.2016.
 */
public interface RestaurantDao {



    public void addEmployee (Employee employee);
    public void delEmployeeById (int id);
    public Employee getEmployeeByName (String name);
    public List<Employee> getAllEmployee();

    public void addDish (Dish dish);
    public void delDishById(int id);
    public Dish getDishByName(String dishName);
    public List<Dish> getAllDish();

    public void addMenu (Menu menu);
    public void delMenuById(int id);
    public void addDishInMenu(int dishId, int menuId);
    public void delDishFromMenu(int dishId, int menuId);
    public Dish getMenuByName(String menuName);
    public List<Menu> getAllMenu();

    public void addOrder (OrderNum orderNum);
    public void addDishInOrder (int dishId, int orderId);
    public void delDishFromOrder (int dishId, int orderId);
    public void delOrder (int orderId);
    public void closeOrder (int orderId);
    public void getOrder (int orderId);
    public List <OrderNum> getAllOrders();

    public void addPreparedDish (PreparedDish preparedDish);
    public List<PreparedDish> getAllPreparedDish();

    public void addIngredient (Ingredient ingredient);
    public int getIngedientByName(String ingrediantName);

    public void addOnStock(int ingredientId);
    public void delFromStock(int ingredientId);
    public double getStockQty(int ingredientId);
    public void setStockQty(int ingredientId, double qty);
    public List getStockReport();
}
