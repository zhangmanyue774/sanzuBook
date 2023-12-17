package com.sanzu.sanzuBook.service;

import com.sanzu.sanzuBook.entity.BookEntity;

import java.io.IOException;
import java.util.List;

public interface BookService {
    List<BookEntity> getSelectTitle(String title) throws IOException;
    List<BookEntity> getSelectAuthor(String author) throws IOException;
    List<BookEntity> getSelectType() throws IOException;
    List<BookEntity> getSelectTypeBook(String type) throws IOException;
    List<BookEntity> getSelectRecommended() throws IOException;
    Integer getUpdateLikes(Integer id) throws IOException;
    Integer getReduceLikes(Integer id) throws IOException;
    List<String> selectSearch(String keyword) throws IOException;
    BookEntity getSelectID(Integer id) throws  IOException;
}
