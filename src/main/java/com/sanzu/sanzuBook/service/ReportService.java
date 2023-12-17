package com.sanzu.sanzuBook.service;

import com.sanzu.sanzuBook.entity.ReportEntity;

import java.io.IOException;
import java.util.List;

public interface ReportService {
    List<ReportEntity> getSelectAll() throws IOException;
    Integer getInsertNewReport(ReportEntity reportEntity) throws IOException;
    Integer getDeleteOldReport(Integer id) throws IOException;
    Integer getUpdateIsDeal(Integer id)throws IOException;
}
