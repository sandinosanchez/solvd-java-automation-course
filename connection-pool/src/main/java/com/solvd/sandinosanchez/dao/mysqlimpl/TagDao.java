package com.solvd.sandinosanchez.dao.mysqlimpl;

import com.solvd.sandinosanchez.dao.AbstractDao;
import com.solvd.sandinosanchez.dao.interfaces.IQuery;
import com.solvd.sandinosanchez.model.Tag;

import java.sql.Statement;
import java.util.List;

public class TagDao extends AbstractDao implements IQuery<Tag> {

    @Override
    public Tag getById(long id) {
        return null;
    }

    @Override
    public List<Tag> getAll() {
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
