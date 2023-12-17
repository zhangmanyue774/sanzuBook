package com.sanzu.sanzuBook.dao.impl;

import com.sanzu.sanzuBook.config.MyBatisConfig;
import com.sanzu.sanzuBook.dao.mapper.UserMapper;
import com.sanzu.sanzuBook.entity.UserEntity;
import com.sanzu.sanzuBook.vo.UserCVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserRepositorylmpl implements UserMapper {
    public UserRepositorylmpl() {
    }
    @Override
    public UserEntity userCredentials(String account, String password) throws IOException {
            return getUserMapper().userCredentials(account,password);
    }

    @Override
    public UserCVo selectUserMessage(String username) throws IOException {
        return getUserMapper().selectUserMessage(username);
    }

    @Override
    public Integer insertNewUser(Map<String, Object> map) throws IOException {
        return getUserMapper().insertNewUser(map);
    }

    @Override
    public Integer updatePassword(String account, String password) throws IOException {
        return getUserMapper().updatePassword(account,password);
    }

    @Override
    public UserEntity selectAccount(String account) throws IOException {
        return getUserMapper().selectAccount(account);
    }

    @Override
    public List<UserEntity> selectAllUser() throws IOException {
        return getUserMapper().selectAllUser();
    }

    @Override
    public Integer updateBan(Integer id, Integer day) throws IOException {
        return getUserMapper().updateBan(id,day);
    }

    @Override
    public Integer updateOperation(Integer id, String Operation_record) throws IOException {
        return getUserMapper().updateOperation(id,Operation_record);
    }

    public UserMapper getUserMapper() throws IOException {
        SqlSessionFactory sqlSessionFactory = MyBatisConfig.getsqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession.getMapper(UserMapper.class);
    }
}
