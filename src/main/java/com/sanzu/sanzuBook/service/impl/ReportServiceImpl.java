package com.sanzu.sanzuBook.service.impl;

import com.sanzu.sanzuBook.dao.impl.ReportMapperImpl;
import com.sanzu.sanzuBook.dao.mapper.ReportMapper;
import com.sanzu.sanzuBook.entity.ReportEntity;
import com.sanzu.sanzuBook.service.ReportService;

import java.io.IOException;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final ReportMapper reportMapper;

    public ReportServiceImpl() {
        reportMapper = new ReportMapperImpl();
    }

    @Override
    public List<ReportEntity> getSelectAll() throws IOException {
        return reportMapper.selectAll();
    }

    @Override
    public Integer getInsertNewReport(ReportEntity reportEntity) throws IOException {
        return reportMapper.insertNewReport(reportEntity);
    }

    @Override
    public Integer getDeleteOldReport(Integer id) throws IOException {
        return reportMapper.deleteOldReport(id);
    }

    @Override
    public Integer getUpdateIsDeal(Integer id) throws IOException {
        return reportMapper.updateIsDeal(id);
    }
}
