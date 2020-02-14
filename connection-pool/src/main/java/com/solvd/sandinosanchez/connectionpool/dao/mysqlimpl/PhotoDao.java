package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.IPhotoDao;
import com.solvd.sandinosanchez.connectionpool.models.Photo;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhotoDao extends AbstractDao implements IPhotoDao {
    private static final Logger LOGGER = Logger.getLogger(PhotoDao.class);
    private static final String GET_ALL = "SELECT * FROM Photos";
    private static final String GET_BY_ID = "SELECT * FROM Photos WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Photos SET ? = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Photos WHERE id = ?";


    @Override
    public List<? extends Photo> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Photo> photos = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) photos.add(initializePhoto(rs));
                return photos;
            } else throw new SQLException("Not foun");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Photo getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializePhoto(rs);
            else throw new SQLException("Not found");
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
            ce.executeDelete(DELETE_BY_ID, id);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void insert(Statement query) {

    }

    public static Photo initializePhoto(ResultSet rs) throws SQLException {
        return new Photo(rs.getLong("id"), rs.getString("file_url"));
    }
}
