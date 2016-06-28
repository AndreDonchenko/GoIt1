package ua.goit.andre.ee7.controllers;

import org.springframework.transaction.annotation.Transactional;

import ua.goit.andre.ee7.dao.HDishDao;
import ua.goit.andre.ee7.model.Dish;
import ua.goit.andre.ee7.model.Menu;

import java.util.List;

/**
 * Created by Andre on 06.06.2016.
 */
public class MenuController extends Controller<Menu> {

    private HDishDao dishDao;

    public void setDishDao(HDishDao dishDao) {
        this.dishDao = dishDao;
    }

    public Menu createMenu(String menuName) {
        Menu menu = new Menu();
        menu.setMenuName(menuName);
        create(menu);
        return menu;
    }

    @Transactional
    public void addDishToMenu(Menu menu, String dishName) {
        Menu dbMenu = (Menu) dao.getById(menu.getId());
        List<Dish> list = dbMenu.getDishes();
        list.addAll(dishDao.getByName(dishName));
        dbMenu.setDishes(list);
        create(dbMenu);
    }

}
