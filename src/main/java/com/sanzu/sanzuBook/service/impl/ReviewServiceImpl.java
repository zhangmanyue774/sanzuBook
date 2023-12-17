package com.sanzu.sanzuBook.service.impl;

import com.sanzu.sanzuBook.dao.impl.ReviewMapperImpl;
import com.sanzu.sanzuBook.dao.mapper.ReviewMapper;
import com.sanzu.sanzuBook.entity.ReviewEntity;
import com.sanzu.sanzuBook.service.ReviewService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReviewServiceImpl implements ReviewService {
    private final ReviewMapper reviewMapper;

    public ReviewServiceImpl() {
        reviewMapper = new ReviewMapperImpl();
    }

    @Override
    public List<ReviewEntity> getShowReviewEntity(int startRow, int pageSize) throws IOException {
        return reviewMapper.showReviewEntity(startRow,pageSize);
    }

    @Override
    public Integer getInsertReview(Map<String, Object> map) throws IOException {
        return reviewMapper.insertReview(map);
    }

    @Override
    public Integer getDeleteReview(String username, Integer id) throws IOException {
        return reviewMapper.deleteReview(username,id);
    }

    @Override
    public Integer getIncreaseLikes(int id) throws IOException {
        return reviewMapper.increaseLikes(id);
    }

    @Override
    public Integer getReduceLikes(int id) throws IOException {
        return reviewMapper.reduceLikes(id);
    }
}
