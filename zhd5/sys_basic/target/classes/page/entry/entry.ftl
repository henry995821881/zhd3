<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${base}/css/font/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${base}/css/basic.css" />
		<link rel="stylesheet" href="${base}/js/plugin/css/jquery.bigautocomplete.css">
		<link rel="stylesheet" href="${base}/js/plugin/css/jqpagination.css">
		<script src="${base}/js/plugin/jquery.min.js"></script>
		<script src="${base}/js/plugin/jquery.bigautocomplete.js"></script>
		<script src="${base}/js/plugin/jquery.jqpagination.min.js"></script>
		<script src="${base}/js/plugin/WdatePicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="${base}/js/plugin/template-native.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="header" id="header">
			<ul>
					<li class="fl_r">
						<a href=""><i class="icon iconfont icon-yonghuguanli"></i> 您好，${user.operatorUser}【${user.orgName} - ${user.deptName}】</a>
						<a href="">帮助</a>
						<a href="${base}/logout">退出</a>
					</li>
					<li class="font_20 title">型云供应链集成管理平台</li>
				</ul>
		</div>
		<div class="menul_left" id="nav_left"></div>
		<div class="main_content">
			<div class="main_content_nav">
				<ul></ul>
			</div>
			<div id="content"></div>
		</div>
		<div class="mask"></div>
<div class="Prompt_box" id="Prompt_confirm">
			
		</div>
		<!--<div class="Prompt_box" id="Prompt_success">
			<div class="Prompt_text">删除成功</div>
			<div class="Prompt_button">
				<button class="Prompt_success_confirm">确认</button>
			</div>
		</div>-->
		<script id="navmenu" type="text/html">
			<div class="nav">
				<ul>
					<% for (var i = 0; i < menu.length; i ++) { %>
					<li class="nav_list">
						<span class="pl_10 nav_list_toggle hover">
							<i class="icon iconfont icon-wenjianjia-shouqi"></i><%= menu[i].title %>
						</span>
						<ul class="pl_10 hidden">
							<% for (var a=0;a<menu[i].child.length;a++){ %>
							<li class="nav_list">
								<span class="pl_10 nav_list_toggle hover">
									<i class="icon iconfont icon-wenjianjia-shouqi"></i><%= menu[i].child[a].title %>
								</span>
								<ul class="pl_10 hidden">
									<% for (var b=0;b<menu[i].child[a].list.length;b++){ %>
									<% if(menu[i].child[a].list[b].child.length<2){%>
									<li class="pl_10 nav_list hover" data-val='<%= menu[0].child[a].list[b].val %>'>
										<i class="icon iconfont icon-jiaochabiao"></i>
										<span><%= menu[0].child[a].list[b].name %></span>
									</li>
									<% } %>
									<% if(menu[i].child[a].list[b].child.length>1){%>
									<li class="pl_10 nav_list">
										<span class="pl_10 nav_list_toggle hover">
											<i class="icon iconfont icon-wenjianjia-shouqi"></i><%= menu[0].child[a].list[b].name %>
										</span>
										<ul class="pl_10 hidden">
											<% for (var c=0;c<menu[i].child[a].list[b].child.length;c++){ %>
											<% if(menu[i].child[a].list[b].child[c].child.length>1){%>
											<li class=" nav_list">
												<span class="pl_10 nav_list_toggle hover">
														<i class="icon iconfont icon-wenjianjia-shouqi"></i><%= menu[0].child[a].list[b].child[c].name %>
													</span>
												<ul class="pl_10 hidden">
													<% for (var d=0;d<menu[i].child[a].list[b].child[c].child.length;d++){ %>
													<li class="pl_10 nav_list hover" data-val='<%= menu[0].child[a].list[b].child[c].child[d].val %>'>
														<i class="icon iconfont icon-jiaochabiao"></i><span><%= menu[0].child[a].list[b].child[c].child[d].name %></span>
													</li>
													<% } %>
												</ul>
											</li>
											<% } %>
											<% if(menu[i].child[a].list[b].child[c].child.length<2){%>
											<li class="pl_10 nav_list hover" data-val='<%= menu[0].child[a].list[b].child[c].val %>'>
												<i class="icon iconfont icon-jiaochabiao"></i><span><%= menu[0].child[a].list[b].child[c].name %></span>
											</li>
											<% } %>

											<% } %>
										</ul>
									</li>
									<% } %>
									<% } %>
								</ul>
							</li>
							<% } %>
						</ul>
					</li>
					<% } %>
				</ul>
			</div>
		</script>
		<script type="text/javascript">
			var NavData = {
				menu: [{
					title: '平台支撑',
					child: [{
						title: '基础设置',
						list: [{
								name: '组织机构',
								child: [{
									name: '机构设置',
									val: '1',
									child: []
								}, {
									name: '部门设置',
									val: '2',
									child: []
								}, {
									name: '职员设置',
									val: '3',
									child: []
								}]
							},
							{
								name: '仓库物资',
								child: [{
									name: '仓库设置',
									val: '4',
									child: []
								}, {
									name: '库区设置',
									val: '5',
									child: []
								}, {
									name: '库位设置',
									val: '6',
									child: []
								}, {
									name: '品名设置',
									val: '7',
									child: []
								}, {
									name: '产地设置',
									val: '8',
									child: []
								}, {
									name: '物资代码',
									val: '9',
									child: []
								}]
							}
							/*{
								name: '财务资金',
								child: [{
									name: '开户银行设置',
									val: '10',
									child: []
								}, {
									name: '企业账户设置',
									val: '11',
									child: []
								}, {
									name: '币别设置',
									val: '12',
									child: []
								}]
							},
							{
								name: '条款设置',
								child: [{
									name: '系统代码设置',
									val: '13',
									child: []
								}, {
									name: '常用代码设置',
									val: '14',
									child: []
								}]
							},
							{
								name: '通用属性',
								child: [{
									name: '工种设置',
									val: '15',
									child: []
								}, {
									name: '工作组设置',
									val: '16',
									child: []
								}, {
									name: '工作量类别系统设置',
									val: '17',
									child: []
								}, {
									name: '工作量公式设置',
									val: '18',
									child: []
								}, {
									name: '工作量公式设置',
									val: '19',
									child: []
								}]
							},
							{
								name: '工作组设置',
								child: [{
									name: '费用类别设置',
									val: '20',
									child: []
								}, {
									name: '费用项目设置',
									val: '21',
									child: []
								}]
							},
							{
								name: '财务接口',
								child: [{
										name: '接口设置',
										child: [{
											name: '帐套设置',
											val: '22'
										}, {
											name: '凭证类型设置',
											val: '23'
										}, {
											name: '凭证分录设置',
											val: '24'
										}, {
											name: '凭证科目设置',
											val: '25'
										}, {
											name: '自定义合算项目',
											val: '26'
										}]
									},
									{
										name: '凭证管理',
										child: [{
											name: '生成凭证',
											val: '27'
										}, {
											name: '已生成凭证报表',
											val: '28'
										}]
									}
								]
							}*/
						]
					}, {
						title: '客户档案',
						list: [{
							name: '地区设置',
							child: [],
							val: '30',
						}, {
							name: '往来单位设置',
							child: [],
							val: '31',
						}]
					}]
				}]
			};
			var NavMenu = template('navmenu', NavData);
			document.getElementById('nav_left').innerHTML = NavMenu;
		</script>

		<script id="mainpage" type="text/html">
			<div class="pagination">
				<a href="#" class="first" data-action="first">&laquo;</a>
				<a href="#" class="previous" data-action="previous">&lsaquo;</a>
				<input type="text" readonly="readonly" data-max-page="<%= num%>" />
				<a href="#" class="next" data-action="next">&rsaquo;</a>
				<a href="#" class="last" data-action="last">&raquo;</a>
			</div>
		</script>
		<script type="text/javascript">
			var mainpageHtml = template('mainpage');
			
		</script>
		<script src="${base}/js/entry/entry.js" type="text/javascript" charset="utf-8"></script>
		<script src="${base}/js/basic.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>