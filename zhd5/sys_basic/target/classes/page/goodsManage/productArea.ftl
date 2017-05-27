<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>

	<body>
	
	<div class="main_content_left">
				<h4 class="title">查询</h4>
				<ul class="menu_content Inquire">
					<form id="form_query">
						<li class="menu_content_list">
							<span>代码：</span>
							<input type="text" name="productareaCode" id="NameInquire" value="" />
						</li>
						<li class="menu_content_list">
							<span>产地：</span>
							<input type="text" name="productareaName" id="NameInquire" value="" />
						</li>
						<li class="menu_content_list">
							<input type="button" onclick="query_form_button();" name="Inquire" id="Inquire" value="查询" class="InquireButton bg_1199c4" />
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
						<li data="del" class="fl_l delete_table_icon oper_"><i class="icon iconfont icon-shanchu1"></i>删除</li>
					</ul>
				</div>
				
				<div id="content_product_area"></div>
				
				<div id="pageHtml" class="main_content_right_page">
					
				</div>
				<div class="add_table" id="add_table">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_table_close"></i>
						<span>产地设置</span>
					</h4>
					<ul class="add_table_content">
						<form  id="form_product_area">
							<li class="fl_l">
								<span>产地<b class="required">*</b>：</span>
								<input type="text" name="productareaName" id="Origin" value="" class="table_detail_empty"/>
							</li>
							<li class="fl_l">
								<span>助记码：</span>
								<input type="text" name="productareaMnemcode" id="Assistant" value="" class="table_detail_empty"/>
							</li>
							<li class="cl remark">
								<span>备注：</span>
								<textarea name="productareaRemark" id="Remark" class="remarks table_detail_empty"></textarea>
							</li>
							<li class="text_r">
							<input type="hidden" id="productareaCode_1" name="productareaCode" />
								<input type="button" onclick="product_area_oper();" class="add_table_submit" value="保存" />
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
							</li>
						</form>
					</ul>
				</div>
			</div>
		<script id="product_area_tpl" type="text/html">
			
				<div class="main_content_right_table">
					<table id="tbl" class="table" cellspacing="1">
						<tr class="table_title">
							<td>代码</td>
							<td>产地</td>
							<td>助记码</td>
							<td>备注</td>
						</tr>
<%for(var i=0;i<data.length;i++){%>
						<tr class="table_detail">
							<td data='<%=data[i].productareaCode%>'><%=data[i].productareaCode%></td>
							<td data='<%=data[i].productareaName%>'><%=data[i].productareaName%></td>
							<td data='<%=data[i].productareaMnemcode%>'><%=data[i].productareaMnemcode%></td>
							<td data='<%=data[i].productareaRemark%>'><%=data[i].productareaRemark%></td>
						</tr>
<%}%>
					</table>
				</div>
				
				
	</script>
		<script src="${base}/js/goodsManage/productArea.js" type="text/javascript" charset="utf-8"></script>
		
		
	</body>

</html>