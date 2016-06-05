package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.Menu;
import ua.goit.andre.ee6.model.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 04.06.2016.
 */
public class JdbcMenuDao extends AbstractDao <Menu, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Menu menu) {
        /*
            INSERT INTO menu (menu_name) VALUES ('Meat dishes');
        */
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Menu (Menu_name) VALUES (?)")) {
            statement.setString (1, menu.getMenuName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM menu WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, Menu entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Menu getById(Integer id) {
        return getBySqlId("SELECT * FROM menu WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <Menu> getByName(String name) {
        return getBySqlName("SELECT * FROM Menu WHERE Menu_name LIKE ?", name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <Menu> getAll() {
        return getAllSql("SELECT * FROM menu");
    }

    @Override
    Menu createEntity(ResultSet resultSet) throws SQLException {
        Menu menu = new Menu();
        menu.setId(resultSet.getInt("id"));
        menu.setMenuName(resultSet.getString("Menu_name"));
        return menu;
    }
}
