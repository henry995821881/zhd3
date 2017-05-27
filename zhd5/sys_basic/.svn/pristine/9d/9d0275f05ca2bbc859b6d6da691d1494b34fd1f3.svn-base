<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>

	<body>
			<input type="hidden" id="page_areaNodecode" value="" />
			<input type="hidden" id="page_type" value="" />
			<input type="hidden" id="page_areaId" value="" />
			<input type="hidden" id="page_areaParent" value="" />
			
			<div class="main_content_left">
				<h4 class="title">地区</h4>
				<!-- <ul class="crud_menu">
					<li class="fl_l add_group_icon"><i class="icon iconfont icon-tianjia"></i>增加</li>
					<li class="fl_l modify_group_icon"><i class="icon iconfont icon-zhibiaopeizhi"></i>修改</li>
					<li class="fl_l delete_group_icon"><i class="icon iconfont icon-shanchu1"></i>删除</li>
				</ul> -->
				<ul class="menu_content" >

					<li class="menu_content_group">
						<ul class="nav_list_toggle menu_content_group_node" value="0">
							<li>
								<i class="icon iconfont icon-wenjianjia-shouqi" areaId=""></i>
								<span>地区设置</span>
							</li>
						</ul>
						<ul id="areaTreeLeft" class="pl_10 ">
							
						</ul>
					</li>
				</ul>
			</div>
			<div class="main_content_right">
				<div class="crud_menu">
					<ul class="">
						<li opt="add_table" class="fl_l add_table_icon opt_"><i class="icon iconfont icon-tianjia "></i>增加</li>
						<li opt="update_table" class="fl_l modify_table_icon opt_"><i class="icon iconfont icon-zhibiaopeizhi"></i>修改</li>
						<li opt="del_table" class="fl_l delete_table_icon opt_"><i class="icon iconfont icon-shanchu1"></i>删除</li>
					</ul>
				</div>
				<!-- 内容 -->
				<div id="content_area">	</div>
				
				<div id="pageHtml" class="main_content_right_page"></div>
				
				<div class="main_content_right_page">
					<ul>
						<li></li>
					</ul>
				</div>
				<!-- 表格 -->
				<div class="add_table" id="add_table">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_table_close"></i>
						<span>地区设置</span>
					</h4>
					<ul class="add_table_content">
						<form id="add_area_table" >
								<input type="hidden" name="afterupdate2query" id="afterupdate2query" value="" />
								<input type="hidden" name="areaParent" id="AreaParent" value="" />
								<input type="hidden" name="areaNodecode" id="AreaNodecode" value="" />
								<input type="hidden" name="areaId" id="areaId" value="" />
							<li class="fl_l">
								<span>地区名称<b class="required">*</b>：</span>
								<input type="text" name="areaName" id="AreaName" value="" />
							</li>
							<li class="fl_l">
								<span>助记码：</span>
								<input type="text" name="areaMnemcode" id="AssistantCode" value="" />
							</li>
							<li class="remark cl">
								<span>备注：</span>
								<textarea name="areaRemark" id="Remark" class="remarks"></textarea>
							</li>
							<li class="text_r">
								<input type="button" class="add_table_submit" onclick="save_table()" value="保存" />
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
							</li>
						</form>
					</ul>
				</div>
				
				<!-- 树形 -->
	<!-- 			<div class="add_table" id="add_jt">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_group_close"></i>
						<span>地区设置</span>
					</h4>
					<ul class="add_table_content">
						<form action="" method="post">
							<li class="fl_l">
								<span>地区名称：</span>
								<input type="text" name="GroupName" id="GroupName" value="" />
							</li>
							<li class="fl_l">
								<span>助记码：</span>
								<input type="text" name="AssistantCode" id="AssistantCode" value="" />
							</li>
							<li class="remark cl">
								<span>备注：</span>
								<textarea name="Remark" id="Remark" class="remarks"></textarea>
							</li>
							<li class="text_r" >
								<input type="submit" class="add_table_submit" value="保存" />
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
							</li>
						</form>
					</ul>
				</div> -->
			</div> 
		
		<script id="areaTree" type="text/html">
		<% for(var i=0;i<data.length;i++) {%>
		<li>	
						<ul class="nav_list_toggle menu_content_group_node init" areaName="<%=data[i].first.areaName%>" areamNemcode="<%=data[i].first.areamNemcode%>" areaRemark="<%=data[i].first.areaRemark%>" areaCode="<%=data[i].first.areaCode%>"  id="<%=data[i].first.areaNodecode%>" areaId="<%=data[i].first.areaId%>" value="1">
							<li>
								<i class="icon iconfont icon-wenjianjia-shouqi"></i>
									<span><%=data[i].first.areaName%></span>
							</li>
						</ul>

					<ul class="pl_10 hidden">
						<% for(var j=0;j<data[i].second.length;j++) {%>
								<li>
									<ul class="nav_list_toggle menu_content_group_node init" areaName="<%=data[i].second[j].areaName%>" areamNemcode="<%=data[i].second[j].areamNemcode%>" areaRemark="<%=data[i].second[j].areaRemark%>"  areaCode="<%=data[i].second[j].areaCode%>"  id="<%=data[i].second[j].areaNodecode%>" areaId="<%=data[i].second[j].areaId%>" value="2">
											<li>
												<i class="icon iconfont icon-wenjianjia-shouqi"></i>
												<span><%=data[i].second[j].areaName%></span>
											</li>
									</ul>
									<ul class="pl_10 hidden nextTree_ul" next="<%=data[i].second[j].areaId%>">
									</ul>
								</li>
						<%}%>	
					</ul>
				
		</li>		
		<%}%>
		
		</script>	
		
		<script id="nextTree" type="text/html">
					<% for(var j=0;j<data.length;j++) {%>	
						<li>
							<ul class="nav_list_toggle menu_content_group_node nextTree" areaName="<%=data[j].areaName%>" areamNemcode="<%=data[j].areamNemcode%>" areaRemark="<%=data[j].areaRemark%>"  areaCode="<%=data[j].areaCode%>" id="<%=data[j].areaNodecode%>" areaId="<%=data[j].areaId%>" value="3">
								<li>
										<i class="icon iconfont icon-wenjianjia-shouqi"></i>
										<span><%=data[j].areaName%></span>
								</li>
							</ul>
							<ul class="pl_10 hidden	nextTree_ul" next="<%=data[j].areaId%>">	
							</ul>
						<li>
					<%}%>	
		</script>
		
		
		<script id="AreaSetting" type="text/html">
			<div  class="main_content_right_table">	
				<table id="tbl" class="table" cellspacing="1">
					<tr class="table_title">
						<td>地区名称</td>
						<td>地区代码</td>
						<td>助记码</td>
						<td>备注</td>
					</tr>
			<% for(var j=0;j<data.length;j++) {%>
					<tr class="table_detail" areaParent="<%=data[j].areaParent%>" areaCode="<%=data[j].areaCode%>" areaId="<%=data[j].areaId%>" areaNodecode="<%=data[j].areaNodecode%>">
						<td><%=data[j].areaName%></td>
						<td><%=data[j].areaCode%></td>
						<td><%=data[j].areaMnemcode%></td>
						<td><%=data[j].areaRemark%></td>
					</tr>
			<% }%>
				</table>
			</div>
			<div id="page" class="main_content_right_page">
				<%include('mainpage')%>
			</div>
		</script>	
	
		<script src="${base}js/areaManage/areaManage.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>