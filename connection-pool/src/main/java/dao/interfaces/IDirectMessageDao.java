package dao.interfaces;

import dao.AbstractDao;
import dao.mysqlimpl.DirectMessageDao;
import dao.mysqlimpl.UserDao;
import model.DirectMessage;
import model.User;

import java.sql.Date;
import java.util.List;

public interface IDirectMessageDao extends IQuery<DirectMessage> {

    List<DirectMessage> getAllDirectMessagesFromUser(User user);

    DirectMessage getDirectMessageFrom(User user);

    DirectMessage getDirectMessagesBetween(Date begin, Date end);
}
