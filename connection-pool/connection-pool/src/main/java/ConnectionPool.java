import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class ConnectionPool implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private LinkedBlockingQueue<Connection> connectionPool;
    private final int POOL_SIZE = 10;
    public ConnectionPool () {
        connectionPool = new LinkedBlockingQueue<>(POOL_SIZE);
    }

    @Override
    public void run() {
        try {
            Connection con =  getConnection();
            con.executeQuery();
            releaseConnection(con);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ConnectionPool{" +
                "connections=" + connectionPool.toString() +
                '}';
    }

    public void releaseConnection(Connection connection) throws InterruptedException {
        connectionPool.put(connection);
    }

    public Connection getConnection() throws InterruptedException {
        Connection connection = new Connection("JDBC mock connection");

        connectionPool.put(connection);
        return connectionPool.take();
    }

    public void closeAllConnections() {
    }

    public Queue<Connection> getConnectionPool() {
        return connectionPool;
    }

    public void setConnectionPool(LinkedBlockingQueue<Connection> connectionPool) {
        this.connectionPool = connectionPool;
    }

    public int getPOOL_SIZE() {
        return POOL_SIZE;
    }

    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 25; i++) threads.add(new Thread(pool));

        threads.forEach(Thread::start);

    }


}
