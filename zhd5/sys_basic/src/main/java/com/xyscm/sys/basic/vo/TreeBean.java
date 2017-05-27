package com.xyscm.sys.basic.vo;

import java.util.List;

public class TreeBean {
	 /**树节点ID*/
	private String id;
	/**树节点名称*/
	private String text;
	/** 图标 */
	private String icon;
	/**是否叶子*/
	private boolean leaf;
	/**true表示节点已经加载过数据*/
	private boolean loaded;
	/**链接地址*/
	private String jspath;
	/**菜单打开方式*/
	private Long showmode;
	/**JSON信息*/
	private String filterObj;
	/**子节点*/
	private List<TreeBean> children;
	
	/**首页快捷按钮属性*/
	private String thumb;
	private String url;
	private String type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getFilterObj() {
		return filterObj;
	}
	public void setFilterObj(String filterObj) {
		this.filterObj = filterObj;
	}
	public List<TreeBean> getChildren() {
		return children;
	}
	public void setChildren(List<TreeBean> children) {
		this.children = children;
	}
	public boolean isLoaded() {
		return loaded;
	}
	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}
	public String getJspath() {
		return jspath;
	}
	public void setJspath(String jspath) {
		this.jspath = jspath;
	}
	public Long getShowmode() {
		return showmode;
	}
	public void setShowmode(Long showmode) {
		this.showmode = showmode;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
