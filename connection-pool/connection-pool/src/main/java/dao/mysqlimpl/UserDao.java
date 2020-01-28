package dao.mysqlimpl;

import ConnectionUtils.ClosableEntity;
import connectionpool.ConnectionPool;
import dao.AbstractDao;
import dao.IUserDao;
import org.apache.log4j.Logger;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class UserDao extends AbstractDao implements IUserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class);
    private static final String GET_ALL_USERS = "SELECT * FROM Users";
    private static final String GET_USER_BY_ID = "SELECT * FROM (Users u LEFT JOIN Posts p ON u.id = p.user_id) " +
            "LEFT JOIN Genders g on u.gender_id = g.id WHERE u.id = ?";
    private static final String GET_ALL_POSTS = "SELECT * FROM (Users u LEFT JOIN Posts p ON u.id = p.user_id) " +
            "LEFT JOIN Genders g on u.gender_id = g.id";
    private static final String GET_MOST_LIKED_POST_BY_USER_ID = "SELECT p.id, COUNT(p.id) FROM Users u LEFT JOIN Posts p ON u.id = p.user_id" +
            "GROUP BY p.id WHERE u.id = ?";
    private static final String GET_MOST_LIKED_POST_BY_FIRST_NAME = "SELECT t.id, t.date_created, t.description, MAX(likes) as max_likes " +
            "FROM (SELECT p.id, p.date_created, p.description, COUNT(*) as likes FROM Posts p LEFT JOIN Likes lk ON p.id = lk.post_id " +
            "LEFT JOIN Users u ON p.user_id = u.id WHERE u.first_name = ? GROUP BY p.id) t GROUP BY t.id " +
            "ORDER BY max_likes DESC LIMIT 1";
    private static final String UPDATE = "UPDATE Users SET ? = ? WHERE ? = ?";

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private GenderDao gender;
    private List<PostDao> posts;
    private List<UserDao> followers;
    private List<DirectMessageDao> directMessages;

    public UserDao(){
        super();
        posts = new ArrayList<>();
        followers = new ArrayList<>();
        directMessages = new ArrayList<>();
    }

    public static UserDao initializeUser(Long id, String firstName, String lastName,
                                         String email, String password,GenderDao gender) {
        return new UserDao(id, firstName, lastName, email, password, gender);
    }

    public UserDao(Long id, String firstName, String lastName, String email,
                   String password, GenderDao gender) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.directMessages = new ArrayList<>();
    }

    @Override
    public void updateByName(String name, AbstractDao dao) {

    }

    @Override
    public AbstractDao getById(long id) {
        try (ClosableEntity closableEntity = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            LOGGER.info("Executing query: " + GET_USER_BY_ID);
            ResultSet rs = closableEntity.executeQuery(GET_USER_BY_ID, id);
            rs.next();
            return initializeUser(rs.getLong("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("email"),
                    rs.getString("password"), new GenderDao(rs.getString("name")));
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public List<AbstractDao> getAll() {
        try (ClosableEntity closableEntity = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            LOGGER.info("Executing query: " + GET_ALL_USERS);
            ResultSet rs = closableEntity.executeQuery(GET_ALL_USERS);
            List<AbstractDao> users = new ArrayList<>();
            while (rs.next()) {
                UserDao user = initializeUser(rs.getLong("id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email"),
                        rs.getString("password"), new GenderDao(rs.getString("name")));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(String column, String value, String columnConstrain, String valueConstrain) {
        try (ClosableEntity closableEntity = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            LOGGER.info("Executing query: " + UPDATE);
            LOGGER.info(closableEntity.executeQuery(UPDATE, column, value, columnConstrain, valueConstrain));
        }
    }

    @Override
    public void deleteById(long id) {

    }


    @Override
    public void insert(Statement query) {

    }

    @Override
    public UserDao getByName(String name) {
        return null;
    }

    @Override
    public Map<Long, UserDao> getAllPosts() {
        try (ClosableEntity closableEntity = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = closableEntity.executeQuery(GET_ALL_POSTS);
            Map<Long, UserDao> usersPosts = new HashMap<>();
            while (rs.next()) {
                if (Objects.isNull(usersPosts.get(rs.getLong("id")))) {
                    UserDao user = initializeUser(rs.getLong("id"), rs.getString("first_name"),
                            rs.getString("last_name"), rs.getString("email"),
                            rs.getString("password"), new GenderDao(rs.getString("name")));
                    usersPosts.put(rs.getLong("id"), user);
                }
                PostDao post = new PostDao(rs.getLong("id"),
                        rs.getDate("date_created"),
                        rs.getString("description"));
                usersPosts.get(rs.getLong("id")).addPost(post);
            }
            return usersPosts;
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public PostDao getMostLikedPostByFirstName(String firstName) {
        try (ClosableEntity closableEntity = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = closableEntity.executeQuery(GET_MOST_LIKED_POST_BY_FIRST_NAME, firstName);
            rs.next();
            return new PostDao(rs.getLong("id"),
                    rs.getDate("date_created"),
                    rs.getString("description"));
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public PostDao getMostLikedPostById(long id) {
        try (ClosableEntity closableEntity = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = closableEntity.executeQuery(GET_MOST_LIKED_POST_BY_USER_ID, id);
            rs.next();
            return new PostDao(rs.getLong("id"),
                    rs.getDate("date_created"),
                    rs.getString("description"));
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public PostDao getMostCommentedPost() {
        return null;
    }

    @Override
    public List<AbstractDao> getAllDirectMessages() {
        return null;
    }

    @Override
    public DirectMessageDao getDirectMessageFrom(UserDao user) {
        return null;
    }

    @Override
    public DirectMessageDao getDirectMessagesBetween(Date begin, Date end) {
        return null;
    }

    @Override
    public void deleteByName(String name) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenderDao getGender() {
        return gender;
    }

    public void setGender(GenderDao gender) {
        this.gender = gender;
    }

    public List<PostDao> getPosts() {
        return posts;
    }

    public void addPost(PostDao post) {
        this.posts.add(post);
    }

    public List<UserDao> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDao> followers) {
        this.followers = followers;
    }

    public List<DirectMessageDao> getDirectMessages() {
        return directMessages;
    }

    public void setDirectMessages(List<DirectMessageDao> directMessages) {
        this.directMessages = directMessages;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", gender=" + gender +
                ", posts=" + posts.toString() +
                ", followers=" + followers +
                ", directMessages=" + directMessages +
                '}'+ "\n";
    }

}
