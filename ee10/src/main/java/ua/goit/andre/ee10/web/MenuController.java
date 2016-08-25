package ua.goit.andre.ee10.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.andre.ee10.model.Menu;
import ua.goit.andre.ee10.service.MenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 25.08.2016.
 */
@RestController
public class MenuController {

    private MenuService menuService;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public List<String> Menus() {
        List<String> menus = new ArrayList<>();
        for (Menu m : menuService.getAllMenus()) {
            menus.add(m.getMenuName());
        }
        return menus;
    }

    @RequestMapping(value = "/menu/{menuId}", method = RequestMethod.GET)
    public Menu menuById(@PathVariable(value = "menuId") Integer menuId) {
        Menu menu = menuService.getMenuById(menuId);
        return menu;
    }

    @RequestMapping(value = "/menu/name/{menuName}", method = RequestMethod.GET)
    public List<Menu> menuByName(@PathVariable(value = "menuName") String menuName) {
        return menuService.getMenuByname(menuName);
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

}
