package dao;

import dao.mysqlimpl.DirectMessageDao;
import dao.mysqlimpl.PostDao;
import dao.mysqlimpl.UserDao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface IUserDao extends IQuery{
    UserDao getByName(String name);

    Map<Long, UserDao> getAllPosts();

    PostDao getMostLikedPostById(long id);

    PostDao getMostLikedPostByFirstName(String firstName);

    PostDao getMostCommentedPost();

    List<AbstractDao> getAllDirectMessages();

    DirectMessageDao getDirectMessageFrom(UserDao user);

    DirectMessageDao getDirectMessagesBetween(Date begin, Date end);

    void deleteByName(String name);

    void updateByName(String name, AbstractDao dao);
}
