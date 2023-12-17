package com.sanzu.sanzuBook.service;

import com.sanzu.sanzuBook.entity.ReviewEntity;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ReviewService{
    List<ReviewEntity> getShowReviewEntity(int startRow, int pageSize) throws IOException;
    Integer getInsertReview(Map<String, Object> map) throws IOException;
    Integer getDeleteReview(String username, Integer id) throws IOException;
    Integer getIncreaseLikes(int id) throws IOException;
    Integer getReduceLikes(int id) throws IOException;
}
