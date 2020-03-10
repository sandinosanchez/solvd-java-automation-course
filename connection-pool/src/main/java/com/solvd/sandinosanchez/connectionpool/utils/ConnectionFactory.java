package com.solvd.sandinosanchez.connectionpool.utils;

import com.solvd.sandinosanchez.connectionpool.dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class ConnectionFactory {
    private static SqlSessionFactory factory;

    static {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }

    public static UserMapper getUserMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(UserMapper.class);
    }

    public static PostMapper getPostMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(PostMapper.class);
    }

    public static LikeMapper getLikeMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(LikeMapper.class);
    }

    public static MessageMapper getPostMessageMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(MessageMapper.class);
    }

    public static GenderMapper getGenderMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(GenderMapper.class);
    }

    public static CommentMapper getCommentMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(CommentMapper.class);
    }

    public static FollowerMapper getFollowerMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(FollowerMapper.class);
    }

    public static DirectMessageMapper getDirectMessageMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(DirectMessageMapper.class);
    }

    public static PhotoMapper getPhotoMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(PhotoMapper.class);
    }

    public static TagMapper getTagMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(TagMapper.class);
    }
}
