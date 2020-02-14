package com.solvd.sandinosanchez.connectionpool.utils;

import com.solvd.sandinosanchez.connectionpool.pool.ConnectionPool;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.Objects;

public class ClosableEntity implements AutoCloseable {
    private static final Logger LOGGER = Logger.getLogger(ClosableEntity.class);
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement statement;

    public ClosableEntity(Connection connection) {
        this.connection = connection;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        LOGGER.info("Executing query: " + query);
        resultSet = connection.prepareStatement(query).executeQuery();
        return resultSet;
    }

    public ResultSet executeQuery(String query, Date begin, Date end) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setDate(1, begin);
        statement.setDate(2, end);
        LOGGER.info("Executing query: " + query);
        resultSet = statement.executeQuery();
        return resultSet;
    }

    public void executeUpdate(String query,  long id, String column, String value) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setString(1, column);
        statement.setString(2, value);
        statement.setLong(3, id);
        LOGGER.info("Executing query:" + statement.toString());
        statement.executeUpdate();
    }

    public void executeDelete(String query, long id) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        LOGGER.info("Executing query:" + statement.toString());
        statement.executeQuery();
    }

    public ResultSet executeQuery(String query, String parameter) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setString(1, parameter);
        LOGGER.info("Executing query:" + statement.toString());
        resultSet = statement.executeQuery();
        return resultSet;
    }

    public ResultSet executeQuery(String query, long id) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        LOGGER.info("Executing query: " + statement.toString());
        resultSet = statement.executeQuery();
        return resultSet;
    }

    @Override
    public void close() {
        try {
            if (Objects.nonNull(statement))
                statement.close();
            ConnectionPool.getInstance().releaseConnection(connection);
        } catch (SQLException | InterruptedException e) {
            LOGGER.error(e);
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
