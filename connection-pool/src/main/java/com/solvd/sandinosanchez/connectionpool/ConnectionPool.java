package com.solvd.sandinosanchez.connectionpool;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final ConnectionPool CONNECTION_POOL_SINGLETON = new ConnectionPool();
    private static final int POOL_SIZE = 9;
    private static AtomicInteger activeConnections = new AtomicInteger(0);
    private static ReentrantLock lock = new ReentrantLock(true);
    private LinkedBlockingQueue<Connection> connectionPool;

    private ConnectionPool () {
        connectionPool = new LinkedBlockingQueue<>(POOL_SIZE);
    }

    public static ConnectionPool getInstance() {
        return CONNECTION_POOL_SINGLETON;
    }

    public void releaseConnection(Connection connection) throws InterruptedException {
        lock.lock();
        try {
            connectionPool.put(connection);
            LOGGER.info(activeConnections.getAndDecrement());
        } finally {
            lock.unlock();
        }
    }

    public Connection getConnection() {
        lock.lock();
        try {
            if (activeConnections.get() < POOL_SIZE) {
                connectionPool.put(getConnectionFromPropertyFile().orElseThrow(SQLException::new));
                activeConnections.incrementAndGet();
            }
            LOGGER.info("Active connections " + activeConnections.get());
            return connectionPool.take();
        } catch (SQLException | InterruptedException e) {
            LOGGER.trace(e.getStackTrace());
        }finally {
            lock.unlock();
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

    public static AtomicInteger getActiveConnections() {
        return activeConnections;
    }

    public static void setActiveConnections(AtomicInteger activeConnections) {
        ConnectionPool.activeConnections = activeConnections;
    }

    public int getPOOL_SIZE() {
        return POOL_SIZE;
    }

    @Override
    public String toString() {
        return "com.solvd.sandinosanchez.connectionpool.ConnectionPool{" +
                "connections=" + connectionPool.toString() +
                '}';
    }
}
