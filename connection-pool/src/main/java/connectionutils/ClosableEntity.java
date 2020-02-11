package connectionutils;

import connectionpool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Objects;

public class ClosableEntity implements AutoCloseable {
    private static final Logger LOGGER = Logger.getLogger(ClosableEntity.class);
//    private static ClosableEntity closableEntity;
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement statement;

    public ClosableEntity(Connection connection) {
        this.connection = connection;
    }

//    public synchronized ClosableEntity getInstance() {
//        return Objects.nonNull(closableEntity) ? closableEntity : new ClosableEntity()
//    }

    public ResultSet executeQuery(String query) {
        try {
            LOGGER.info("Executing query: " + query);
            resultSet = connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return resultSet;
    }

    public int executeQuery(String query, String column, String value, String columnConstrain, String valueConstrain) {
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, column);
            statement.setString(2, value);
            statement.setString(3, columnConstrain);
            statement.setString(4, valueConstrain);
            LOGGER.info(statement);
            return statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return 0;
    }

    public ResultSet executeQuery(String query, String parameter) {
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, parameter);
            LOGGER.info(statement);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return resultSet;
    }

    public ResultSet executeQuery(String query, long id) {
        try {
            statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return resultSet;
    }

    @Override
    public void close() {
        try {
            if (Objects.nonNull(statement))
                statement.close();
            ConnectionPool.getInstance().releaseConnection(connection);
            LOGGER.info("Closing resources");
        } catch (SQLException | InterruptedException e) {
            LOGGER.info(e.getMessage());
        }
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(PreparedStatement statement) {
        this.statement = statement;
    }
}
