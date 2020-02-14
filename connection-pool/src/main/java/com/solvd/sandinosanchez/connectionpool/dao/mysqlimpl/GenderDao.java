package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.IGenderDao;
import com.solvd.sandinosanchez.connectionpool.models.Gender;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenderDao extends AbstractDao implements IGenderDao {
    private static final Logger LOGGER = Logger.getLogger(GenderDao.class);
    private static final String GET_ALL = "SELECT * FROM Genders";
    private static final String GET_BY_ID = "SELECT * FROM Genders WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Genders SET ? = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Genders WHERE id = ?";

    @Override
    public Gender getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeGender(rs);
            else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<? extends Gender> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Gender> genders = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) genders.add(initializeGender(rs));
                return genders;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ce.executeDelete(DELETE_BY_ID, id);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void updateById(long id, String column, String value) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ce.executeUpdate(UPDATE_BY_ID, id, column, value);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void insert(Statement query) {

    }

    public Gender initializeGender(ResultSet rs) throws SQLException {
        return new Gender(rs.getLong("id"), rs.getString("name"));
    }
}
