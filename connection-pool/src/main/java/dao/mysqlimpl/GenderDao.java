package dao.mysqlimpl;

import dao.AbstractDao;
import dao.interfaces.IGenderDao;
import model.Gender;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GenderDao extends AbstractDao implements IGenderDao {

    @Override
    public Gender getById(long id) {
        return null;
    }

    @Override
    public List<Gender> getAll() {
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
