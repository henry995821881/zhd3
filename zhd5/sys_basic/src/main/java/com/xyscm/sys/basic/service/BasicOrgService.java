package com.xyscm.sys.basic.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.constant.SuperConstants;
import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.common.util.MessageSourceUtil;
import com.xyscm.sys.basic.common.util.StringUtil;
import com.xyscm.sys.basic.dao.BasicOrgMapper;
import com.xyscm.sys.basic.model.BasicEmployee;
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.vo.TreeBean;


/************************************************
 * Copyright (c)  by gmwl
 * All right reserved.
 * Create Date: 2017-04-12
 * File Name: 机构设置服务
 * Last version:  1.0
 * Last Update Date:
 * Change Log:
**************************************************/	
 
@Service
public class BasicOrgService {
	
	@Autowired
	BasicOrgMapper basicOrgMapper;
	
	/**
	 * 通过公司组织机构代码,使用单位查询角色记录
	 * @param orgCode  公司组织代码(机构代码)
	 * @param memberCode 使用单位 
	 * @return
	 */
	public BasicOrg getOrgByCode(String orgCode,String memberCode){
		return basicOrgMapper.getOrgByCode(orgCode, memberCode);
	}
	/**
	 * 查询信息
	 * @param orgAbbreviate 机构简称
	 * @param memberCode 使用单位代码
	 * @return List<BasicOrg>
	 */
	public BasicOrg getOrgByAbbreviateName(String orgAbbreviate,String memberCode){
		return basicOrgMapper.getByAbbreviate(orgAbbreviate, memberCode);
	}
	

	/**
	 * 查询信息
	 * @param user 用户信息
	 * @param query 过滤机构代码或机构名称
	 * @param orgCode 公司组织代码(机构代码)
	 * @return
	 */
	/*public List<ComboBean> queryCombo(UserSession user, String query,String orgCode){
		return basicOrgMapper.queryCombo(user, query,orgCode);
	}*/
	
	/**
	 * 查询所有信息
	 * 
	 * @return List<BasicOrg>
	 */
	public List<BasicOrg> queryAll(){
		return basicOrgMapper.queryAll();
	}
	
	/**
	 * 查询机构树
	 * @param user 用户信息
	 * @param query 过滤机构代码或机构名称
	 * @param orgCode 公司组织代码(机构代码)
	 * @return
	 */
	/*public List<TreeBean> queryCombotree(UserSession user, String query,String orgCode){
		List<BasicOrg> list= basicOrgMapper.queryByParent(SuperConstants.TREE_EMPTY,0L,user.getMemberCode());
		List<TreeBean> treeList = new ArrayList<TreeBean>();
		if(null!=list&&!list.isEmpty()){
			setOrgChildren(list,treeList,null,user);
		}
		return treeList;
	}*/
	
	/**
	 * 新增记录
	 * @param mod
	 * @return 1 成功 -1 失败
	 */
	public int save(BasicOrg mod){
		/*String str="";
		if(0==mod.getOrgIsleaf().intValue()){
			str="组织";
		}else{
			str="机构";
		}*/
		int i = 0;
		try {
			i = basicOrgMapper.save(mod);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("basicOrgService异常");
		}
		return i;
		/*String msg = checkOrg(mod);
		if (StringUtils.isNotBlank(msg)) {
			throw new BaseException("0301005", "操作失败:"+msg, "新增失败,"+msg);
		}
		if (StringUtils.isBlank(mod.getOrgCode())) {
			mod.setOrgCode(basicOrgMapper.getMaxOrgCode()+1+"");
		}
		String str="";
		if(0==mod.getOrgIsleaf().intValue()){
			str="组织";
		}else{
			str="机构";
		}
		BasicOrg oldMod=basicOrgMapper.getByCode(mod.getOrgCode());
		if(null!=oldMod){
			throw new BaseException("0301006","操作失败："+str+"代码已经存在","新增失败,信息["+mod.getOrgCode()+"]失败:已经存在");
		}
		oldMod=basicOrgMapper.getByName(mod.getOrgName(), mod.getMemberCode());
		if(null!=oldMod){
			throw new BaseException("0301007","操作失败："+str+"名称已经存在","新增失败,信息["+mod.getOrgName()+"/"+mod.getMemberCode()+"]失败:已经存在");
		}
		oldMod=basicOrgMapper.getByAbbreviate(mod.getOrgAbbreviate(), mod.getMemberCode());
		if(null!=oldMod){
			throw new BaseException("0301008","操作失败："+str+"简称已经存在","新增失败,信息["+mod.getOrgName()+"/"+mod.getMemberCode()+"]失败:已经存在");
		}
		//给树结点编码赋值
		mod.setOrgNodecode(getOrgNodecode(mod.getOrgParent(),mod.getOrgCode()));
		try {
			basicOrgMapper.save(mod);
		} catch (Exception e){
			throw new BaseException("0301009", "", "插入信息["+mod.getOrgCode()+"/"+mod.getOrgName()+"/"+mod.getMemberCode()+"]保存失败,异常");
		}
		return 1;*/
	}
	/**
	 * 更新记录
	 * @param mod
	 * @return 1 成功 -1 失败
	 */
	public int update(BasicOrg mod){
		int update = 0;
		try {
			update = basicOrgMapper.update(mod);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_ORG_UPDATE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_ORG_UPDATE.getErrCode()));
		}
		return update;
		/*String msg = checkOrg(mod);
		if (StringUtils.isNotBlank(msg)) {
			throw new BaseException("03010010", "操作失败:" + msg, "更新失败," + msg);
		}
		BasicOrg oldMod=basicOrgMapper.getByCode(mod.getOrgCode());
		if(null==oldMod){
			throw new BaseException("03010011","操作失败：信息不存在","更新失败,信息["+mod.getOrgCode()+"]失败:不存在");
		}
		String str="";
		if(0==mod.getOrgIsleaf().intValue()){
			str="组织";
		}else{
			str="机构";
		}
		if(!oldMod.getOrgName().equals(mod.getOrgName())){
			BasicOrg checkoldMod=basicOrgMapper.getByName(mod.getOrgName(), mod.getMemberCode());
			if(null!=checkoldMod){
				throw new BaseException("0301012","操作失败："+str+"名称已经存在","更新失败,信息["+mod.getOrgName()+"/"+mod.getMemberCode()+"]失败:已经存在");
			}
		}
		if(!oldMod.getOrgAbbreviate().equals(mod.getOrgAbbreviate())){
			BasicOrg checkoldMod=basicOrgMapper.getByAbbreviate(mod.getOrgAbbreviate(), mod.getMemberCode());
			if(null!=checkoldMod){
				throw new BaseException("0301013","操作失败："+str+"简称已经存在","更新失败,信息["+mod.getOrgName()+"/"+mod.getMemberCode()+"]失败:已经存在");
			}
		}
		//当上级节点发生变化时重新给树结点编码赋值
		if(!oldMod.getOrgParent().equals(mod.getOrgParent())){
			mod.setOrgNodecode(getOrgNodecode(mod.getOrgParent(),mod.getOrgCode()));
		}else{//防止并发
			mod.setOrgNodecode(oldMod.getOrgNodecode());
		}
		try {
			mod.setOrgId(oldMod.getOrgId());
			basicOrgMapper.update(mod);
		} catch (Exception e){
			throw new BaseException("03010015", "", "更新信息["+mod.getOrgCode()+"/"+mod.getOrgName()+"/"+mod.getMemberCode()+"]保存失败,异常");
		}
		return 1;*/
	}
	/**
	 * 删除记录
	 * @param orgCode 机构代码
	 * @param memberCode 使用单位
	 * @return
	 */
	public int delete(String orgCode,String memberCode){
		int i = 0;
		try {
			i = basicOrgMapper.delete(orgCode, memberCode);
		} catch (Exception e){
			throw new BaseException("0301003", "", "删除["+orgCode+"/"+memberCode+"]异常");
		}
		return 1;
		/*if (StringUtil.isBlankOne(orgCode, memberCode)){
			throw new BaseException("0301001", "", "删除["+orgCode+"/"+memberCode+"]失败:memberCode为空");
		}
		
		int i = 0;
		try {
			i = basicOrgMapper.delete(orgCode, memberCode);
		} catch (Exception e){
			throw new BaseException("0301003", "", "删除["+orgCode+"/"+memberCode+"]异常");
		}
		if (1 != i){
			throw new BaseException("0301004", "", "删除["+orgCode+"/"+memberCode+"]失败:"+i);
		}
		;*/
	}

	
	/**
	 * 查询公司组织树
	 * @param orgParent 父节点代码
	 * @param memberCode 使用单位
	 * @return
	 */
	public List<TreeBean> queryTree(String orgParent,String memberCode){
		if(StringUtils.isBlank(orgParent)){
			orgParent=SuperConstants.TREE_EMPTY;
		}
		List<BasicOrg> list= basicOrgMapper.queryByParent(orgParent,0L,memberCode);
		List<TreeBean> treeList = new ArrayList<TreeBean>();
		if(null!=list&&!list.isEmpty()){
			//setOrgChildren(list,treeList,0L,null);
			setOrgChildren(list,treeList,0L);
		}
		return treeList;
	}
	
	/**
	 * 递归生成树
	 * @param list
	 * @param treeList
	 * @param orgIsleaf 机构属性(0：机构组,1：机构明细,null:所有)
	 * @param user 
	 */
	private void setOrgChildren(List<BasicOrg> list,List<TreeBean> treeList,Long orgIsleaf) {
		if(null!=list&&!list.isEmpty()){
			for (BasicOrg mod : list) {
				TreeBean treeBean = new TreeBean();
				setOrgToTree(mod, treeBean);
				//TODO 为了加快速度,后面需要从缓存中读取
				List<BasicOrg> childrenList =basicOrgMapper.queryByParent(mod.getOrgCode(), orgIsleaf,mod.getMemberCode());
				List<TreeBean> childrenTreeList = new ArrayList<TreeBean>();
				setOrgChildren(childrenList,childrenTreeList,orgIsleaf);
				treeBean.setChildren(childrenTreeList);
				treeList.add(treeBean);
			}
		}
	}
	/*private void setOrgChildren(List<BasicOrg> list,List<TreeBean> treeList,Long orgIsleaf,UserSession user) {
		if(null!=list&&!list.isEmpty()){
			for (BasicOrg mod : list) {
				TreeBean treeBean = new TreeBean();
				setOrgToTree(mod, treeBean,user);
				//TODO 为了加快速度,后面需要从缓存中读取
				List<BasicOrg> childrenList =basicOrgMapper.queryByParent(mod.getOrgCode(), orgIsleaf,mod.getMemberCode());
				List<TreeBean> childrenTreeList = new ArrayList<TreeBean>();
				setOrgChildren(childrenList,childrenTreeList,orgIsleaf,user);
				treeBean.setChildren(childrenTreeList);
				treeList.add(treeBean);
			}
		}
	}*/
	
	/**把组织机构信息赋值到树的对象
	 * @param mod
	 * @param treeBean
	 * @param user
	 */
	private void setOrgToTree(BasicOrg mod,TreeBean treeBean){
		treeBean.setId(mod.getOrgCode());
		treeBean.setFilterObj("'{orgParent:'"+mod.getOrgCode()+"',orgNodecode:'" + mod.getOrgNodecode()+"',memberCode:'" + mod.getMemberCode()+"'}'");
		treeBean.setText(mod.getOrgAbbreviate());
		treeBean.setLoaded(true);
		if(1==mod.getOrgIsleaf().intValue()){//机构明细
			treeBean.setLeaf(true);
		}
	}
	/*private void setOrgToTree(BasicOrg mod,TreeBean treeBean,UserSession user){
		if(null!=user&&StringUtil.isNotBlank(user.getOperatorUserid())){//下拉树
			treeBean.setId(mod.getOrgNodecode());
		}else{
			treeBean.setId(mod.getOrgCode());
			treeBean.setFilterObj("'{orgParent:'"+mod.getOrgCode()+"',orgNodecode:'" + mod.getOrgNodecode()+"',memberCode:'" + mod.getMemberCode()+"'}'");
		}
		treeBean.setText(mod.getOrgAbbreviate());
		treeBean.setLoaded(true);
		if(1==mod.getOrgIsleaf().intValue()){//机构明细
			treeBean.setLeaf(true);
		}
	}*/
	

	private String checkOrg(BasicOrg mod) {
		if(null==mod){
			return "数据为空";
		}
		String msg = "";
		msg += StringUtil.isBlankToMsg(mod.getMemberCode(), "使用单位为空");
		if(null==mod.getOrgIsleaf()){
			mod.setOrgIsleaf(new BigDecimal(0L));
		}
		String str="";
		if(0==mod.getOrgIsleaf().intValue()){
			str="组织";
		}else{
			str="机构";
		}
		msg += StringUtil.isBlankToMsg(mod.getOrgName(), str+"名称为空");
		if(0!=mod.getOrgIsleaf().intValue()){
			msg += StringUtil.isBlankToMsg(mod.getOrgAbbreviate(), str+"简称为空");
		}
		if(1==mod.getOrgIsleaf().intValue()&&StringUtils.isBlank(mod.getOrgParent())){
			msg +="上级组织为空";
		}
		
		if (StringUtils.isNotBlank(msg) && msg.trim().endsWith(",")) {
			msg = msg.trim().substring(0, msg.trim().length() - 1);
		}
		if(StringUtils.isBlank(mod.getOrgParent())){
			mod.setOrgParent(SuperConstants.TREE_EMPTY);
		}
		return msg;
	}

	
	/**
	 * 获取节点编码
	 * @param orgParent 父节点代码
	 * @param orgCode 树节点代码
	 * @return
	 */
	private String getOrgNodecode(String orgParent,String orgCode){
		String orgNodecode="";
		if(!SuperConstants.TREE_EMPTY.equals(orgParent)){
			BasicOrg parentMod=basicOrgMapper.getByCode(orgParent);
			if(null==parentMod || StringUtils.isBlank(parentMod.getOrgNodecode())){
				throw new BaseException("0301008","操作失败：上级节点编码为空","新增失败,信息["+orgParent+"]失败:上级节点编码为空");
			}
			orgNodecode=parentMod.getOrgNodecode();
			if(StringUtils.isNotBlank(orgCode)){
				orgNodecode+='.'+orgCode;
			}
		}else{
			orgNodecode=orgCode;
		}
		return orgNodecode;
	}


	/**
	 * 通过父结点代码,机构属性查询记录数
	 * @param orgParent 父结点代码
	 * @param orgIsleaf 机构属性(0：机构组,1：机构明细,null:所有)
	 * @param memberCode 使用单位
	 * @return
	 */
	private int getCountByParentCode(String orgParent,Long orgIsleaf,String memberCode){
		return basicOrgMapper.getCountByParentCode(orgParent, orgIsleaf,memberCode);
	}
	
	

	
	
	/**
	 * 更新节点父节点代码
	 * @param orgCode 公司组织代码
	 * @param oldOrgNodecode 公司组织编号
	 * @param orgParent 父节点代码
	 * @param memberCode 使用单位
	 * @return
	 */
	/*public int updateTreeParent(String orgCode,String oldOrgNodecode,String orgParent,String memberCode){
		int i =0;
		String newOrgNodecode=getOrgNodecode(orgParent, orgCode);
		try{
			i=basicOrgMapper.updateOrgParentCode(orgCode, newOrgNodecode, orgParent, memberCode);
		}catch(Exception e){
			throw new BaseException("0301004","","更新组织机构["+orgCode+"]层次关系失败:异常");
		}
		if(1!=i){
			throw new BaseException("0301005","","更新组织机构["+orgCode+"]层次关系失败:异常");
		}
		try{//更新下级编号
			i=basicOrgMapper.updateOrgNodecode(oldOrgNodecode, newOrgNodecode, memberCode);
		}catch(Exception e){
			throw new BaseException("0301006","","更新组织机构["+orgCode+"]层次关系失败:异常");
		}
		return 1;
	}*/
	
	/**
	 * 通过公司组织代码删除公司组织(包含下级公司组织,不包括末级机构)
	 * @param orgCode 公司组织代码
	 * @param memberCode 使用单位
	 * @return
	 */
	/*public int deleteTree(String orgCode,String memberCode){
		if(StringUtil.isBlank(orgCode)){
			throw new BaseException("0301001","","删除失败:orgCode参数为空");
		}
		//检测是否有机构明细
		if(0<getCountByParentCode(orgCode,1L,memberCode)){
			throw new BaseException("0301006","公司组织已经有明细机构,请先删除明细机构","更新失败,公司组织已经有明细机构");
		}
		int i=0;
		try{
			i=basicOrgMapper.delete(orgCode, memberCode);
		}catch(Exception e){
			throw new BaseException("0301002","","删除["+orgCode+"]异常");
		}
		if(1!=i){
			throw new BaseException("0301002","","删除["+orgCode+"]失败:"+i);
		}
		i=deleteTreeByParent(orgCode, memberCode);
		if(1!=i){
			throw new BaseException("0301002","","删除["+orgCode+"]子节点信息失败:"+i);
		}
		return 1;
	}*/
	
	/*public int deleteTreeByParent(String orgParent,String memberCode) {
	if(StringUtil.isBlankOne(orgParent)){
		throw new BaseException("0301003","","删除失败:orgParent为空");
	}
	List<BasicOrg> list =basicOrgMapper.queryByParent(orgParent,0L,memberCode);
	if(null!=list&&!list.isEmpty()){
		int i =0;
		for (BasicOrg mod : list) {
			//检测是否有机构明细
			if(0<getCountByParentCode(mod.getOrgCode(),1L,memberCode)){
				throw new BaseException("0301006","公司组织已经有明细机构,请先删除明细机构","更新失败,公司组织已经有明细机构");
			}
			deleteTreeByParent(mod.getOrgCode(),memberCode);
		}
		try{
			i = basicOrgMapper.deleteOrgByParent(orgParent, 0L, memberCode);
		}catch(Exception e){
			throw new BaseException("0301004","","删除["+orgParent+"]异常");
		}
		if(1!=i){
			throw new BaseException("0301005","","删除["+orgParent+"]失败:"+i);
		}
	}
	return 1;
}*/
	
	/**
	 * 获取组织根节点
	 * @return
	 *
	 * BasicOrg
	
	public BasicOrg getRootNode() {
		BasicOrg basicOrg = null;
		try {
		  basicOrg = basicOrgMapper.getRootNode();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("basicOrgService异常");
		}
		return basicOrg;
	} */
	
	/**
	 * 获取一级组织
	 * @return
	 *
	 * BasicOrg
	 */
	public List<BasicOrg> queryBasicOrg(String memberCode) {
		List<BasicOrg> list = null;
    	try{
    		list = basicOrgMapper.queryBasicOrg(memberCode);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException("一级组织查看失败");
    	}
        return list;
	}
	

    /**
     * 查询根据二级地名
     * @param memberCode 
     * @param orgParent 	所属一级组织的org_code（当orgNodecode传null时 则查出所有二级组织）
     */
    public List<BasicOrg> query2BasicOrg(String memberCode,String orgParent) {
    	List<BasicOrg> list = null;
    	try{
    		list = basicOrgMapper.query2BasicOrg(memberCode,orgParent);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException("二级组织查看失败");
    	}
        return list;
    }
    
    /**
     * 查看组织
     * @param bigDecimal
     * @return
     *
     * BasicOrg
     */
	public BasicOrg getOrgDetail(BigDecimal orgId) {
		BasicOrg basicOrg = null;
    	try{
    		basicOrg = basicOrgMapper.getOrgDetail(orgId);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException("地址详情查看失败");
    	}
        return basicOrg;
	}
	
	
	/**
	 * 查询组织  (分页)
	 * @param orgCode
	 * @return
	 *
	 * List<BasicOrg>
	 */
	public PageInfo queryByParentPage(String current_page,String page_size,String orgCode) {
    	 PageInfo<BasicOrg> pageInfo=null;
			try {
				PageHelper.startPage(Integer.parseInt(current_page), Integer.parseInt(page_size));  // 开启分页，必须
				
				 // 对原来的查询方法不需要任何修改
				 Long orgIsleaf = 1L;
		    	 String memberCode = "0000";
				 List<BasicOrg> basicOrgList = basicOrgMapper.queryByParent(orgCode, orgIsleaf, memberCode);
				  
				 pageInfo = new PageInfo<BasicOrg>(basicOrgList);
				  
			} catch (Exception e) {
				e.printStackTrace();
				throw new BaseException("机构查看失败");
			}
        return pageInfo;
	}
	
	/**
	 * 查询组织或集团下拉列表  
	 * @param memberCode Long orgIsleaf = 1L;
	 * @return
	 *
	 * List<BasicOrg>
	 */
	public List<BasicOrg> queryOrgCombo(String memberCode,Long orgIsleaf) {
		List<BasicOrg> list = null;
    	try{
    		list = basicOrgMapper.queryOrgCombo(memberCode, orgIsleaf);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException("机构查看失败");
    	}
        return list;
	}
	
	/**
	 * 获取机构信息
	 * @param list
	 * @return 
	 *
	 * Map<String,BasicOrg>
	 */
	/**
	 * 获取机构信息
	 * @param list
	 * @return 
	 *
	 * Map<String,BasicOrg>
	 */
	public Map<String,BasicOrg> getBasicOrgMap(){
		
		Map<String,BasicOrg> map = null;
		List<BasicOrg> list = queryAll();
		
		if(list!=null && list.size()>0){
			
			map = new HashMap<String,BasicOrg>();
			for(BasicOrg org:list){
				map.put(org.getMemberCode()+"-"+org.getOrgCode(), org);
			}
			
		}
		return map;
		
	}
	
	/**
	 * 分页查询
	 * @param memberCode
	 * @param orgParent
	 * @return
	 *
	 * PageInfo
	 */
	public PageInfo query2BasicOrgForPage(String memberCode, String orgParent) {
		// TODO Auto-generated method stub
		return null;
	} 
}
