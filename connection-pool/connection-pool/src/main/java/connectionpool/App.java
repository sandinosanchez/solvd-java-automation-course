package connectionpool;

import dao.mysqlimpl.UserDao;
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
        Map<Long, UserDao> users = new UserDao().getAllPosts();
        users.forEach((id, user) -> LOGGER.info(users.entrySet().toString()));
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
