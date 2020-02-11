package com.solvd.sandinosanchez.dao.mysqlimpl;

import static com.solvd.sandinosanchez.model.DirectMessage.initializeDirectMessage;
import com.solvd.sandinosanchez.utils.ClosableEntity;
import com.solvd.sandinosanchez.connectionpool.ConnectionPool;
import com.solvd.sandinosanchez.dao.AbstractDao;
import com.solvd.sandinosanchez.dao.interfaces.IDirectMessageDao;
import com.solvd.sandinosanchez.model.DirectMessage;
import com.solvd.sandinosanchez.model.User;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DirectMessageDao extends AbstractDao implements IDirectMessageDao {
    private static final Logger LOGGER = Logger.getLogger(DirectMessageDao.class);
    private static final String GET_ALL = "SELECT * FROM DirectMessages";
    private static final String GET_ALL_BY_USER_ID = "SELECT * FROM DirectMessages dm INNER JOIN Users u " +
            "ON u.id = dm.sender WHERE u.id = ?";


    @Override
    public List<DirectMessage> getAllByUserId(long id) {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL_BY_USER_ID, id);
            List<DirectMessage> directMessageByUserId = new ArrayList<>();
            while(rs.next()) directMessageByUserId.add(initializeDirectMessage(rs));
            return directMessageByUserId;
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    @Override
    public List<DirectMessage> getAllDirectMessagesFromUser(User user) {
        try (ClosableEntity cs = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            return null;
        }
    }

    @Override
    public DirectMessage getDirectMessageFrom(User user) {
        return null;
    }

    @Override
    public DirectMessage getDirectMessagesBetween(Date begin, Date end) {
        return null;
    }

    @Override
    public DirectMessage getById(long id) {
        return null;
    }

    @Override
    public List<DirectMessage> getAll() {
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
