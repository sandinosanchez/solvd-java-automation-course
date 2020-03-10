package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.models.*;
import com.solvd.sandinosanchez.connectionpool.pool.ConnectionPool;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.UserMapper;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.*;

public class UserDao extends AbstractDao implements UserMapper {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class);
    private static final String GET_ALL = "SELECT * FROM Users";
    private static final String GET_BY_ID = "SELECT * FROM Users WHERE id = ?";
    private static final String GET_BY_NAME = "SELECT * FROM Users WHERE name = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Tags WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Tags SET ? = ? WHERE id = ?";

    @Override
    public List<User> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<User> users = new ArrayList<>();
            while (rs.next()) users.add(initializeUser(rs));
            return users;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public User getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeUser(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public User getByName(String firstName) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_NAME, firstName);
            if (rs.next()) return initializeUser(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
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
    public void save(Statement query) {

    }

    public static User initializeUser(ResultSet rs) throws SQLException {
        return new User(rs.getLong("id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getString("email"));
    }
}
