package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.Employee;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 29.05.2016.
 */
public class JdbcEmployeeDao extends AbstractDao<Employee, Integer> {


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Employee employee) {
        /*
        INSERT INTO employee (name, surname, birth_date, phone, salary, position_id)
		VALUES 	('Jack', 'Daniels', '01-01-1980', '12345', '100000', (SELECT id FROM position WHERE position_name = 'Director')),
         */
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO employee (name, surname, birth_date, phone, salary, position_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString (1,employee.getName());
            statement.setString(2,employee.getSurname());
            statement.setTimestamp(3,employee.getBirthDay());
            statement.setString(4,employee.getPhone());
            statement.setDouble(5,employee.getSalary());
            statement.setInt(6,employee.getPositionId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM employee WHERE id = ?", id);
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> getByName(String name) {
        return getBySqlName("SELECT * FROM employee WHERE name LIKE ?", name);
    }

    @Override
    public List<Employee> getAll() {
        return getAllSql("SELECT * FROM employee");
    }

    @Override
    public void update(Integer id, Employee entity) {

    }

    @Override
    public Employee getById(Integer id) {
        return null;
    }

    @Override
    Employee createEntity(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setSurname(resultSet.getString("surname"));
        employee.setBirthDay(resultSet.getTimestamp("birth_date"));
        employee.setPhone(resultSet.getString("phone"));
        employee.setPositionId(resultSet.getInt("position_id"));
        employee.setSalary(resultSet.getDouble("salary"));
        return employee;
    }
}
