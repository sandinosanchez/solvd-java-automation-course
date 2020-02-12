package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.pool.ConnectionPool;
import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.IFollowerDao;
import com.solvd.sandinosanchez.connectionpool.model.Follower;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.sandinosanchez.connectionpool.model.Follower.initializeFollower;

public class FollowerDao implements IFollowerDao {
    private static final Logger LOGGER = Logger.getLogger(FollowerDao.class);

    private static final String GET_ALL_BY_USER_ID = "SELECT * FROM Followers f INNER JOIN Users ON f.user_id = u.id WHERE u.id = ?";

    @Override
    public List<Follower> getAllByUserId(long id) {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL_BY_USER_ID, id);
            List<Follower> followerByUserId = new ArrayList<>();
            while(rs.next()) followerByUserId.add(initializeFollower(rs));
            return followerByUserId;
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public Follower getById(long id) {
        return null;
    }

    @Override
    public List<Follower> getAll() {
        return null;
    }

    @Override
    public void updateByColumn(String column, String columnValue, String columnConstrain, String valueConstrain) {

    }

    @Override
    public void deleteById(long id) {

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
