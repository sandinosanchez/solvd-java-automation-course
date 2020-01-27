import org.apache.log4j.Logger;

public class App implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(App.class);
    private ConnectionPool connectionPool;

    public App(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public App(){}

    @Override
    public void run() {
        try {
            Connection connection =  connectionPool.getConnection();
            connection.executeQuery();
            connectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
