package model;

import dao.AbstractDao;
import dao.interfaces.ILikeDao;

import java.sql.Statement;
import java.util.List;

public class Like extends BaseModel implements ILikeDao {
    @Override
    public Like getById(long id) {
        return null;
    }

    @Override
    public List<Like> getAll() {
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
