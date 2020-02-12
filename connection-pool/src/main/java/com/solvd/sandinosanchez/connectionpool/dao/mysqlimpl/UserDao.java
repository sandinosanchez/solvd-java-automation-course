package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.model.*;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import com.solvd.sandinosanchez.connectionpool.pool.ConnectionPool;
import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.IUserDao;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.*;

import static com.solvd.sandinosanchez.connectionpool.model.User.initializeUser;

public class UserDao extends AbstractDao implements IUserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class);
    private static final String GET_ALL_USERS = "SELECT * FROM Users u LEFT JOIN Genders g ON u.gender_id = g.id";
    private static final String GET_USER_BY_ID = "SELECT * FROM (Users u LEFT JOIN Posts p ON u.id = p.user_id) " +
            "LEFT JOIN Genders g on u.gender_id = g.id WHERE u.id = ?";

    @Override
    public void updateByName(String name, AbstractDao dao) {

    }

    @Override
    public void updateById(long id) {

    }

    @Override
    public User getById(long id) {
        try (ClosableEntity closableEntity = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            LOGGER.info("Executing query: " + GET_USER_BY_ID);
            ResultSet rs = closableEntity.executeQuery(GET_USER_BY_ID, id);
            if (rs.next())
                return initializeUser(rs);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        try (ClosableEntity closableEntity = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = closableEntity.executeQuery(GET_ALL_USERS);
            List<User> users = new ArrayList<>();
            while (rs.next())
                users.add(initializeUser(rs));
            return users;
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

    }

    @Override
    public void insert(Statement query) {

    }

    @Override
    public User getByName(String name) {
        return null;
    }


    @Override
    public List<User> getUserWithMostPosts() {
        return null;
    }

    @Override
    public void deleteByName(String name) {

    }

}
