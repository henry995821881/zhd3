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
				<h4 class="title">机构设置</h4>
				<!--<ul class="crud_menu">
					<li class="fl_l add_group_icon"><i class="icon iconfont icon-tianjia"></i>增加</li>
					<li class="fl_l modify_group_icon"><i class="icon iconfont icon-zhibiaopeizhi"></i>修改</li>
					<li class="fl_l delete_group_icon"><i class="icon iconfont icon-shanchu1"></i>删除</li>
				</ul> -->
				<ul class="menu_content" id="orgTreeLeft">
				
					<!-- <% for (var i = 0; i < list.length; i ++) { %>
					<li class="menu_content_group">
						<ul class="nav_list_toggle menu_content_group_node">
							<li>
								<i class="icon iconfont icon-wenjianjia-shouqi"></i>
								<span><%= list[i] %></span>
							</li>
						</ul>
					</li>
					<% } %> -->
					
					<!-- <li class="menu_content_group">
						<ul class="nav_list_toggle menu_content_group_node">
							<li>
								<i class="icon iconfont icon-wenjianjia-shouqi"></i>
								<span id="rootNodeId"></span>
							</li>
						</ul>

						<ul id="orgTreeLeft" class="pl_10 ">
							
						</ul>
						<ul class="pl_10 hidden">
							<li >
								<ul class="nav_list_toggle menu_content_group_node" id="orgTreeLeft">
									<li>
										<i class="icon iconfont icon-wenjianjia-shouqi"></i>
										<span>北京市</span>
									</li>
									<li>
										<i class="icon iconfont icon-wenjianjia-shouqi"></i>
										<span>nan京市</span>
									</li>
								</ul>
								
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
				
				<div id="content_org">
				
				</div>
				
				<div id="pageHtml" class="main_content_right_page">
				
				</div>
				
				<!-- 表格 -->
				<div class="add_table" id="add_table" data-flag="">
					<h4 class="add_table_title">
								<i class="icon iconfont icon-shibai-yin add_table_close"></i>
								<span>机构设置</span>
								</h4>
					<ul class="add_table_content">
						<form id="add_org_table">
							<input type="text" name="orgNodecode" id="OrgNodecode" value="" style="display: none;"/>
							<input type="text" name="orgCode" id="OrgCode" value="" style="display: none;"/>
							<li class="fl_l">
								<span>机构名称<b class="required">*</b>：</span>
								<input type="text" name="orgName" id="Institution" value="" class="table_detail_empty" />
							</li>
							<li class="fl_l">
								<span>机构简称<b class="required">*</b>：</span>
								<input type="text" name="orgAbbreviate" id="Abbreviation" value="" class="table_detail_empty" />
							</li>
							<li class="fl_l">
								<span>上级组织<b class="required">*</b>：</span>
								<select name="orgParent" id="Organization" class="table_detail_empty">
									
								</select>
							</li>
							<li class="fl_l">
								<span>法人代表：</span>
								<input type="text" name="orgCorporation" id="Legal" value="" class="table_detail_empty" />
							</li>
							<li class="fl_l">
								<span>电话：</span>
								<input type="text" name="orgPhone" id="Tel" value="" class="table_detail_empty" />
							</li>
							<li class="fl_l">
								<span>传真：</span>
								<input type="text" name="orgFax" id="Fax" value="" class="table_detail_empty" />
							</li>
							<li class="fl_l">
								<span>账号：</span>
								<input type="text" name="orgAccounts" id="Account" value="" class="table_detail_empty" />
							</li>
							<li class="fl_l">
								<span>开会银行：</span>
								<input type="text" name="orgBankname" id="Bank" value="" class="table_detail_empty" />
							</li>
							<li class="fl_l">
								<span>税号：</span>
								<input type="text" name="orgTanu" id="TaxNum" value="" class="table_detail_empty" />
							</li>
							<li class="fl_l">
								<span>地址：</span>
								<input type="text" name="orgAddr" id="Add" value="" class="table_detail_empty" />
							</li>
							<li class="cl remark">
								<span>备注：</span>
								<textarea name="orgRemark" id="Remark" class="remarks table_detail_empty"></textarea>
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
								<input type="text" name="orgName" id="GroupName" value="" />
							</li>
							<li class="remark">
								<span>备注：</span>
								<textarea name="orgRemark" id="Remark" class="remarks"></textarea>
							</li>
							<li class="text_r">
								<input type="button"  onclick="oper_org();" class="add_table_submit" value="保存" />
								<!-- <input type="hidden" name="orgCodeZ" /> 
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
							</li>
						</form>
					</ul>
				</div> -->
			</div>
		</div>
		
		<script id="orgTree" type="text/html">
		<% for(var i=0;i<data.length;i++) {%>
		<li class="menu_content_group">
			<ul class="nav_list_toggle menu_content_group_node" id="<%=data[i].first.orgNodecode%>" orgCode="<%=data[i].first.orgCode%>" orgId="<%=data[i].first.orgId%>" value="1">
									
				<li>
					<i class="icon iconfont icon-wenjianjia-shouqi" ></i>
					<span><%=data[i].first.orgName%></span>
				</li>

			</ul>

			<ul id="orgTreeLeft" class="pl_10 hidden" >
				<% for(var j=0;j<data[i].second.length;j++) {%>
					<ul class="nav_list_toggle menu_content_group_node" id="<%=data[i].second[j].orgNodecode%>" orgCode="<%=data[i].second[j].orgCode%>" orgId="<%=data[i].second[j].orgId%>" value="2">
						<li>
							<i class="icon iconfont icon-wenjianjia-shouqi" ></i>
							<span><%=data[i].second[j].orgName%></span>
						</li>
					</ul>
				<%}%>
			</ul>
		</li>
		<%}%>
		
		</script>
		
		<script id="OrgManage" type="text/html">

<div  class="main_content_right_table">	
		<table id="tbl" class="table" cellspacing="1">
				<td>机构名称</td>
				<td>机构代码</td>
				<td>机构简称</td>
				<td>上级组织</td>
				<td>法人代表</td>
				<td>电话</td>
				<td>传真</td>
				<td>账号</td>
				<td>开户银行</td>
				<td>税号</td>
				<td>地址</td>
				<td>备注</td>
			</tr>

		<%for(var j = 0;j<data.length;j++){%>
			<tr class="table_detail"  orgId="<%=data[j].orgId%>" orgNodecode="<%=data[j].orgNodecode%>">
				<td orgCode='<%=data[j].orgCode%>'><%=data[j].orgName%></td>
				<td><%=data[j].orgCode%></td>
				<td><%=data[j].orgAbbreviate%></td>
				<td><%=data[j].orgParent%></td>
				<td><%=data[j].orgCorporation%></td>
				<td><%=data[j].orgPhone%></td>
				<td><%=data[j].orgFax%></td>
				<td><%=data[j].orgAccounts%></td>
				<td><%=data[j].orgBankname%></td>
				<td><%=data[j].orgTanu%></td>
				<td><%=data[j].orgAddr%></td>
				<td><%=data[j].orgRemark%></td>
			</tr>
		<%}%>
		</table>
	</div>
	
	
	
	
		</script>
		
		
		
		<script src="${base}/js/orgManage/orgManage.js" type="text/javascript" charset="utf-8"></script>
		
	</body>

</html>