import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void create(Employee employee) {
        try (PreparedStatement statement = ConnectionUtils
                .getConnection()
                .prepareStatement(
                        "INSERT INTO employee (id, first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?), (?))")) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirstname());
            statement.setString(3, employee.getLastname());
            statement.setString(4, employee.getGender());
            statement.setInt(5, employee.getAge());
            statement.setInt(6, employee.getCityId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee readBy(int id) {
        Employee employee = new Employee();
        try (PreparedStatement statement = ConnectionUtils
                .getConnection()
                .prepareStatement(
                        "SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id WHERE id = (?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setFirstname(resultSet.getString("first_name"));
                employee.setLastname(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity(new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name")));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionUtils
                .getConnection()
                .prepareStatement("SELECT * FROM employee INNER JOIN city ON employee.city_id=city.city_id")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");

                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                City city = new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name"));

                employeeList.add(new Employee( id,first_name, last_name, gender, age, city));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public void updateAmountById(int id, int amount) {
        Employee employee = new Employee();
        try (PreparedStatement statement = ConnectionUtils
                .getConnection()
                .prepareStatement("UPDATE employee WHERE id = (?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setFirstname(resultSet.getString("first_name"));
                employee.setLastname(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setCityId(resultSet.getInt("city_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteById(int id) {
        try (PreparedStatement statement = ConnectionUtils
                .getConnection()
                .prepareStatement("DELETE FROM employee WHERE id=(?)")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
