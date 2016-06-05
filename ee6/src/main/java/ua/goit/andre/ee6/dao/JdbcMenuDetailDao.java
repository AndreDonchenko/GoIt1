package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.MenuDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 04.06.2016.
 */
public class JdbcMenuDetailDao extends AbstractM2MDao <MenuDetail, Integer, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(MenuDetail detail) {
        // INSERT INTO menu_detail (menu_id, dish_id) VALUES ((SELECT id FROM menu WHERE menu_name = 'Meat dishes'), (SELECT id FROM dish WHERE dish_name = 'Steak'));
        addDelByKeys("INSERT INTO menu_detail (menu_id, dish_id) VALUES (?, ?)", detail.getMenuId(), detail.getDishId() );
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delByEntity(MenuDetail detail) {
        addDelByKeys("DELETE FROM menu_detail WHERE menu_id = ? AND dish_id = ?", detail.getMenuId(), detail.getDishId() );
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<MenuDetail> getById(Integer id) {
        return get("SELECT * FROM menu_detail WHERE menu_id = ? ", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<MenuDetail> getByValue(Integer value) {
        return get("SELECT * FROM menu_detail WHERE dish_id = ? ", value);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <MenuDetail> getAll() {
        return get("SELECT * FROM menu_detail", null);
    }

    @Override
    MenuDetail createEntity(ResultSet resultSet) throws SQLException {
        MenuDetail menuDetail = new MenuDetail();
        menuDetail.setId(resultSet.getInt("id"));
        menuDetail.setMenuId(resultSet.getInt("menu_id"));
        menuDetail.setDishId(resultSet.getInt("dish_id"));
        return menuDetail;
    }
}
