package com.sanzu.sanzuBook.service;

import com.sanzu.sanzuBook.entity.CollectEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CollectService {
    List<CollectEntity> getSelectCollects(Integer userID) throws IOException;

    Integer getInsertCollect(Map<String,Object> map) throws IOException;

    Integer getDeleteCollect(Integer bookId,Integer userID) throws IOException;
}
