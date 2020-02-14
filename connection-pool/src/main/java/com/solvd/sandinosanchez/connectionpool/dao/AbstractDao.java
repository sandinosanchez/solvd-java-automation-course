package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.pool.ConnectionPool;

public abstract class AbstractDao {
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public AbstractDao() {
        connectionPool = ConnectionPool.getInstance();
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
