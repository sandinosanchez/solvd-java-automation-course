package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;

import java.sql.Statement;
import java.util.List;

public interface IQuery<T> {
    T getById(long id);

    List<T> getAll();

    void deleteById(long id);

    void updateById(long id, String column, String value);

    void save(Statement query);
}
