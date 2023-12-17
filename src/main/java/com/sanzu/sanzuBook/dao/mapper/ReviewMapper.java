package com.sanzu.sanzuBook.dao.mapper;

import com.sanzu.sanzuBook.entity.ReviewEntity;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ReviewMapper {
    /**
     *分页查询书评
     * @param startRow 起始位置
     * @param pageSize 每页数据量
     * @return 查询书评
     */
    List<ReviewEntity> showReviewEntity(
            @Param("startRow") int startRow,
            @Param("pageSize") int pageSize) throws IOException;
    /**
     * 新增书评
     * @param map 书评map
     * @return 影响一行数据
     */
    Integer insertReview(Map<String, Object> map) throws IOException;

    /**
     * 删除书评
     * @param username 用户名
     * @param id 书评id
     * @return 删除一行数据
     */
    Integer deleteReview(
                 @Param("username") String username,
                 @Param("id") Integer id
    ) throws IOException;
    /**
     * 增加点赞
     * @param id 书评id
     * @return 影响一行数据
     */
    Integer increaseLikes(int id) throws IOException;

    /**
     * 减少点赞
     * @param id 书评id
     * @return 影响一行数据
     */
    Integer reduceLikes(int id) throws IOException;
}
