import org.apache.log4j.Logger;

public class Connection {
    private static final Logger LOGGER = Logger.getLogger(Connection.class);
    private String name;

    public Connection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void executeQuery() throws InterruptedException {
        LOGGER.info("started");
        Thread.sleep(1000);
        LOGGER.info("finished");
    }

    @Override
    public String toString() {
        return "Connection{" +
                "name='" + name + '\'' +
                '}';
    }
}
