package connectionpool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DbConnection {
    private static final Logger LOGGER = Logger.getLogger(DbConnection.class);

    public Connection createConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/social_network",
                    "root",
                    "sandino37469788");
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    public static Optional<Connection> createConnection(String hostName, String userName, String password) {
        try {
            return Optional.of(DriverManager.getConnection(hostName, userName, password));
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return Optional.empty();
    }
}
