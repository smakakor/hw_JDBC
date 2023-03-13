import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);

    Employee readBy(int id);

    List<Employee> readAll();

    void updateAmountById(Employee employee);

    void deleteById(Employee employee);
}
