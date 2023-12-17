package com.sanzu.sanzuBook.dao.mapper;

import com.sanzu.sanzuBook.entity.CollectEntity;
import com.sanzu.sanzuBook.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CollectMapper {
    /**
     * 查询用户收藏集合
     * @param userID 用户id
     * @return 用户收藏
     */
    List<CollectEntity> selectCollects(Integer userID) throws IOException;

    /**
     * 添加收藏
     * @param map 新增map
     * @return 新增一条数据
     */
    Integer insertCollect(Map<String,Object> map) throws IOException;
    /**
     * 删除收藏
     * @param bookId 收藏id
     * @return 删除一条数据
     */
    Integer deleteCollect(
            @Param("bookId") Integer bookId,
            @Param("userID") Integer userID) throws IOException;
}
