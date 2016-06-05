package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.MenuDetail;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 05.06.2016.
 */
public abstract class AbstractM2MDao<E, K1, K2> {
    public abstract void add (E entity);
    public abstract void delByEntity (E entity);
    public abstract List<E> getById(K1 id);
    public abstract List<E> getByValue (K2 value);
    public abstract List<E> getAll();

    @Transactional(propagation = Propagation.MANDATORY)
    List<E> get (String sql, Integer id) {
        List<E> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            if (null != id) {
                statement.setInt(1,id);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void addDelByKeys(String sql, int id1, int id2) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id1);
            statement.setInt(2,id2);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    abstract E createEntity(ResultSet resultSet) throws SQLException ;

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
