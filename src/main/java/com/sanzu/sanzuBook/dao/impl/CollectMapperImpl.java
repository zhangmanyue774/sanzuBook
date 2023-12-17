package com.sanzu.sanzuBook.dao.impl;

import com.sanzu.sanzuBook.config.MyBatisConfig;
import com.sanzu.sanzuBook.dao.mapper.CollectMapper;
import com.sanzu.sanzuBook.entity.CollectEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CollectMapperImpl implements CollectMapper {
    @Override
    public List<CollectEntity> selectCollects(Integer userID) throws IOException {
        return getCollectMapper().selectCollects(userID);
    }

    @Override
    public Integer insertCollect(Map<String, Object> map) throws IOException {
        return getCollectMapper().insertCollect(map);
    }

    @Override
    public Integer deleteCollect(Integer collectId,Integer userID ) throws IOException {
        return getCollectMapper().deleteCollect(collectId,userID);
    }
    public CollectMapper getCollectMapper() throws IOException {
        SqlSessionFactory sqlSessionFactory = MyBatisConfig.getsqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession.getMapper(CollectMapper.class);
    }
}
