package com.sanzu.sanzuBook.dao.impl;

import com.sanzu.sanzuBook.config.MyBatisConfig;
import com.sanzu.sanzuBook.dao.mapper.ReviewMapper;
import com.sanzu.sanzuBook.entity.ReviewEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReviewMapperImpl implements ReviewMapper {
    @Override
    public List<ReviewEntity> showReviewEntity(int startRow, int pageSize) throws IOException {
        return getReviewMapper().showReviewEntity(startRow,pageSize);
    }

    @Override
    public Integer insertReview(Map<String, Object> map) throws IOException {
        return getReviewMapper().insertReview(map);
    }

    @Override
    public Integer deleteReview(String username, Integer id) throws IOException {
        return getReviewMapper().deleteReview(username,id);
    }

    @Override
    public Integer increaseLikes(int id) throws IOException {
        return getReviewMapper().increaseLikes(id);
    }

    @Override
    public Integer reduceLikes(int id) throws IOException {
        return getReviewMapper().reduceLikes(id);
    }
    public ReviewMapper getReviewMapper() throws IOException {
        SqlSessionFactory sqlSessionFactory = MyBatisConfig.getsqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession.getMapper(ReviewMapper.class);
    }
}
