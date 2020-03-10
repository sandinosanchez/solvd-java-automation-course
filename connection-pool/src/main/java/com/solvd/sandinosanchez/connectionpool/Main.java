package com.solvd.sandinosanchez.connectionpool;

import com.solvd.sandinosanchez.connectionpool.dao.UserMapper;
import com.solvd.sandinosanchez.connectionpool.models.Comment;
import com.solvd.sandinosanchez.connectionpool.models.Post;
import com.solvd.sandinosanchez.connectionpool.models.User;
import com.solvd.sandinosanchez.connectionpool.pool.App;
import com.solvd.sandinosanchez.connectionpool.utils.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final int THREAD_POOL_SIZE = 20;
    private static final int AMOUNT_OF_THREADS = 50;

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//        for (int i = 0; i < AMOUNT_OF_THREADS ; i++)
//            executor.execute(new App());
//        executor.shutdown();

//        List<Thread> threads = new ArrayList<>();
//        App app = new App();
//
//        for (int i = 0; i < 20 ; i++) {
//            threads.add(new Thread(app));
//        }
//
//        threads.forEach(Thread::start);

        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);

            System.out.println(userMapper.getById(1).toString());
            JaxBList<User> users = new JaxBList<>(userMapper.getAll());
            JaxBXmlParser.serialize(users, User.class);
        }

//        LOGGER.info(Objects.requireNonNull(JaxBXmlParser.deSerialize(User.class)).toString());
    }
}
