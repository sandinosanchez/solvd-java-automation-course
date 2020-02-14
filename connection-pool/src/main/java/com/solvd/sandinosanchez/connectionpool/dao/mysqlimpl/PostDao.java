package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import com.solvd.sandinosanchez.connectionpool.pool.ConnectionPool;
import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.IPostDao;
import com.solvd.sandinosanchez.connectionpool.models.Post;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDao extends AbstractDao implements IPostDao {
    private static final Logger LOGGER = Logger.getLogger(PostDao.class);
    private static final String GET_ALL = "SELECT * FROM Posts";
    private static final String GET_BY_ID = "SELECT * FROM Posts WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Posts WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Posts SET ? = ? WHERE id = ?";

    @Override
    public List<Post> getAll() {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Post> posts = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) posts.add(initializePost(rs));
                return posts;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Post getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializePost(rs);
            else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Post getMostCommentedPost() {
        return null;
    }

    @Override
    public void deleteById(long id) {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ce.executeQuery(DELETE_BY_ID, id);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void updateById(long id, String column, String value) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ce.executeUpdate(UPDATE_BY_ID, id, column, value);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void insert(Statement query) {

    }

    public static Post initializePost(ResultSet rs) throws SQLException {
        return new Post(rs.getLong("id"),
                rs.getDate("date_created"),
                rs.getString("description"));
    }
}
