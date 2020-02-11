package com.solvd.sandinosanchez.connectionpool;

import com.solvd.sandinosanchez.dao.mysqlimpl.UserDao;
import com.solvd.sandinosanchez.model.User;
import static com.solvd.sandinosanchez.utils.JsonParser.serialize;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class App implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(App.class);
    private static List<String> queries = new ArrayList<>();

    public App(){ }

    @Override
    public void run() {
        serialize((new UserDao().getAll()));
//        User user = new UserDao().getById(1);
//        LOGGER.info(user.toString());
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
