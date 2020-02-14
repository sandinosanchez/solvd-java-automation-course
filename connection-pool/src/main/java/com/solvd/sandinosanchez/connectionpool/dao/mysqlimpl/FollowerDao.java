package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.pool.ConnectionPool;
import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.IFollowerDao;
import com.solvd.sandinosanchez.connectionpool.models.Follower;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.sandinosanchez.connectionpool.models.Follower.initializeFollower;

public class FollowerDao extends AbstractDao implements IFollowerDao {
    private static final Logger LOGGER = Logger.getLogger(FollowerDao.class);
    private static final String GET_ALL = "SELECT * FROM Followers";
    private static final String GET_BY_ID = "SELECT * FROM Followers WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Followers WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Followers SET ? = ? WHERE id = ?";

    @Override
    public List<? extends Follower> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Follower> followers = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) followers.add(initializeFollower(rs));
                return followers;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Follower getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeFollower(rs);
            else throw new SQLException("Not found");
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
}
