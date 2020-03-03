package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.ICommentDao;
import com.solvd.sandinosanchez.connectionpool.models.Comment;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDao extends AbstractDao implements ICommentDao {
    private static final Logger LOGGER = Logger.getLogger(CommentDao.class);
    private static final String GET_ALL = "SELECT * FROM Comments";
    private static final String GET_ALL_BY_POST_ID = "SELECT * FROM Comments WHERE post_id = ?";
    private static final String GET_BY_ID = "SELECT * FROM Comments WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Comments WHERE id = ?";
    private static final String UPDATE_BY_ID  = "UPDATE Comments SET ? = ? WHERE id = ?";

    @Override
    public Comment getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeComment(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Comment> getAllByPostId(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs =  ce.executeQuery(GET_ALL_BY_POST_ID, id);
            List<Comment> comments = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) comments.add(initializeComment(rs));
                return comments;
            } else throw new SQLException("Not Found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<? extends Comment> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs =  ce.executeQuery(GET_ALL);
            List<Comment> comments = new ArrayList<>();
            while (rs.next()) comments.add(initializeComment(rs));
            return comments;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {

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
    public void save(Statement query) {

    }

    public Comment initializeComment(ResultSet rs) throws SQLException {
        return new Comment(rs.getLong("id"), rs.getString("comment"));
    }
}
