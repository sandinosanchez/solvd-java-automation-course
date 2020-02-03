package connectionpool;

import dao.mysqlimpl.PostDao;
import dao.mysqlimpl.UserDao;
import model.Post;
import model.User;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(App.class);
    private static List<String> queries = new ArrayList<>();

    public App(){ }

    @Override
    public void run() {
        List<User> users = new UserDao().getAll();
        users.forEach(u -> LOGGER.info(u.toString()));
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
