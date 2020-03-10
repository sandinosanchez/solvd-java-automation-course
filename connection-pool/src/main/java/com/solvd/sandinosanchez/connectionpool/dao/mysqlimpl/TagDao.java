package com.solvd.sandinosanchez.connectionpool.dao.mysqlimpl;

import com.solvd.sandinosanchez.connectionpool.dao.AbstractDao;
import com.solvd.sandinosanchez.connectionpool.dao.TagMapper;
import com.solvd.sandinosanchez.connectionpool.models.Tag;
import com.solvd.sandinosanchez.connectionpool.pool.ConnectionPool;
import com.solvd.sandinosanchez.connectionpool.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TagDao extends AbstractDao implements TagMapper {
    private static final Logger LOGGER = Logger.getLogger(TagDao.class);
    private static final String GET_ALL = "SELECT * FROM Tags";
    private static final String GET_BY_ID = "SELECT * FROM Tags WHERE id = ?";
    private static final String GET_ALL_BY_PHOTO_ID = "SELECT * FROM Tags WHERE photo_id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Tags WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Tags SET ? = ? WHERE id = ?";

    @Override
    public Tag getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeTag(rs);
            else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Tag> getAll() {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Tag> tags = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) tags.add(initializeTag(rs));
                return tags;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ce.executeQuery(DELETE_BY_ID, id);
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
    public void save(Statement query) {

    }

    public Tag initializeTag(ResultSet rs) throws SQLException {
        return new Tag(rs.getLong("id"));
    }

    @Override
    public PhotoDao getPhotoWithMostTags() {
        return null;
    }

    @Override
    public PhotoDao getPhotoWithLessTags() {
        return null;
    }

    @Override
    public List<Tag> getAllByPhotoId(long id) {
        try (ClosableEntity ce = new ClosableEntity(ConnectionPool.getInstance().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL_BY_PHOTO_ID, id);
            List<Tag> tags = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) tags.add(initializeTag(rs));
                return tags;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
