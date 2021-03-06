package com.xyscm.sys.basic.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import com.xyscm.sys.basic.dao.BasicDeptMapper;
import com.xyscm.sys.basic.model.BasicDept;
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.vo.TreeBean;

@Service
public class BasicDeptService {
	
	@Autowired
	BasicDeptMapper basicDeptMapper;
		
		
	/**
	 * 查询部门组织树
	 * @param deptParent 父节点代码
	 * @param memberCode 使用单位
	 * @return
	 */
	public List<TreeBean> queryTree(String deptParent,String memberCode){
		if(StringUtils.isBlank(deptParent)){
			deptParent=SuperConstants.TREE_EMPTY;
		}
		List<BasicDept> list= basicDeptMapper.queryByParent(deptParent,0L,memberCode);
		List<TreeBean> treeList = new ArrayList<TreeBean>();
		if(null!=list&&!list.isEmpty()){
			setDeptChildren(list,treeList,0L);
		}
		return treeList;
	}
	/**
	 * 更新节点父节点代码
	 * @param deptCode 部门组织代码
	 * @param oldDeptNodecode 部门组织编号
	 * @param deptParent 父节点代码
	 * @param memberCode 使用单位
	 * @return
	 */
	public int updateTreeParent(String deptCode,String oldDeptNodecode,String deptParent,String memberCode){
		int i =0;
		String newDeptNodecode=getDeptNodecode(deptParent, deptCode);
		try{
			i=basicDeptMapper.updateDeptParentCode(deptCode, newDeptNodecode, deptParent, memberCode);
		}catch(Exception e){
			throw new BaseException("0302004","","更新组织部门["+deptCode+"]层次关系失败:异常");
		}
		if(1!=i){
			throw new BaseException("0302005","","更新组织部门["+deptCode+"]层次关系失败:异常");
		}
		try{//更新下级编号
			i=basicDeptMapper.updateDeptNodecode(oldDeptNodecode, newDeptNodecode, memberCode);
		}catch(Exception e){
			throw new BaseException("0302006","","更新组织部门["+deptCode+"]层次关系失败:异常");
		}
		return 1;
	}
	/**
	 * 通过部门组织代码删除部门组织(包含下级部门组织,不包括末级部门)
	 * @param deptCode 部门组织代码
	 * @param memberCode 使用单位
	 * @return
	 */
	public int deleteTree(String deptCode,String memberCode){
		if(StringUtils.isBlank(deptCode)){
			throw new BaseException("0302001","","删除失败:deptCode参数为空");
		}
		//检测是否有部门明细
		if(0<getCountByParentCode(deptCode,1L,memberCode)){
			throw new BaseException("0302006","部门组织已经有明细部门,请先删除明细部门","更新失败,部门组织已经有明细部门");
		}
		int i=0;
		try{
			i=basicDeptMapper.delete(deptCode, memberCode);
		}catch(Exception e){
			throw new BaseException("0302002","","删除["+deptCode+"]异常");
		}
		if(1!=i){
			throw new BaseException("0302002","","删除["+deptCode+"]失败:"+i);
		}
		i=deleteTreeByParent(deptCode, memberCode);
		if(1!=i){
			throw new BaseException("0302002","","删除["+deptCode+"]子节点信息失败:"+i);
		}
		return 1;
	}
	/**
	 * 通过部门组织部门代码,使用单位查询角色记录
	 * @param deptCode  部门组织代码(部门代码)
	 * @param memberCode 使用单位 
	 * @return
	 */
	public BasicDept getDeptByCode(String deptCode,String memberCode){
		return basicDeptMapper.getDeptByCode(deptCode,memberCode);
	}
	/**
	 * 查询信息
	 * @param deptName 部门名称
	 * @param memberCode 
	 * @return List<BasicDept>
	 */
	public BasicDept getDeptByName(String deptName,String memberCode){
		return basicDeptMapper.getByName(deptName, memberCode);
	}
	/**
	 * 查询信息
	 * @param bean 查询条件bean
	 * @param page 分页信息
	 * @return
	 */
	/*public List<BasicDept> query(QueryBean bean, PageTools page){
		return basicDeptMapper.query(bean, page);
	}*/
	/**
	 * 查询信息
	 * @param user 用户信息
	 * @param query 过滤部门代码或部门名称
	 * @param deptCode 部门组织代码(部门代码)
	 * @return
	 */
	/*public List<BasicDept> queryCombo(UserSession user, String query,String deptCode){
		return basicDeptMapper.queryCombo(user, query, deptCode);
	}*/
	/**
	 * 查询部门树
	 * @param user 用户信息
	 * @param query 过滤部门代码或部门名称
	 * @param deptCode 部门组织代码(部门代码)
	 * @return
	 */
	/*public List<TreeBean> queryCombotree(UserSession user, String query,String deptCode){ 
		List<BasicDept> list= basicDeptMapper.queryByParent(SuperConstants.TREE_EMPTY,0L,user.getMemberCode());
		List<TreeBean> treeList = new ArrayList<TreeBean>();
		if(null!=list&&!list.isEmpty()){
			setDeptChildren(list,treeList,null,user);
		}
		return treeList;
	}*/
	/**
	 * 新增记录
	 * @param mod
	 * @return 1 成功 -1 失败
	 */
	public int save(BasicDept mod){
		int i = 0;
		try {
			i = basicDeptMapper.save(mod);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_DEPT_ADD.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_DEPT_ADD.getErrCode()));
		}
		return i;
		
		/*String msg = checkDept(mod);
		if (StringUtils.isNotBlank(msg)) {
			throw new BaseException("0302005", "操作失败:"+msg, "新增失败,"+msg);
		}
		if (StringUtils.isBlank(mod.getDeptCode())) {
			mod.setDeptCode(basicDeptMapper.getMaxDeptCode()+1);
		}
		String str="";
		if(0==mod.getDeptIsleaf().intValue()){
			str="组织";
		}else{
			str="部门";
		}
		BasicDept oldMod=basicDeptMapper.getByCode(mod.getDeptCode());
		if(null!=oldMod){
			throw new BaseException("0302006","操作失败："+str+"代码已经存在","新增失败,信息["+mod.getDeptCode()+"]失败:已经存在");
		}
		oldMod=basicDeptMapper.getByName(mod.getDeptName(), mod.getMemberCode());
		if(null!=oldMod){
			throw new BaseException("0302007","操作失败："+str+"名称已经存在","新增失败,信息["+mod.getDeptName()+"/"+mod.getMemberCode()+"]失败:已经存在");
		}
		//给树结点编码赋值
		mod.setDeptNodecode(getDeptNodecode(mod.getDeptParent(),mod.getDeptCode()));
		try {
			basicDeptMapper.save(mod);
		} catch (Exception e){
			throw new BaseException("0302009", "", "插入信息["+mod.getDeptCode()+"/"+mod.getDeptName()+"/"+mod.getMemberCode()+"]保存失败,异常");
		}*/
		
	}
	/**
	 * 更新记录
	 * @param mod
	 * @return 1 成功 -1 失败
	 */
	public int update(BasicDept mod){
		int update = 0;
		try {
			update = basicDeptMapper.update(mod);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_DEPT_UPDATE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_DEPT_UPDATE.getErrCode()));
		}
		return update;
		
		/*String msg = checkDept(mod);
		if (StringUtils.isNotBlank(msg)) {
			throw new BaseException("03020010", "操作失败:" + msg, "更新失败," + msg);
		}
		BasicDept oldMod=basicDeptMapper.getByCode(mod.getDeptCode());
		if(null==oldMod){
			throw new BaseException("03020011","操作失败,信息不存在","更新失败,信息["+mod.getDeptCode()+"]失败:不存在");
		}
		String str="";
		if(0==mod.getDeptIsleaf().intValue()){
			str="组织";
		}else{
			str="部门";
		}
		if(!oldMod.getDeptName().equals(mod.getDeptName())){
			BasicDept checkoldMod=basicDeptMapper.getByName(mod.getDeptName(), mod.getMemberCode());
			if(null!=checkoldMod){
				throw new BaseException("0302012","操作失败："+str+"名称已经存在","更新失败,信息["+mod.getDeptName()+"/"+mod.getMemberCode()+"]失败:已经存在");
			}
		}
		//当上级节点发生变化时重新给树结点编码赋值
		if(!oldMod.getDeptParent().equals(mod.getDeptParent())){
			mod.setDeptNodecode(getDeptNodecode(mod.getDeptParent(),mod.getDeptCode()));
		}else{//防止并发
			mod.setDeptNodecode(oldMod.getDeptNodecode());
		}
		try {
			mod.setDeptId(oldMod.getDeptId());
			basicDeptMapper.update(mod);
		} catch (Exception e){
			throw new BaseException("03020015", "", "更新信息["+mod.getDeptCode()+"/"+mod.getDeptName()+"/"+mod.getMemberCode()+"]保存失败,异常");
		}
		return 1;*/
	}
	/**
	 * 删除记录
	 * @param deptCode 部门代码
	 * @param memberCode 使用单位
	 * @return
	 */
	public int delete(String deptCode,String memberCode){
		int i = 0;
		try {
			i = basicDeptMapper.delete(deptCode, memberCode);
		} catch (Exception e){
			throw new BaseException("0301003", "", "删除["+deptCode+"/"+memberCode+"]异常");
		}
		return 1;
		/*if (StringUtil.isBlankOne(deptCode, memberCode)){
			throw new BaseException("0302001", "", "删除["+deptCode+"/"+memberCode+"]失败:memberCode为空");
		}
		int i = 0;
		try {
			i = basicDeptMapper.delete(deptCode, memberCode);
		} catch (Exception e){
			throw new BaseException("0302003", "", "删除["+deptCode+"/"+memberCode+"]异常");
		}
		if (1 != i){
			throw new BaseException("0302004", "", "删除["+deptCode+"/"+memberCode+"]失败:"+i);
		}
		return 1;*/
	}
	/**
	 * 查询所有信息
	 * 
	 * @return List<BasicDept>
	 */
	public List<BasicDept> queryAll(){
		return basicDeptMapper.queryAll();
	}
	
	
	/**
	 * 递归生成树
	 * @param list
	 * @param treeList
	 * @param deptIsleaf 部门属性(0：部门组,1：部门明细,null:所有)
	 */
	private void setDeptChildren(List<BasicDept> list,List<TreeBean> treeList,Long deptIsleaf) {
		if(null!=list&&!list.isEmpty()){
			for (BasicDept mod : list) {
				TreeBean treeBean = new TreeBean();
				setDeptToTree(mod, treeBean);
				//TODO 为了加快速度,后面需要从缓存中读取
				List<BasicDept> childrenList =basicDeptMapper.queryByParent(mod.getDeptCode(), deptIsleaf,mod.getMemberCode());
				List<TreeBean> childrenTreeList = new ArrayList<TreeBean>();
				setDeptChildren(childrenList,childrenTreeList,deptIsleaf);
				treeBean.setChildren(childrenTreeList);
				treeList.add(treeBean);
			}
		}
	}
	/*private void setDeptChildren(List<BasicDept> list,List<TreeBean> treeList,Long deptIsleaf,UserSession user) {
		if(null!=list&&!list.isEmpty()){
			for (BasicDept mod : list) {
				TreeBean treeBean = new TreeBean();
				setDeptToTree(mod, treeBean,user);
				//TODO 为了加快速度,后面需要从缓存中读取
				List<BasicDept> childrenList =basicDeptMapper.queryByParent(mod.getDeptCode(), deptIsleaf,mod.getMemberCode());
				List<TreeBean> childrenTreeList = new ArrayList<TreeBean>();
				setDeptChildren(childrenList,childrenTreeList,deptIsleaf,user);
				treeBean.setChildren(childrenTreeList);
				treeList.add(treeBean);
			}
		}
	}*/
	
	
	/**把组织部门信息赋值到树的对象
	 * @param mod
	 * @param treeBean
	 */
	private void setDeptToTree(BasicDept mod,TreeBean treeBean){
		
		treeBean.setId(mod.getDeptCode());
		treeBean.setFilterObj("'{deptParent:'"+mod.getDeptCode()+"',deptNodecode:'" + mod.getDeptNodecode()+"',memberCode:'" + mod.getMemberCode()+"'}'");
		
		treeBean.setText(mod.getDeptName());
		treeBean.setLoaded(true);
		if(1==mod.getDeptIsleaf().intValue()){//部门明细
			treeBean.setLeaf(true);
		}
	}
	/*private void setDeptToTree(BasicDept mod,TreeBean treeBean,UserSession user){
		if(null!=user&&StringUtils.isNotBlank(user.getOperatorUserid())){//下接树
			treeBean.setId(mod.getDeptNodecode());
		}else{
			treeBean.setId(mod.getDeptCode());
			treeBean.setFilterObj("'{deptParent:'"+mod.getDeptCode()+"',deptNodecode:'" + mod.getDeptNodecode()+"',memberCode:'" + mod.getMemberCode()+"'}'");
		}
		treeBean.setText(mod.getDeptName());
		treeBean.setLoaded(true);
		if(1==mod.getDeptIsleaf().intValue()){//部门明细
			treeBean.setLeaf(true);
		}
	}*/
	
	/**
	 * 获取节点编码
	 * @param deptParent 父节点代码
	 * @param deptCode 树节点代码
	 * @return
	 */
	private String getDeptNodecode(String deptParent,String deptCode){
		String deptNodecode="";
		if(!SuperConstants.TREE_EMPTY.equals(deptParent)){
			BasicDept parentMod=basicDeptMapper.getByCode(deptParent);
			if(null==parentMod || StringUtils.isBlank(parentMod.getDeptNodecode())){
				throw new BaseException("0302008","操作失败,上级节点编码为空","新增失败,信息["+deptParent+"]失败:上级节点编码为空");
			}
			deptNodecode=parentMod.getDeptNodecode();
			if(StringUtils.isNotBlank(deptCode)){
				deptNodecode+='.'+deptCode;
			}
		}else{
			deptNodecode=deptCode;
		}
		return deptNodecode;
	}
	
	/**
	 * 通过父结点代码,部门属性查询记录数
	 * @param deptParent 父结点代码
	 * @param deptIsleaf 部门属性(0：部门组,1：部门明细,null:所有)
	 * @param memberCode 使用单位
	 * @return
	 */
	private int getCountByParentCode(String deptParent,Long deptIsleaf,String memberCode){
		return basicDeptMapper.getCountByParentCode(deptParent, deptIsleaf,memberCode);
	}
	
	
	public int deleteTreeByParent(String deptParent,String memberCode) {
		if(StringUtil.isBlankOne(deptParent)){
			throw new BaseException("0302003","","删除失败:deptParent为空");
		}
		List<BasicDept> list =basicDeptMapper.queryByParent(deptParent,0L,memberCode);
		if(null!=list&&!list.isEmpty()){
			int i =0;
			for (BasicDept mod : list) {
				//检测是否有部门明细
				if(0<getCountByParentCode(mod.getDeptCode(),1L,memberCode)){
					throw new BaseException("0302006","部门组织已经有明细部门,请先删除明细部门","更新失败,部门组织已经有明细部门");
				}
				deleteTreeByParent(mod.getDeptCode(),memberCode);
			}
			try{
				i = basicDeptMapper.deleteDeptByParent(deptParent, 0L, memberCode);
			}catch(Exception e){
				throw new BaseException("0302004","","删除["+deptParent+"]异常");
			}
			if(1!=i){
				throw new BaseException("0302005","","删除["+deptParent+"]失败:"+i);
			}
		}
		return 1;
	}
	
	private String checkDept(BasicDept mod) {
		if(null==mod){
			return "数据为空";
		}
		String msg = "";
		if(null==mod.getDeptIsleaf()){
			mod.setDeptIsleaf(new BigDecimal(0L));
		}
		String str="";
		if(0==mod.getDeptIsleaf().intValue()){
			str="组织";
		}else{
			str="部门";
		}
		msg += StringUtil.isBlankToMsg(mod.getMemberCode(), "使用单位为空");
		msg += StringUtil.isBlankToMsg(mod.getDeptName(), str+"名称为空");
		if(1==mod.getDeptIsleaf().intValue()&&StringUtils.isBlank(mod.getDeptParent())){
			msg +="上级组织为空";
		}
		
		if (StringUtils.isNotBlank(msg) && msg.trim().endsWith(",")) {
			msg = msg.trim().substring(0, msg.trim().length() - 1);
		}
		if(StringUtils.isBlank(mod.getDeptParent())){
			mod.setDeptParent(SuperConstants.TREE_EMPTY);
		}
		return msg;
	}
	
	/**
	 * 获取一级部门
	 * @param memberCode
	 * @return
	 *
	 * List<BasicDept>
	 */
	public List<BasicDept> queryBasicDept(String memberCode) {
		List<BasicDept> list = null;
    	try{
    		list = basicDeptMapper.queryBasicDept(memberCode);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException("一级部门查看失败");
    	}
        return list;
	}
	
	/**
	 * 查询二级部门
	 * @param memberCode
	 * @param deptParent
	 * @return
	 *
	 * List<BasicDept>
	 */
	public List<BasicDept> query2BasicDept(String memberCode, String deptParent) {
		List<BasicDept> list = null;
    	try{
    		list = basicDeptMapper.query2BasicDept(memberCode,deptParent);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException("二级组织查看失败");
    	}
        return list;
	}
	
	/**
	 * 查询部门
	 * @param orgCode
	 * @return
	 *
	 * List<BasicOrg>
	 */
	public List<BasicDept> queryByParent(String deptCode) {
		List<BasicDept> list = null;
    	try{
    	    Long deptIsleaf = 1L;
    		String memberCode = "0000";
    		list = basicDeptMapper.queryByParent(deptCode, deptIsleaf, memberCode);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException("部门查看失败");
    	}
        return list;
	}
	
	/**
	 * 查询部门下拉列表
	 * @param memberCode Long orgIsleaf = 1L;
	 * @return
	 *
	 * List<BasicDept>
	 */
	public List<BasicDept> queryDeptCombo(String memberCode, Long deptIsleaf) {
		List<BasicDept> list = null;
    	try{
    		list = basicDeptMapper.queryDeptCombo(memberCode, deptIsleaf);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException("部门查看失败");
    	}
        return list;
	}
	
	/**
	 * 查询部门  (分页)
	 * @param deptCode
	 * @return
	 *
	 * List<BasicDept>
	 */
	public PageInfo<BasicDept> queryByParentPage(String current_page,
			String page_size, String deptCode) {
		PageInfo<BasicDept> pageInfo=null;
		try {
			PageHelper.startPage(Integer.parseInt(current_page), Integer.parseInt(page_size));  // 开启分页，必须
			
			 // 对原来的查询方法不需要任何修改
			 Long deptIsleaf = 1L;
	    	 String memberCode = "0000";
			 List<BasicDept> basicDeptList = basicDeptMapper.queryByParent(deptCode, deptIsleaf, memberCode);
			  
			 pageInfo = new PageInfo<BasicDept>(basicDeptList);
			  
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("机构查看失败");
		}
		return pageInfo;
	}
	
}
