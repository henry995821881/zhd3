/**
 * 
 */
package com.xyscm.sys.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.dao.BasicOrgMapper;
import com.xyscm.sys.basic.model.BasicOrg;

/**
 * 测试用示例service
 * @author xielf
 *
 */
@Service
public class DemoTestService {

	@Autowired
	BasicOrgMapper basicOrgMapper;
	
	/**
	 * 分页查询示例代码
	 * @param pageNum  当前页
	 * @param pageSize 每页显示记录
	 * @return  PageInfo （注意其中的数据结构，查询结果在 PageInfo内的Page对象中的list数组中）
	 */
	public PageInfo getOry(int pageNum,int pageSize){
		
		PageHelper.startPage(pageNum, pageSize);  // 开启分页，必须
		
		Page page = (Page)basicOrgMapper.queryAll();  // 对原来的查询方法不需要任何修改
		
		PageInfo<BasicOrg> pageInfo = new PageInfo<BasicOrg>(page); // 对page对象包了一层，里面有一些翻页需要的信息
		
		return pageInfo;
		
	}

}
