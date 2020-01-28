package dao;

import java.sql.ResultSet;

public interface IPostDao extends IQuery {
    ResultSet getUserWithMostPosts();


}
