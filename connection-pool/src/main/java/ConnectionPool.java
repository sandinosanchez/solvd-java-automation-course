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
    private List<Connection> currentConnections;
    private final int POOL_SIZE = 10;
    private ThreadPoolExecutor poolExecutor;

    public ConnectionPool () {
        connectionPool = new LinkedBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            connectionPool.add(new Connection("JDBC mock connection"));
        }
        poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(POOL_SIZE);
        currentConnections = new ArrayList<>();
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
        currentConnections.remove(connection);
    }

    public Connection getConnection() throws InterruptedException {
        Connection con = connectionPool.take();
        currentConnections.add(con);
        return con;
    }

    public void closeAllConnections() {
        currentConnections.forEach(c -> {
            try {
                connectionPool.put(c);
                currentConnections.clear();
            } catch (InterruptedException e) {
                LOGGER.info(e.getMessage());
            }
        });

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

    public ThreadPoolExecutor getPoolExecutor() {
        return poolExecutor;
    }

    public void setPoolExecutor(ThreadPoolExecutor poolExecutor) {
        this.poolExecutor = poolExecutor;
    }

    public List<Connection> getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(List<Connection> currentConnections) {
        this.currentConnections = currentConnections;
    }

    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 25; i++) threads.add(new Thread(pool));

        threads.forEach(Thread::start);

    }


}
