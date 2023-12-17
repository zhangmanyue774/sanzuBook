package com.sanzu.sanzuBook.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisConfig {
    /**
     * 获取SqlSession对象
     * @return SqlSession对象
     * @throws IOException 异常
     */
    public static SqlSessionFactory getsqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory对象（），通过SqlSessionFactoryBuilder获取
        //创建sqlSession对象（MyBatis的操作数据库的会话对象，通过此对象获取SQL语句，并执行）
        //openSession默认不自动提交
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}
