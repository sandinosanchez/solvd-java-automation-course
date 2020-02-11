import connectionpool.App;
import connectionpool.ConnectionPool;
import dao.mysqlimpl.PostDao;
import dao.mysqlimpl.UserDao;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final int THREAD_POOL_SIZE = 11;
    private static final int AMOUNT_OF_THREADS = 11;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < AMOUNT_OF_THREADS ; i++) executor.execute(new App());
        executor.shutdown();
//        List<Thread> t = new ArrayList<>();
//        for (int i = 0; i < 50 ; i++) {
//             t.add(new Thread(new App()));
//        }
//        t.forEach(Thread::run);
    }

}
