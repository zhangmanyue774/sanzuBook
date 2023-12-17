package com.sanzu.sanzuBook.dao.mapper;

import com.sanzu.sanzuBook.entity.BookEntity;

import java.io.IOException;
import java.util.List;

public interface BookMapper {
    /**
     *模糊搜索-书名
     * @param title 书名模糊查询
     * @return 匹配相关书名集合
     */
    List<BookEntity> selectTitle(String title) throws IOException;

    /**
     * 模糊搜索-作者名
     * @param author 作者名模糊查询
     * @return 匹配相关作者名集合
     */
    List<BookEntity> selectAuthor(String author) throws IOException;

    /**
     * 分类接口
     * 查询类型名
     * @return 类型名
     */
    List<BookEntity> selectType() throws IOException;

    /**
     * 分类接口
     * 具体搜索-类型匹配
     * @param type 书籍类型
     * @return 该类型下书集合
     */
    List<BookEntity> selectTypeBook(String type) throws IOException;

    /**
     * 推荐接口
     * 查询推荐书籍（推荐指数大于4）
     * @return 推荐书集合
     */
    List<BookEntity> selectRecommended() throws IOException;

    /**
     * 点赞接口
     * @param id 点赞书籍的id
     * @return 影响一行数据
     */
    Integer updateLikes(Integer id) throws IOException;
    Integer reduceLikes(Integer id) throws IOException;

    /**
     *搜索建议
     * @param keyword 搜索的关键字
     * @return 搜索建议的数组
     */
    List<String> selectSearch(String keyword) throws IOException;
    BookEntity selectID(Integer id) throws  IOException;
}
