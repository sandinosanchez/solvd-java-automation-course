package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.IMessageDao;
import com.solvd.sandinosanchez.connectionpool.models.Message;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MessageDao extends AbstractDao implements IMessageDao {
    private static final Logger LOGGER = Logger.getLogger(MessageDao.class);
    private static final String GET_ALL = "SELECT * FROM Messages";
    private static final String GET_BY_ID = "SELECT * FROM Messages WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Messages SET ? = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Messages WHERE id = ?";

    @Override
    public List<? extends Message> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Message> messages = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) messages.add(initializeMessage(rs));
                return messages;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Message getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeMessage(rs);
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
    public void save(Statement query) {

    }

    public Message initializeMessage(ResultSet rs) throws SQLException {
        return new Message(rs.getLong("id"), rs.getString("message"),
                rs.getDate("date_created"));
    }
}
