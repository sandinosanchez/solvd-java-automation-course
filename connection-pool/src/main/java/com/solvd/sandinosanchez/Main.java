package com.solvd.sandinosanchez;

import com.solvd.sandinosanchez.connectionpool.App;
import org.apache.log4j.Logger;

import java.util.concurrent.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final int THREAD_POOL_SIZE = 11;
    private static final int AMOUNT_OF_THREADS = 11;

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//        for (int i = 0; i < AMOUNT_OF_THREADS ; i++) executor.execute(new App());
//        executor.shutdown();
//        List<Thread> t = new ArrayList<>();
//        for (int i = 0; i < 50 ; i++) {
//             t.add(new Thread(new App()));
//        }
//        t.forEach(Thread::run);

        Thread t = new Thread(new App());

        t.start();
    }

}
