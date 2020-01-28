package dao.mysqlimpl;

import dao.AbstractDao;
import dao.IPostDao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PostDao extends AbstractDao implements IPostDao {
    private Date dateCreated;
    private UserDao user;
    private String description;

    public PostDao() {}

    public PostDao(long id, Date dateCreated, UserDao user, String description) {
        super(id);
        this.dateCreated = dateCreated;
        this.user = user;
        this.description = description;
    }

    public PostDao(long id, Date date_created, String description) {
        super(id);
        this.dateCreated = date_created;
        this.description = description;
    }

    @Override
    public ResultSet getUserWithMostPosts() {
        return null;
    }


    @Override
    public AbstractDao getById(long id) {
        return null;
    }

    @Override
    public List<AbstractDao> getAll() throws SQLException {
        return null;
    }

    @Override
    public void update(String column, String columnValue, String columnConstrain, String valueConstrain) {

    }


    @Override
    public void deleteById(long id) {

    }

    @Override
    public void insert(Statement query) {

    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UserDao getUser() {
        return user;
    }

    public void setUser(UserDao user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "dateCreated=" + dateCreated +
                ", description='" + description + '\'' +
                '}';
    }
}
