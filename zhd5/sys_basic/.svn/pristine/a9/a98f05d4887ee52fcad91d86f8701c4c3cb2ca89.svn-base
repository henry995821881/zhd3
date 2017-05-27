<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>

	<body>
	<div class="main_content">
		
			<div class="main_content_left">
				<h4 class="title">部门组织</h4>
				<!-- <ul class="crud_menu">
					<li class="fl_l add_group_icon"><i class="icon iconfont icon-tianjia"></i>增加</li>
					<li class="fl_l modify_group_icon"><i class="icon iconfont icon-zhibiaopeizhi"></i>修改</li>
					<li class="fl_l delete_group_icon"><i class="icon iconfont icon-shanchu1"></i>删除</li>
				</ul> -->
				<ul class="menu_content" id="deptTreeLeft">
					<!-- <li class="menu_content_group">
						<ul class="nav_list_toggle menu_content_group_node">
							<li>
								<i class="icon iconfont icon-wenjianjia-shouqi"></i>
								<span>集团部门</span>
							</li>
						</ul>
						<ul class="pl_10 hidden">
							<li class="nav_list_toggle menu_content_group_node"><i class="icon iconfont icon-wenjianjia-shouqi"></i>
								<span>江苏智恒达</span>
							</li>
						</ul>
					</li>
					<li class="menu_content_group">
						<ul class="nav_list_toggle menu_content_group_node">
							<li>
								<i class="icon iconfont icon-wenjianjia-shouqi"></i>
								<span>集团部门</span>
							</li>
						</ul>
						<ul class="pl_10 hidden">
							<li class="nav_list_toggle menu_content_group_node"><i class="icon iconfont icon-wenjianjia-shouqi"></i>
								<span>江苏智恒达</span>
							</li>
						</ul>
					</li> -->
				</ul>
			</div>
			<div class="main_content_right">
				<div class="crud_menu">
					<ul class="">
						<li data_opt="add_table" class="fl_l add_table_icon opt_"><i class="icon iconfont icon-tianjia "></i>增加</li>
						<li data_opt="update_table" class="fl_l modify_table_icon opt_"><i class="icon iconfont icon-zhibiaopeizhi"></i>修改</li>
						<li data_opt="del_table"  class="fl_l delete_table_icon opt_"><i class="icon iconfont icon-shanchu1"></i>删除</li>
					</ul>
				</div>
				
				
				<div id="content_dept">
				
				</div>
				
				<div id="pageHtml" class="main_content_right_page">
				
				</div>
				
				<!-- 表格 -->
				<div class="add_table" id="add_table" data-flag="">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_table_close"></i>
						<span>部门设置</span>
					</h4>
					<ul class="add_table_content">
						<form id="add_dept_table">
						<input type="text" name="deptNodecode" id="DeptNodecode" value="" style="display: none;"/>
						<input type="text" name="deptCode" id="DeptCode" value="" style="display: none;"/>
							<li class="fl_l">
								<span>部门名称<b class="required">*</b>：</span>
								<input type="text" name="deptName" id="Department" value="" class="table_detail_empty" />
							</li>
							<li class="fl_l">
								<span>上级组织<b class="required">*</b>：</span>
								<select name="deptParent" id="Organization" class="table_detail_empty">
								</select>
							</li>
							<li class="fl_l">
								<span>负责人：</span>
								<input type="text" name="deptManager" id="Principal" value="" class="table_detail_empty" />
							</li>
							<li class="cl remark">
								<span>备注：</span>
								<textarea name="deptRemark" id="Remark" class="remarks table_detail_empty"></textarea>
							</li>
							<li class="text_r">
								<input type="button" class="add_table_submit" value="保存" />
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
							</li>
						</form>
					</ul>
				</div>
				<!-- <div class="add_table" id="add_jt">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_group_close"></i>
						<span>公司组织</span>
					</h4>
					<ul class="add_table_content">
						<form action="" method="post">
							<li>
								<span>组织名称：</span>
								<input type="text" name="GroupName" id="GroupName" value="" />
							</li>
							<li class="remark">
								<span>备注：</span>
								<textarea name="Remark" id="Remark" class="remarks"></textarea>
							</li>
							<li class="text_r">
								<input type="submit" class="add_table_submit" value="保存" />
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
							</li>
						</form>
					</ul>
				</div> -->
			</div>

		</div>
		</script>
		
		
		<script id="deptTree" type="text/html">
		<% for(var i=0;i<data.length;i++) {%>
		<li class="menu_content_group">
			<ul class="nav_list_toggle menu_content_group_node" id="<%=data[i].first.deptNodecode%>" deptCode="<%=data[i].first.deptCode%>" deptId="<%=data[i].first.deptId%>" value="1">
									
				<li>
					<i class="icon iconfont icon-wenjianjia-shouqi" ></i>
					<span><%=data[i].first.deptName%></span>
				</li>

			</ul>

			<ul id="deptTreeLeft" class="pl_10 hidden" >
				<% for(var j=0;j<data[i].second.length;j++) {%>
					<ul class="nav_list_toggle menu_content_group_node" id="<%=data[i].second[j].deptNodecode%>" deptCode="<%=data[i].second[j].deptCode%>" deptId="<%=data[i].second[j].deptId%>" value="2">
						<li>
							<i class="icon iconfont icon-wenjianjia-shouqi" ></i>
							<span><%=data[i].second[j].deptName%></span>
						</li>
					</ul>
				<%}%>
			</ul>
		</li>
		<%}%>
		
		</script>
		
		
		<script id="DeptManage" type="text/html">

<div class="main_content_right_table">	
		<table id="tbl" class="table" cellspacing="1">
				<td>部门名称</td>
				<td>部门代码</td>
				<td>上级组织</td>
				<td>负责人</td>
			</tr>

		<%for(var j = 0;j<data.length;j++){%>
			<tr class="table_detail"  deptId="<%=data[j].deptId%>" deptNodecode="<%=data[j].deptNodecode%>">
				<td deptCode='<%=data[j].deptCode%>'><%=data[j].deptName%></td>
				<td><%=data[j].deptCode%></td>
				<td><%=data[j].deptParent%></td>
				<td><%=data[j].deptManager%></td>

			</tr>
		<%}%>
		</table>
	</div>
	
		</script>
		
		
		<script src="${base}/js/orgManage/deptManage.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>