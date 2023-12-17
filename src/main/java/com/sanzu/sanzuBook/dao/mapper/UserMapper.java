package com.sanzu.sanzuBook.dao.mapper;

import com.sanzu.sanzuBook.entity.UserEntity;
import com.sanzu.sanzuBook.vo.UserCVo;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface UserMapper {
    /**
     *用户登陆凭证校验
     * @param account 邮箱
     * @param password 密码
     * @return 用户数据
     */
    UserEntity userCredentials(
            @Param("account") String account,
            @Param("password") String password) throws IOException;
    UserCVo selectUserMessage(String username) throws IOException;
    /**
     * 用户注册
     * @param map 新用户信息
     * @return 新增一条数据
     * @throws IOException 空
     */
    Integer insertNewUser(Map<String,Object> map) throws IOException;

    /**
     *
     * @param account 用户邮箱
     * @param password 修改的用户密码
     * @return 更新一条数据
     * @throws IOException 数据库错误
     */
    Integer updatePassword(@Param("account") String account,
                           @Param("password") String password) throws IOException;

    /**
     * 查看用户是否存在
     * @param account 用户邮箱
     * @return 一条数据
     * @throws IOException 数据库异常
     */
    UserEntity selectAccount(String account) throws IOException;

    /**
     * 管理用户查询
     * @return 用户数据
     * @throws IOException 异常
     */
    List<UserEntity> selectAllUser() throws IOException;

    /**
     * 用户封号设置
     * @param id 用户id
     * @param day 封号时长
     * @return 影响一行数据
     * @throws IOException 数据库异常
     */
    Integer updateBan(
            @Param("id") Integer id,
            @Param("day") Integer day) throws IOException;
    Integer updateOperation(@Param("id") Integer id,
                            @Param("Operation_record") String Operation_record) throws IOException;
}
