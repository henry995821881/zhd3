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
				<h4 class="title">查询</h4>
				<ul class="menu_content Inquire">
					<form id="form_query">
						<li class="menu_content_list">
							<span>代码：</span>
							<input type="text" name="employeeCode" id="CodeInquire" value="" />
						</li>
						<li class="menu_content_list">
							<span>姓名：</span>
							<input type="text" name="employeeName" id="NameInquire" value="" />
						</li>
						<li class="menu_content_list">
							<span>助记码：</span>
							<input type="text" name="employeeMnemcode" id="MnemcodeInquire" value="" />
						</li>
						<li class="menu_content_list">
							<span>机构：</span>
							<select name="orgCode" id="OrgInquire">
							</select>
						</li>
						<li class="menu_content_list">
							<span>部门：</span>
							<select name="deptCode" id="DepartmentInquire">
							</select>
						</li>
						<li class="menu_content_list">
							<input type="button" onclick="query_();" name="Inquire" id="Inquire" value="查询" class="InquireButton bg_1199c4" />
							<input type="reset" value="重置" class="InquireButton" />
						</li>
					</form>
				</ul>
			</div>
			<div class="main_content_right">
				<div class="crud_menu">
					<ul class="">
						<li data="add" class="fl_l add_table_icon oper_"><i class="icon iconfont icon-tianjia "></i>增加</li>
						<li data="update" class="fl_l modify_table_icon oper_"><i class="icon iconfont icon-zhibiaopeizhi"></i>修改</li>
						<li data="del"  class="fl_l delete_table_icon oper_"><i class="icon iconfont icon-shanchu1"></i>删除</li>
					</ul>
				</div>
				
				<div id="content_employee">
				
				</div>
				
				<div id="pageHtml" class="main_content_right_page">
				
				</div>
				
				
				<div class="add_table" id="add_table" data-flag="">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_table_close"></i>
						<span>职员设置</span>
					</h4>
					<ul class="add_table_content">
						<form id="add_employee">
							<li class="fl_l">
								<span>姓名<b class="required">*</b>：</span>
								<input type="text" name="employeeName" id="Name" value="" class="table_detail_empty"/>
							</li>
							<li class="fl_l">
								<span>机构<b class="required">*</b>：</span>
								<select name="orgCode" id="Organization" class="table_detail_empty">
								</select>
							</li>
							<li class="fl_l">
								<span>部门<b class="required">*</b>：</span>
								<select name="deptCode" id="Department" class="table_detail_empty">
								</select>
							</li>
							<li class="fl_l">
								<span>助记码：</span>
								<input type="text" name="employeeMnemcode" id="Assistant" value="" class="table_detail_empty"/>
							</li>
							<li class="fl_l">
								<span>员工类别：</span>
								<select name="employeeClass" id="EmployeeCategory" class="table_detail_empty">
									<option value=""></option>
									<option value="合同工">合同工</option>
									<option value="实习生">实习生</option>
									<option value="试用工">试用工</option>
									<option value="正式员工">正式员工</option>
								</select>
							</li>
							<li class="fl_l">
								<span>职位：</span>
								<select name="employeeJob" id="Office" class="table_detail_empty">
									<option value=""></option>
									<option value="测试">测试</option>
									<option value="开发">开发</option>
									<option value="实施">实施</option>
									<option value="销售">销售</option>
								</select>
							</li>
							<li class="fl_l">
								<span>专业：</span>
								<select name="employeeSpecialty" id="Profession" class="table_detail_empty">
									<option value=""></option>
									<option value="电子商务">电子商务</option>
									<option value="电子信息工程">电子信息工程</option>
									<option value="会计">会计</option>
									<option value="计算机信息与技术">计算机信息与技术</option>
								</select>
							</li>
							<li class="fl_l">
								<span>职称：</span>
								<select name="employeeTechnical" id="JobTitle" class="table_detail_empty">
									<option value=""></option>
									<option value="初级">初级</option>
									<option value="中级">中级</option>
									<option value="高级">高级</option>
									<option value="特级">特级</option>
								</select>
							</li>
							<li class="fl_l">
								<span>性别：</span>
								<input type="radio" name="employeeSex" id="SexMan" value="男" />
								<label class="pr_10">男</label>
								<input type="radio" name="employeeSex" id="SexGirl" value="女" />
								<label class="pr_10">女</label>
							</li>
							<li class="fl_l">
								<span>学历：</span>
								<select name="employeeDegree" id="Education" class="table_detail_empty">
									<option value=""></option>
									<option value="本科">本科</option>
									<option value="硕士">硕士</option>
								</select>
							</li>
							<li class="fl_l">
								<span>政治面貌：</span>
								<select name="employeeParty" id="PoliticalStatus" class="table_detail_empty">
									<option value=""></option>
									<option value="团员">团员</option>
									<option value="党员">党员</option>
								</select>
							</li>
							<li class="fl_l">
								<span>民族：</span>
								<select name="employeeNation" id="Nation" class="table_detail_empty">
									<option value=""></option>
									<option value="汉族">汉族</option>
									<option value="回族">回族</option>
									<option value="满族">满族</option>
									<option value="维吾尔族">维吾尔族</option>
								</select>
							</li>
							<li class="fl_l">
								<span>籍贯：</span>
								<input type="text" name="employeeNative" id="NativePlace" value="" class="table_detail_empty"/>
							</li>

							<li class="fl_l">
								<span>出生日期：</span>
								<input type="text" name="employeeBirthday" id="Birthday" onClick="WdatePicker()" readonly="readonly">
							</li>
							<li class="fl_l">
								<span>婚姻：</span>
								<input type="radio" name="employeeMarriage" id="Married" value="已婚" />
								<label class="pr_10">已婚</label>
								<input type="radio" name="employeeMarriage" id="Unmarried" value="未婚" />
								<label class="pr_10">未婚</label>
							</li>
							<li class="fl_l">
								<span>入职时间：</span>
								<input type="text" name="employeeJoindate" id="EntryTime" onClick="WdatePicker()" readonly="readonly">
							</li>
							<li class="fl_l">
								<span>电子邮箱：</span>
								<input type="email" name="employeeEmail" id="Email" value="" class="table_detail_empty"/>
							</li>
							<li class="fl_l">
								<span>电话：</span>
								<input type="text" name="employeePhone" id="Phone" value="" class="table_detail_empty"/>
							</li>
							<li class="fl_l">
								<span>手机：</span>
								<input type="text" name="employeeMobile" id="Tel" value="" class="table_detail_empty"/>
							</li>
							<li class="fl_l">
								<span>身份证号：</span>
								<input type="text" name="employeeIdcard" id="IdNum" value="" class="table_detail_empty"/>
							</li>
							<li class="fl_l">
								<span>工种名称：</span>
								<select name="worktypeName" id="NameJobs" class="table_detail_empty">
									<option value=""></option>
									<option value="理货员">理货员</option>
									<option value="行车工">行车工</option>
									<option value="装卸工">装卸工</option>
								</select>
							</li>
							<li class="fl_l">
								<span>状态：</span>
								<input type="radio" name="employeeState" id="StatusOpen" value="0" />
								<label class="pr_10">启用</label>
								<input type="radio" name="employeeState" id="StatusDisabled" value="1" />
								<label class="pr_10">停用</label>
							</li>
							<li class="cl remark">
								<span>家庭地址：</span>
								<textarea name="employeeAddr" id="Address" class="remarks address" ></textarea>
							</li>
							<li class="cl remark">
								<span>备注：</span>
								<textarea name="employeeRemark" id="Remark" class="remarks"></textarea>
							</li>
							<li class="text_r">
								<input type="button" class="add_table_submit" onclick="oper_employee();" value="保存" />
								<input type="hidden" id="employeeCode_1" name="employeeCode" />
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
								
							</li>
						</form>
					</ul>
				</div>
			</div>
	<script id="EmployeeManage" type="text/html">


<div  class="main_content_right_table">	
					<table id="tbl" class="table" cellspacing="1">
						<tr class="table_title">
							<td>姓名</td>
							<td>代码</td>
							<td>机构</td>
							<td>部门</td>
							<td>助记码</td>
							<td>员工类别</td>
							<td>职位</td>
							<td>专业</td>
							<td>职称</td>
							<td>性别</td>
							<td>学历</td>
							<td>政治面貌</td>
							<td>民族</td>
							<td>籍贯</td>
							<td>婚姻</td>
							<td>状态</td>
							<td>出生日期</td>
							<td>入职时间</td>
							<td>身份证号</td>
							<td>工种名称</td>
							<td>电话</td>
							<td>手机</td>
							<td>电子邮箱</td>
							<td>家庭地址</td>
							<td>备注</td>
						</tr>

<%for(var i = 0;i<data.length;i++){%>
						<tr class="table_detail">
							<td data='<%=data[i].employeeName%>' employee_code='<%=data[i].employeeCode%>' ><%=data[i].employeeName%></td>
							<td data='<%=data[i].employeeCode%>'><%=data[i].employeeCode%></td>
							<td data='<%=data[i].orgCode%>'><%=data[i].orgCode%></td>
							<td data='<%=data[i].deptCode%>'><%=data[i].deptCode%></td>
							<td data='<%=data[i].employeeMnemcode%>'><%=data[i].employeeMnemcode%></td>
							<td data='<%=data[i].employeeClass%>'><%=data[i].employeeClass%></td>
							<td data='<%=data[i].employeeJob%>'><%=data[i].employeeJob%></td>
							<td data='<%=data[i].employeeSpecialty%>'><%=data[i].employeeSpecialty%></td>
							<td data='<%=data[i].employeeTechnical%>'><%=data[i].employeeTechnical%></td>
							<td data='<%=data[i].employeeTechnical%>'><%=data[i].employeeSex%></td>
							<td data='<%=data[i].employeeDegree%>'><%=data[i].employeeDegree%></td>
							<td data='<%=data[i].employeeParty%>'><%=data[i].employeeParty%></td>
							<td data='<%=data[i].employeeNation%>'><%=data[i].employeeNation%></td>
							<td data='<%=data[i].employeeNative%>'><%=data[i].employeeNative%></td>
							<td data='<%=data[i].employeeMarriage%>'><%=data[i].employeeMarriage%></td>
							<td data='<%=data[i].employeeState%>'><%=data[i].employeeState%></td>
							<td data='<%=data[i].employeeBirthday%>'><%=data[i].employeeBirthday%></td>
							<td data='<%=data[i].employeeJoindate%>'><%=data[i].employeeJoindate%></td>
							<td data='<%=data[i].employeeIdcard%>'><%=data[i].employeeIdcard%></td>
							<td data='<%=data[i].worktypeName%>'><%=data[i].worktypeName%></td>
							<td data='<%=data[i].employeePhone%>'><%=data[i].employeePhone%></td>
							<td data='<%=data[i].employeeMobile%>'><%=data[i].employeeMobile%></td>
							<td data='<%=data[i].employeeEmail%>'><%=data[i].employeeEmail%></td>
							<td data='<%=data[i].employeeAddr%>'><%=data[i].employeeAddr%></td>
							<td data='<%=data[i].employeeRemark%>'><%=data[i].employeeRemark%></td>
						</tr>
<%}%>
					</table>
				</div>

	</script>
	<script src="${base}/js/orgManage/employeeManage.js" type="text/javascript"></script>
		
	</body>

</html>