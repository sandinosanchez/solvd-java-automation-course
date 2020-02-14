package com.solvd.sandinosanchez.connectionpool.pool;

import static com.solvd.sandinosanchez.connectionpool.utils.JsonParser.serialize;

import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.PostDao;
import com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl.UserDao;
import com.solvd.sandinosanchez.connectionpool.models.User;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class App implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(App.class);
    private static List<String> queries = new ArrayList<>();

    public App(){ }

    @Override
    public void run() {
        serialize((new PostDao().getAll()));
//        User user = new UserDao().getById(1);
//        LOGGER.info(user.toString());
//        List<BaseModel> users = deSerialize(User.class);
//        Objects.requireNonNull(users).forEach(u -> System.out.println(u.toString()));
    }

    public static void addQuery(String query) {
        queries.add(query);
    }

    public static List<String> getQueries() {
        return queries;
    }

    public static void setQueries(List<String> queries) {
        App.queries = queries;
    }
}
