package com.sanzu.sanzuBook.service;

import com.sanzu.sanzuBook.entity.UserEntity;
import com.sanzu.sanzuBook.vo.UserCVo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {
    UserEntity getUserCredentials(String account, String password) throws IOException;
    UserCVo getUserMessage(String username) throws IOException;
    Integer getInsertNewUser(Map<String,Object> map) throws IOException;
    Integer getUpdatePassword(String account,String password) throws IOException;
    UserEntity getSelectAccount(String account) throws IOException;
    List<UserEntity> getSelectAllUser() throws IOException;
    Integer updateBan(Integer id, Integer day) throws IOException;
    Integer getUpdateOperation(Integer id, String Operation_record) throws IOException;
}
