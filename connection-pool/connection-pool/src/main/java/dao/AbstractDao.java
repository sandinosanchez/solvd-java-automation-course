package dao;

import connectionpool.ConnectionPool;

public abstract class AbstractDao {
    protected ConnectionPool connectionPool;
    protected Long id;

    public AbstractDao() {
        connectionPool = ConnectionPool.getInstance();
    }

    public AbstractDao(Long id) {
        connectionPool = ConnectionPool.getInstance();
        this.id = id;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public void setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
