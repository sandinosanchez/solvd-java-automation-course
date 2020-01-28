package dao.mysqlimpl;

import dao.AbstractDao;
import dao.IGenderDao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GenderDao extends AbstractDao implements IGenderDao {
    private String name;

    public GenderDao(String name) {
        this.name = name;
    }

    public GenderDao(Long id, String name) {
        super(id);
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
