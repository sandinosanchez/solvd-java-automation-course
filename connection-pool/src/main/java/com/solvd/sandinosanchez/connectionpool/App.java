package com.solvd.sandinosanchez.connectionpool;

import static com.solvd.sandinosanchez.utils.JsonParser.serialize;
import static com.solvd.sandinosanchez.utils.JsonParser.deSerialize;
import com.solvd.sandinosanchez.dao.mysqlimpl.UserDao;
import com.solvd.sandinosanchez.model.BaseModel;
import com.solvd.sandinosanchez.model.User;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class App implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(App.class);
    private static List<String> queries = new ArrayList<>();

    public App(){ }

    @Override
    public void run() {
//        serialize((new UserDao().getAll()));
//        User user = new UserDao().getById(1);
//        LOGGER.info(user.toString());
        List<BaseModel> users = deSerialize(User.class);
        Objects.requireNonNull(users).forEach(u -> System.out.println(u.toString()));
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
