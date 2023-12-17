package com.sanzu.sanzuBook.dao.mapper;

import com.sanzu.sanzuBook.entity.ReportEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ReportMapper {
    /**
     * 查询所有举报情况
     * @return 举报列表
     * @throws IOException 异常
     */
    List<ReportEntity> selectAll() throws IOException;

    /**
     * 插入新举报
     * @param reportEntity 新举报
     * @return 新增一行数据
     * @throws IOException 异常
     */
    Integer insertNewReport(ReportEntity reportEntity) throws IOException;

    /**
     * 删除处理的举报
     * @param id 举报id
     * @return 影响一行数据
     * @throws IOException 异常
     */
    Integer deleteOldReport(Integer id) throws IOException;
    Integer updateIsDeal(Integer id) throws IOException;
}
