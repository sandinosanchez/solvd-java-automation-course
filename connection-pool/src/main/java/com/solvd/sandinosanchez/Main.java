package com.solvd.sandinosanchez;

import com.solvd.sandinosanchez.connectionpool.App;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final int THREAD_POOL_SIZE = 11;
    private static final int AMOUNT_OF_THREADS = 20;

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//        for (int i = 0; i < AMOUNT_OF_THREADS ; i++)
//            executor.execute(new App());
//        executor.shutdown();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 20 ; i++) {
            threads.add(new Thread(new App()));
        }

        threads.forEach(Thread::start);
    }
}
