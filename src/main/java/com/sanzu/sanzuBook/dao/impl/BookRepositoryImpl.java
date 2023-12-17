package com.sanzu.sanzuBook.dao.impl;

import com.sanzu.sanzuBook.config.MyBatisConfig;
import com.sanzu.sanzuBook.dao.mapper.BookMapper;
import com.sanzu.sanzuBook.entity.BookEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class BookRepositoryImpl implements BookMapper {
    @Override
    public List<BookEntity> selectTitle(String title) throws IOException {
        return getBookMapper().selectTitle(title);
    }
    @Override
    public List<BookEntity> selectAuthor(String author) throws IOException {
        return getBookMapper().selectAuthor(author);
    }
    @Override
    public List<BookEntity> selectType() throws IOException {
        return getBookMapper().selectType();
    }

    @Override
    public List<BookEntity> selectTypeBook(String type) throws IOException {
        return getBookMapper().selectTypeBook(type);
    }

    @Override
    public List<BookEntity> selectRecommended() throws IOException {
        return getBookMapper().selectRecommended();
    }

    @Override
    public Integer updateLikes(Integer id) throws IOException {
        return getBookMapper().updateLikes(id);
    }

    @Override
    public Integer reduceLikes(Integer id) throws IOException {
        return getBookMapper().reduceLikes(id);
    }

    @Override
    public List<String> selectSearch(String keyword) throws IOException {
        return getBookMapper().selectSearch(keyword);
    }

    @Override
    public BookEntity selectID(Integer id) throws IOException {
        return getBookMapper().selectID(id);
    }

    public BookMapper getBookMapper() throws IOException {
        SqlSessionFactory sqlSessionFactory = MyBatisConfig.getsqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession.getMapper(BookMapper.class);
    }
}
