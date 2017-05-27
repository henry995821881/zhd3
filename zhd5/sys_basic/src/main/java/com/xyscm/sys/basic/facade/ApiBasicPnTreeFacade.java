package com.xyscm.sys.basic.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicPnTreeService;
import com.xyscm.sys.basic.api.dto.BasicPnTreeDTO;
import com.xyscm.sys.basic.model.BasicPnTree;
import com.xyscm.sys.basic.service.BasicPnTreeService;
/**
 * 品名大类
 * @author henry
 *
 */
public class ApiBasicPnTreeFacade implements ApiBasicPnTreeService {

	@Autowired
	BasicPnTreeService basicPnTreeService;

	public ResultDTO queryList(BasicPnTreeDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicPnTree bean = new BasicPnTree();
		BeanUtils.copyProperties(dto, bean);
		List<BasicPnTree> list = basicPnTreeService.queryList(bean);	
		result.setData(list);
		return null;
	}

}
