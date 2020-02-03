package dao.interfaces;

import dao.AbstractDao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface IQuery<T> {
    T getById(long id);

    List<T> getAll();

    void updateByColumn(String column, String columnValue, String columnConstrain, String valueConstrain);

    void deleteById(long id);

    void deleteByName(String name);

    void updateByName(String name, AbstractDao dao);

    void updateById(long id);

    void insert(Statement query);
}
