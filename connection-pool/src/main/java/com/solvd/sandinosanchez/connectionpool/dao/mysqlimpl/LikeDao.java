package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.ILikeDao;
import com.solvd.sandinosanchez.connectionpool.models.Like;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LikeDao extends AbstractDao implements ILikeDao {
    private static final Logger LOGGER = Logger.getLogger(LikeDao.class);
    private static final String GET_ALL = "SELECT * FROM Likes";
    private static final String GET_BY_ID = "SELECT * FROM Likes WHERE id = ?";
    private static final String GET_ALL_BY_POST_ID = "SELECT * FROM Likes WHERE post_id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Likes WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Likes SET ? = ? WHERE id = ?";

    @Override
    public Like getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeLike(rs);
            else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<? extends Like> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Like> likes = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) likes.add(initializeLike(rs));
                return likes;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Like> getAllByPostId(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL_BY_POST_ID, id);
            List<Like> likes = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) likes.add(initializeLike(rs));
                return likes;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ce.executeDelete(DELETE_BY_ID, id);
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

    public Like initializeLike(ResultSet rs) throws SQLException  {
        return new Like(rs.getLong("id"), rs.getDate("date_liked"));
    }
}
