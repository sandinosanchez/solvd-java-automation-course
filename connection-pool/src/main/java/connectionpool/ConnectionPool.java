package connectionpool;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static ConnectionPool singletonConnectionPool;
    private final int POOL_SIZE = 10;
    private static int activeConnections;
    private LinkedBlockingQueue<Connection> connectionPool;

    private ConnectionPool () {
        connectionPool = new LinkedBlockingQueue<>(POOL_SIZE);
    }

    private static ConnectionPool createConnectionPool() {
        singletonConnectionPool = new ConnectionPool();
        setActiveConnections(0);
        return singletonConnectionPool;
    }

    public synchronized static ConnectionPool getInstance() {
        return Objects.isNull(singletonConnectionPool) ? createConnectionPool() : singletonConnectionPool;
    }

    @Override
    public String toString() {
        return "connectionpool.ConnectionPool{" +
                "connections=" + connectionPool.toString() +
                '}';
    }

    public void releaseConnection(Connection connection) throws InterruptedException {
        connectionPool.put(connection);
    }


    public Connection getConnection() {
        try {
            if (getActiveConnections() < POOL_SIZE) {
                connectionPool.put(getConnectionFromPropertyFile().orElseThrow(SQLException::new));
                incrementActiveConnections();
            }
            return connectionPool.take();
        } catch (InterruptedException | SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    private static Optional<Connection> getConnectionFromPropertyFile() {
        try {
            Properties jdbcProperties = new Properties();
            jdbcProperties.load(new FileInputStream("src/main/resources/jdbc.properties"));
             return Optional.ofNullable(DriverManager.getConnection(jdbcProperties.getProperty("jdbc.conn.url"),
                     jdbcProperties.getProperty("jdbc.username"),
                     jdbcProperties.getProperty("jdbc.password")));
        } catch (IOException | SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return Optional.empty();
    }

    public void closeAllConnections() {
    }


    public static int getActiveConnections() {
        return activeConnections;
    }

    public static void setActiveConnections(int activeConnections) {
        ConnectionPool.activeConnections = activeConnections;
    }

    public static void incrementActiveConnections() {
        activeConnections++;
    }


    public int getPOOL_SIZE() {
        return POOL_SIZE;
    }

}
