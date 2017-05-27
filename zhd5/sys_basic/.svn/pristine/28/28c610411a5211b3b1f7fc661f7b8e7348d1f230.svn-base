package com.xyscm.sys.basic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.dao.MonitoringDeviceMapper;
import com.xyscm.sys.basic.model.MonitoringDevice;

@Service
public class MonitoringDeviceService {
	 Logger logger = LoggerFactory.getLogger(MonitoringDeviceService.class);
	
	@Autowired
	MonitoringDeviceMapper monitoringDeviceMapper;
	
	
	
	/**
	 * 查询所有
	 * @param record  membercode
	 * @return
	 *
	 * List<MonitoringDevice>
	 */
	public List<MonitoringDevice> queryList( MonitoringDevice record){
		List<MonitoringDevice> list =null;
		try {
			list = monitoringDeviceMapper.queryList(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info(e.getMessage());
		}

		return list;
	}
	
}
