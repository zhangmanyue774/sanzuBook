package com.sanzu.sanzuBook.service.impl;

import com.sanzu.sanzuBook.dao.impl.CollectMapperImpl;
import com.sanzu.sanzuBook.dao.mapper.CollectMapper;
import com.sanzu.sanzuBook.entity.CollectEntity;
import com.sanzu.sanzuBook.service.CollectService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CollectServiceImpl implements CollectService {
    private final CollectMapper collectMapper;

    public CollectServiceImpl() {
        collectMapper = new CollectMapperImpl();
    }

    @Override
    public List<CollectEntity> getSelectCollects(Integer userID) throws IOException {
        return collectMapper.selectCollects(userID);
    }

    @Override
    public Integer getInsertCollect(Map<String, Object> map) throws IOException {
        return collectMapper.insertCollect(map);
    }

    @Override
    public Integer getDeleteCollect(Integer collectId,Integer userID) throws IOException {
        return collectMapper.deleteCollect(collectId,userID);
    }
}
