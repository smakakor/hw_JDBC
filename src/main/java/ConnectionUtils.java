import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    static final String user = "postgres";
    static final String password = "78nalodo";
    static final String url = "jdbc:postgresql://localhost:5432/skypro";

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
