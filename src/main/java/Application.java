import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

        try(final Connection connection = DriverManager
                .getConnection(ConnectionUtils.url, ConnectionUtils.user, ConnectionUtils.password);){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM employee FULL OUTER JOIN city ON employee.city_id = city.city_id WHERE id = (?)");
            statement.setInt(1,1);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String firstname = "Имя: " + resultSet.getString("first_name");
                String lastname = "Фамилия: " + resultSet.getString("last_name");
                String gender = "Пол: " + resultSet.getString("gender");
                String age = "Возраст: " + resultSet.getString("age");
                String city = "Город: " + resultSet.getString("city_name");

                System.out.println(firstname);
                System.out.println(lastname);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(city);


                }
            // Тест EmployeeDAOImpl
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//                Employee employee = new Employee("Иван", "Иванов", "м", 20, 1);
//                employeeDAO.create(employee);
//                employeeDAO.deleteById(0);
            for (Employee employee :
                    employeeDAO.readAll()) {
                System.out.println(employee);
            }
        }
    }
}
