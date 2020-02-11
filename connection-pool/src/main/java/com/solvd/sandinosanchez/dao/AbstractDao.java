package com.solvd.sandinosanchez.dao;

import com.solvd.sandinosanchez.connectionpool.ConnectionPool;

public abstract class AbstractDao {
    protected static ConnectionPool connectionPool = ConnectionPool.getInstance();
    protected static final String UPDATE = "UPDATE ? SET ? = ? WHERE ? = ?";


    public AbstractDao() {
        connectionPool = ConnectionPool.getInstance();
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
