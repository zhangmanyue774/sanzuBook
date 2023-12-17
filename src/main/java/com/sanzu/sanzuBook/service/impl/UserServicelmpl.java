package com.sanzu.sanzuBook.service.impl;

import com.sanzu.sanzuBook.dao.impl.UserRepositorylmpl;
import com.sanzu.sanzuBook.dao.mapper.UserMapper;
import com.sanzu.sanzuBook.entity.UserEntity;
import com.sanzu.sanzuBook.service.UserService;
import com.sanzu.sanzuBook.vo.UserCVo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserServicelmpl implements UserService {
    private final UserMapper userMapper;

    public UserServicelmpl() {
        userMapper = new UserRepositorylmpl();
    }
    @Override
    public UserEntity getUserCredentials(String account, String password) throws IOException {
        return userMapper.userCredentials(account,password);
    }

    @Override
    public UserCVo getUserMessage(String username) throws IOException {
        return userMapper.selectUserMessage(username);
    }

    @Override
    public Integer getInsertNewUser(Map<String, Object> map) throws IOException {
        return userMapper.insertNewUser(map);
    }

    @Override
    public Integer getUpdatePassword(String account, String password) throws IOException {
        return userMapper.updatePassword(account,password);
    }

    @Override
    public UserEntity getSelectAccount(String account) throws IOException {
        return userMapper.selectAccount(account);
    }

    @Override
    public List<UserEntity> getSelectAllUser() throws IOException {
        return userMapper.selectAllUser();
    }

    @Override
    public Integer updateBan(Integer id, Integer day) throws IOException {
        return userMapper.updateBan(id,day);
    }

    @Override
    public Integer getUpdateOperation(Integer id, String Operation_record) throws IOException {
        return userMapper.updateOperation(id,Operation_record);
    }
}
