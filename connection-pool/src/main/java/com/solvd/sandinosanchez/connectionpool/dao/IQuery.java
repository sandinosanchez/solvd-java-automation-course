package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;

import java.sql.Statement;
import java.util.List;

public interface IQuery<T> {
    T getById(long id);

    List<? extends T> getAll();

    void updateByColumn(String column, String columnValue, String columnConstrain, String valueConstrain);

    void deleteById(long id);

    void deleteByName(String name);

    void updateByName(String name, AbstractDao dao);

    void updateById(long id);

    void insert(Statement query);
}
