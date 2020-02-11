package com.solvd.sandinosanchez.dao.mysqlimpl;

import static com.solvd.sandinosanchez.model.Post.initializePost;
import com.solvd.sandinosanchez.utils.ClosableEntity;
import com.solvd.sandinosanchez.connectionpool.ConnectionPool;
import com.solvd.sandinosanchez.dao.AbstractDao;
import com.solvd.sandinosanchez.dao.interfaces.IPostDao;
import com.solvd.sandinosanchez.model.Post;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDao extends AbstractDao implements IPostDao {
    private static final Logger LOGGER = Logger.getLogger(PostDao.class);
    private static final String GET_MOST_LIKED_POST_BY_FIRST_NAME = "SELECT t.id, t.date_created, t.description, MAX(likes) as max_likes " +
            "FROM (SELECT p.id, p.date_created, p.description, COUNT(*) as likes FROM Posts p LEFT JOIN Likes lk ON p.id = lk.post_id " +
            "LEFT JOIN Users u ON p.user_id = u.id WHERE u.first_name = ? GROUP BY p.id) t GROUP BY t.id " +
            "ORDER BY max_likes DESC LIMIT 1";
    private static final String GET_MOST_LIKED_POST_BY_USER_ID = "SELECT t.id, t.date_created, t.description, MAX(likes) as max_likes " +
            "FROM (SELECT p.id, p.date_created, p.description, COUNT(*) as likes FROM Posts p LEFT JOIN Likes lk ON p.id = lk.post_id " +
            "LEFT JOIN Users u ON p.user_id = u.id WHERE u.id = ? GROUP BY p.id) t GROUP BY t.id " +
            "ORDER BY max_likes DESC LIMIT 1";
    private static final String DELETE_BY_ID = "DELETE FROM Posts WHERE id = ?";
    private static final String GET_ALL_POSTS = "SELECT * FROM (Posts pt LEFT JOIN Users u ON pt.user_id = u.id)" +
            "LEFT JOIN Photos ph on pt.id = ph.post_id";
    private static final String GET_ALL_POSTS_BY_USER_ID = "SELECT * FROM Posts p INNER JOIN Users u WHERE u.id = ?";

    @Override
    public Post getMostLikedPostById(long id) {
        try (ClosableEntity closableEntity = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = closableEntity.executeQuery(GET_MOST_LIKED_POST_BY_USER_ID, id);
            if (rs.next())
                return Post.initializePost(rs);
            else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public Post getMostLikedPostByFirstName(String firstName) {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_MOST_LIKED_POST_BY_FIRST_NAME, firstName);
            if (rs.next()) return Post.initializePost(rs);
                 else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public Post getMostCommentedPost() {
        return null;
    }

    @Override
    public List<Post> getAllByUserId(long id) {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL_POSTS_BY_USER_ID, id);
            List<Post> postsByUserId = new ArrayList<>();
            while(rs.next()) postsByUserId.add(initializePost(rs));
            return postsByUserId;
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public Post getById(long id) {
        return null;
    }

    @Override
    public List<Post> getAll() {
        try (ClosableEntity cs = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = cs.executeQuery(GET_ALL_POSTS);
            List<Post> posts = new ArrayList<>();
            while (rs.next())
                posts.add(initializePost(rs));
            return posts;
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateByColumn(String column, String columnValue, String columnConstrain, String valueConstrain) {

    }

    @Override
    public void deleteById(long id) {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ce.executeQuery(DELETE_BY_ID, id);
        }
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void updateByName(String name, AbstractDao dao) {

    }

    @Override
    public void updateById(long id) {

    }

    @Override
    public void insert(Statement query) {

    }
}
