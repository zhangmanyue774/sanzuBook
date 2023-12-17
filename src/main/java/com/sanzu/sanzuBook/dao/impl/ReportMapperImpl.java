package com.sanzu.sanzuBook.dao.impl;

import com.sanzu.sanzuBook.config.MyBatisConfig;
import com.sanzu.sanzuBook.dao.mapper.ReportMapper;
import com.sanzu.sanzuBook.entity.ReportEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class ReportMapperImpl implements ReportMapper {
    @Override
    public List<ReportEntity> selectAll() throws IOException {
        return getReportMapper().selectAll();
    }

    @Override
    public Integer insertNewReport(ReportEntity reportEntity) throws IOException {
        return getReportMapper().insertNewReport(reportEntity);
    }

    @Override
    public Integer deleteOldReport(Integer id) throws IOException {
        return getReportMapper().deleteOldReport(id);
    }

    @Override
    public Integer updateIsDeal(Integer id) throws IOException {
        return getReportMapper().updateIsDeal(id);
    }

    public ReportMapper getReportMapper() throws IOException {
        SqlSessionFactory sqlSessionFactory = MyBatisConfig.getsqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession.getMapper(ReportMapper.class);
    }
}
