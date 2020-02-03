package dao.mysqlimpl;

import ConnectionUtils.ClosableEntity;
import connectionpool.ConnectionPool;
import dao.AbstractDao;
import dao.interfaces.IDirectMessageDao;
import model.DirectMessage;
import model.User;

import java.sql.Date;
import java.sql.Statement;
import java.util.List;

public class DirectMessageDao extends AbstractDao implements IDirectMessageDao {
    private static final String GET_ALL = "SELECT * FROM DirectMessages";

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
