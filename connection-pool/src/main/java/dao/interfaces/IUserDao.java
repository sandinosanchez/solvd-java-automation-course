package dao.interfaces;

import dao.AbstractDao;
import dao.mysqlimpl.DirectMessageDao;
import dao.mysqlimpl.PostDao;
import dao.mysqlimpl.UserDao;
import model.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface IUserDao extends IQuery<User> {
    User getByName(String name);

    List<User> getUserWithMostPosts();

}
