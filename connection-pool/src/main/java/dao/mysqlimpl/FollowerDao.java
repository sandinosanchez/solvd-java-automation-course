package dao.mysqlimpl;

import dao.AbstractDao;
import dao.interfaces.IFollowerDao;
import model.Follower;

import java.sql.Statement;
import java.util.List;

public class FollowerDao implements IFollowerDao {
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
