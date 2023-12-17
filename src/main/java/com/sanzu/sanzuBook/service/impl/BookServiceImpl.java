package com.sanzu.sanzuBook.service.impl;

import com.sanzu.sanzuBook.dao.impl.BookRepositoryImpl;
import com.sanzu.sanzuBook.dao.mapper.BookMapper;
import com.sanzu.sanzuBook.entity.BookEntity;
import com.sanzu.sanzuBook.service.BookService;

import java.io.IOException;
import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;

    public BookServiceImpl() {
        bookMapper = new BookRepositoryImpl();
    }

    @Override
    public List<BookEntity> getSelectTitle(String title) throws IOException {
        return bookMapper.selectTitle(title);
    }

    @Override
    public List<BookEntity> getSelectAuthor(String author) throws IOException {
        return bookMapper.selectAuthor(author);
    }

    @Override
    public List<BookEntity> getSelectType() throws IOException {
        return bookMapper.selectType();
    }

    @Override
    public List<BookEntity> getSelectTypeBook(String type) throws IOException {
        return bookMapper.selectTypeBook(type);
    }

    @Override
    public List<BookEntity> getSelectRecommended() throws IOException {
        return bookMapper.selectRecommended();
    }

    @Override
    public Integer getUpdateLikes(Integer id) throws IOException {
        return bookMapper.updateLikes(id);
    }

    @Override
    public Integer getReduceLikes(Integer id) throws IOException {
        return bookMapper.reduceLikes(id);
    }

    @Override
    public List<String> selectSearch(String keyword) throws IOException {
        return bookMapper.selectSearch(keyword);
    }

    @Override
    public BookEntity getSelectID(Integer id) throws IOException {
        return bookMapper.selectID(id);
    }
}
