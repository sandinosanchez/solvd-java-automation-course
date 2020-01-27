import java.util.concurrent.*;

public class Main {
    private static final int THREAD_POOL_SIZE = 10;
    private static final int AMOUNT_OF_THREADS = 11;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        ConnectionPool connectionPool = new ConnectionPool();

        for (int i = 0; i < AMOUNT_OF_THREADS ; i++) { ;
            executor.execute(new App(connectionPool));
        }
        executor.shutdown();
    }
}
