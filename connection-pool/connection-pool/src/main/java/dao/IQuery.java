package dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface IQuery {
    AbstractDao getById(long id);

    List<AbstractDao> getAll() throws SQLException;

    void update(String column, String columnValue, String columnConstrain, String valueConstrain);

    void deleteById(long id);

    void insert(Statement query);
}
