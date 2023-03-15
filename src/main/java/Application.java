import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        Employee employee = new Employee("Test", "Test", "test", 1, 1);
//        Employee employee1 = new Employee("Test1", "Test1", "test1", 1, 1);
//        employeeDAO.create(employee);
//
        System.out.println(employeeDAO.readBy(0));
//
//        for (Employee e :
//                employeeDAO.readAll()) {
//            System.out.println(e);
//        }
//
//        employeeDAO.updateAmountById(employee1);
//        employeeDAO.deleteById(employee1);


        CityDAO cityDAO = new CityDAOImpl();
        City city = new City("Инополис");
//      cityDAO.create(city);
        System.out.println(cityDAO.readBy(7));
        for (City c:
             cityDAO.readAll()) {
            System.out.println(c);
        }
        City city1 = new City(7,"Рязань");
        cityDAO.updateAmountById(city1);
        System.out.println(cityDAO.readBy(7));
        cityDAO.deleteById(city);
    }
}
