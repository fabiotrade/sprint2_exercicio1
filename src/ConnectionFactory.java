import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/DB_PRODUTOS?useTimezone=true&serverTimezone=UTC", "root", "root123");

    }
}
