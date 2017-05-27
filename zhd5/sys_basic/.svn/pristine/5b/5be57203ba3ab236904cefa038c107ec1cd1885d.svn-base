package com.xyscm.sys.basic.dao;

import com.xyscm.sys.basic.model.MonitoringDevice;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringDeviceMapper {
    int deleteByPrimaryKey(BigDecimal deviceId);

    int insert(MonitoringDevice record);

    int insertSelective(MonitoringDevice record);

    MonitoringDevice selectByPrimaryKey(BigDecimal deviceId);

    int updateByPrimaryKeySelective(MonitoringDevice record);

    int updateByPrimaryKey(MonitoringDevice record);

	List<MonitoringDevice> queryList(MonitoringDevice record);
}