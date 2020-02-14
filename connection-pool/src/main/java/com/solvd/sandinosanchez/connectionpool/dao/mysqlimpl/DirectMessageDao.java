package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import com.solvd.sandinosanchez.connectionpool.pool.ConnectionPool;
import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.IDirectMessageDao;
import com.solvd.sandinosanchez.connectionpool.models.DirectMessage;
import com.solvd.sandinosanchez.connectionpool.models.User;
import org.apache.log4j.Logger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DirectMessageDao extends AbstractDao implements IDirectMessageDao {
    private static final Logger LOGGER = Logger.getLogger(DirectMessageDao.class);
    private static final String GET_ALL = "SELECT * FROM DirectMessages";
    private static final String GET_BY_ID = "SELECT * FROM DirectMessages WHERE id = ?";
    private static final String GET_DIRECT_MESSAGE_BETWEEN = "SELECT * FROM DirectMessages WHERE date_created BETWEEN ? AND ?";
    private static final String DELETE_BY_ID = "DELETE FROM DirectMessages WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE DirectMessages SET ? = ? WHERE id = ?";

    @Override
    public DirectMessage getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next())
               return initializeDirectMessage(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public DirectMessage getDirectMessageFrom(User user) {
        return null;
    }

    @Override
    public List<DirectMessage> getDirectMessagesBetween(Date begin, Date end) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_DIRECT_MESSAGE_BETWEEN, begin, end);
            List<DirectMessage> directMessages = new ArrayList<>();
            while (rs.next()) directMessages.add(initializeDirectMessage(rs));
            return directMessages;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<DirectMessage> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<DirectMessage> directMessages = new ArrayList<>();
            while (rs.next()) directMessages.add(initializeDirectMessage(rs));
            return directMessages;
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

    public static DirectMessage initializeDirectMessage(ResultSet rs) throws SQLException {
        return new DirectMessage(rs.getLong("id"),
                rs.getDate("date_created"));
    }

    public static List<DirectMessage> initializeDirectMessages(ResultSet rs) throws SQLException {
        List<DirectMessage> directMessages = new ArrayList<>();
        while (rs.next()) directMessages.add(initializeDirectMessage(rs));
        return directMessages;
    }

}
