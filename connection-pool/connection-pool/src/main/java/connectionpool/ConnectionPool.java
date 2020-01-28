package connectionpool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static ConnectionPool singletonConnectionPool;
    private final int POOL_SIZE = 10;
    private LinkedBlockingQueue<Connection> dbConnectionPool;

    private ConnectionPool () {
        dbConnectionPool = new LinkedBlockingQueue<>(POOL_SIZE);
    }

    private static ConnectionPool createConnectionPool() {
        singletonConnectionPool = new ConnectionPool();
        return singletonConnectionPool;
    }

    public synchronized static ConnectionPool getInstance() {
        return Objects.isNull(singletonConnectionPool) ? createConnectionPool() : singletonConnectionPool;
    }

    @Override
    public String toString() {
        return "connectionpool.ConnectionPool{" +
                "connections=" + dbConnectionPool.toString() +
                '}';
    }

    public void releaseConnection(Connection dbConnection) throws InterruptedException {
        dbConnectionPool.put(dbConnection);
    }

    public Connection getConnectionLambda(Function<DbConnection, Connection> dbConnectionConsumer){
        return dbConnectionConsumer.apply(new DbConnection());
    }

    public Connection getConnection() {
        try {
            dbConnectionPool.put(getConnectionLambda(DbConnection::createConnection));
            return dbConnectionPool.take();
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    public void closeAllConnections() {
    }

//    public Queue<connectionpool.DbConnection> getDbConnectionPool() {
//        return dbConnectionPool;
//    }

//    public void setDbConnectionPool(LinkedBlockingQueue<connectionpool.DbConnection> dbConnectionPool) {
//        this.dbConnectionPool = dbConnectionPool;
//    }

    public int getPOOL_SIZE() {
        return POOL_SIZE;
    }

}
