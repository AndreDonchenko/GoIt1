package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.Position;
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
public class JdbcPositionDao extends AbstractDao <Position, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Position position) {
        /*
            INSERT INTO Position (Position_name) VALUES ('Pork'), ('Beef'), ('Mutton'), ('Potatoes');
        */
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Position (Position_name) VALUES (?)")) {
            statement.setString (1, position.getPositionName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM Position WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, Position entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Position getById(Integer id) {
        return getBySqlId("SELECT * FROM position WHERE id = ?", id);
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <Position> getByName(String name) {
        return getBySqlName("SELECT * FROM Position WHERE Position_name LIKE ?", name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <Position> getAll() {
        return getAllSql("SELECT * FROM Position");
    }

    @Override
    Position createEntity(ResultSet resultSet) throws SQLException {
        Position position = new Position();
        position.setId(resultSet.getInt("id"));
        position.setPositionName(resultSet.getString("Position_name"));
        return position;
    }

}
