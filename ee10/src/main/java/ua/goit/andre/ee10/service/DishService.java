package ua.goit.andre.ee10.service;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee10.dao.HCategoryDishDao;
import ua.goit.andre.ee10.dao.HDishDao;
import ua.goit.andre.ee10.model.CategoryDish;
import ua.goit.andre.ee10.model.Dish;

import java.util.List;

/**
 * Created by Andre on 07.08.2016.
 */
public class DishService {

    private HCategoryDishDao categoryDishDao;
    private HDishDao dishDao;

    public List<Dish> getAllDishes() {
        return dishDao.getAll();
    }

    public List<CategoryDish> getAllCategories() {
        return categoryDishDao.getAll();
    }

    public void addCategoryDish(CategoryDish categoryDish) {categoryDishDao.add(categoryDish);}

    public void delCategoryDish(CategoryDish categoryDish) {
        categoryDishDao.del(categoryDish);
    }

    public void saveDish(Dish dish) {
        dishDao.add(dish);
    }

    public void delDish(Dish dish) {
        dishDao.del(dish);
    }

    @Transactional
    public List <Dish> getDishesByCategoryName(CategoryDish categoryDish) {
        return dishDao.getAllByCategory(categoryDish);
    }

    @Transactional
    public Dish getDishById(Integer dishId) {
        return dishDao.getById(dishId);
    }

    public void setCategoryDishDao(HCategoryDishDao categoryDishDao) {
        this.categoryDishDao = categoryDishDao;
    }

    public void setDishDao(HDishDao dishDao) {
        this.dishDao = dishDao;
    }
}
