package dao.mysqlimpl;

import dao.AbstractDao;
import dao.IQuery;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TagDao extends AbstractDao implements IQuery {
    private UserDao userTagged;
    private PhotoDao photo;

    public TagDao(){}

    public TagDao(Long id, UserDao userTagged, PhotoDao photo) {
        super(id);
        this.userTagged = userTagged;
        this.photo = photo;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDao getUserTagged() {
        return userTagged;
    }

    public void setUserTagged(UserDao userTagged) {
        this.userTagged = userTagged;
    }

    public PhotoDao getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoDao photo) {
        this.photo = photo;
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
}
