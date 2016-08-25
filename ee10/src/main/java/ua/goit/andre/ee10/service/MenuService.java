package ua.goit.andre.ee10.service;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee10.dao.HMenuDao;
import ua.goit.andre.ee10.model.Menu;

import java.util.List;

/**
 * Created by Andre on 25.08.2016.
 */
public class MenuService {
    private HMenuDao menuDao;

    @Transactional
    public List<Menu> getAllMenus() {
        return menuDao.getAll();
    }

    @Transactional
    public Menu getMenuById(Integer id) {
        return menuDao.getById(id);
    }

    @Transactional
    public void setMenuDao(HMenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Transactional
    public List<Menu> getMenuByname(String name) {
        return menuDao.getByName(name);
    }
}
