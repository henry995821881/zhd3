<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>

	<body>
	<div class="main_content_left">
				<h4 class="title">品名设置</h4>
				<ul class="crud_menu">
					<li data="add"    class="fl_l add_group_icon pntree_oper"><i class="icon iconfont icon-tianjia"></i>增加</li>
					<li data="update" class="fl_l modify_group_icon pntree_oper"><i class="icon iconfont icon-zhibiaopeizhi"></i>修改</li>
					<li data="del"    class="fl_l delete_group_icon pntree_oper"><i class="icon iconfont icon-shanchu1"></i>删除</li>
				</ul>
				<ul class="menu_content" id="class_ul">
					
				</ul>
			</div>
			<div class="main_content_right">
				<div class="crud_menu">
					<ul class="">
						<li data="add" class="fl_l add_table_icon partsname_oper"><i class="icon iconfont icon-tianjia "></i>增加</li>
						<li data="update" class="fl_l modify_table_icon partsname_oper"><i class="icon iconfont icon-zhibiaopeizhi"></i>修改</li>
						<li data="del" class="fl_l delete_table_icon partsname_oper"><i class="icon iconfont icon-shanchu1"></i>删除</li>
					</ul>
				</div>
				<div id="content_partsname"></div>
				<div id="pageHtml" class="main_content_right_page">
					
				</div>
				<div class="add_table" id="add_table">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_table_close"></i>
						<span>品名设置</span>
					</h4>
					<ul class="add_table_content">
						<form id="form_partsname">
							<li class="fl_l">
								<span>品名<b class="required">*</b>：</span>
								<input type="text" class="table_detail_empty" name="partsnameName" id="Name" value="" />
							</li>
							<li class="fl_l">
								<span>助记码：</span>
								<input type="text" class="table_detail_empty" name="partsnameMnemcode" id="Assistant" value="" />
							</li>
							<li class="fl_l">
								<span>行业类别：</span>
								<select class="table_detail_empty" name="industryCode" id="IndustryCategory">
									
								</select>
							</li>
							<li class="fl_l">
								<span>品名大类<b class="required">*</b>：</span>
                               <!-- <input type="text"  class="table_detail_empty" name="pntreeName" id="NameCategory" value="123" />-->
								<span id="NameCategory"></span>
							</li>
							<li class="fl_l">
								<span>计件模式：</span>
								<select name="goodsPiecemode" class="table_detail_empty" id="PieceMode">
									<option value="0">默认</option>
									<option value="1">启用件支模式</option>
								</select>
							</li>
							<li class="fl_l">
								<span>计重模式：</span>
								<select class="table_detail_empty" name="goodsWeightmode" id="WeightMode">
									<option value="0">默认</option>
									<option value="1">过磅理算</option>
									<option value="2">湿吨干吨</option>
									
								</select>
							</li>
							<li class="fl_l">
								<span>计量方式：</span>
								<select class="table_detail_empty" name="goodsMetering" id="MeasurementMethod">
									<option value="理计">理计</option>
									<option value="磅计">磅计</option>
									<option value="干吨">干吨</option>
									<option value="湿吨">湿吨</option>
								</select>
							</li>
							<li class="fl_l">
								<span>计价方式：</span>
								<select class="table_detail_empty" name="goodsPriceun" id="PricingMethod">
									<option value="0">重量</option>
									<option value="1">数量</option>
									
									
								</select>
							</li>
							<li class="fl_l">
								<span>工作量系数：</span>
								<input class="table_detail_empty" type="number" name="partsnameWorkcoe" id="WorkloadFactor" value="" />
							</li>
							<li class="fl_l">
								<span>税率：</span>
								<input class="table_detail_empty" type="number" name="goodsTaxrate" id="TaxRate" value="" />
							</li>
							<li class="cl remark">
								<span>备注：</span>
								<textarea name="partsnameRemark" id="Remark" class="remarks table_detail_empty"></textarea>
							</li>
							<li class="text_r">
							<input type="hidden" name="partsnameCode" />
								<input type="button" onclick="save_update();" class="add_table_submit" value="保存" />
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
							</li>
						</form>
					</ul>
				</div>
				<div class="add_table" id="add_jt">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_group_close"></i>
						<span>品名大类设置</span>
					</h4>
					<ul class="add_table_content">
						<form id="pntree_form">
							<li>
								<span>名称<b class="required">*</b>：</span>
								<input type="text" name="pntreeName" id="GroupName" value="" />
							</li>
						
							
							<li class="remark">
								<span>备注：</span>
								<textarea name="Remark" id="Remark" class="remarks"></textarea>
							</li>
							<li class="text_r">
								<input type="button" onclick="pntree_oper();" class="add_table_submit" value="保存" />
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
							</li>
						</form>
					</ul>
				</div>
			</div>
			
			<script id="partnameclass_tpl" type="text/html">


   <%for(var i=0;i<data.length;i++){%>

                <li class="menu_content_group">
						<ul pntreeName = '<%=data[i].root.pntreeName%>'  pntreeCode ='<%=data[i].root.pntreeCode%>'  pntreeParentcode ='<%=data[i].root.pntreeParentcode%>' pntreeNodecode='<%=data[i].root.pntreeNodecode%>' class="nav_list_toggle menu_content_group_node">
							<li pntreeNodecode='<%=data[i].root.pntreeNodecode%>' class="event_tree">
								<i class="icon iconfont icon-wenjianjia-shouqi"></i>
								<span><%=data[i].root.pntreeName%></span>
							</li>
						</ul>
						<ul class="pl_10 hidden">

                          <%for(var j =0;j<data[i].second.length;j++){%>
							<li pntreeName='<%=data[i].second[j].pntreeName%>'  pntreeCode='<%=data[i].second[j].pntreeCode%>' pntreeParentcode='<%=data[i].second[j].pntreeParentcode%>' pntreeNodecode='<%=data[i].second[j].pntreeNodecode%>' 
							    class="event_tree nav_list_toggle menu_content_group_node">
                               <i class="icon iconfont icon-wenjianjia-shouqi"></i>
								<span><%=data[i].second[j].pntreeName%></span>
							</li>
                          <%}%>
							


						</ul>
					</li>



<%}%>

             </script>
		<script id="partname_tpl" type="text/html">
			
				<div class="main_content_right_table">
					<table id="tbl" class="table" cellspacing="1">
						<tr class="table_title">
							<td>品名</td>
							<td>代码</td>
							<td>助记码</td>
							<td>税率</td>
							<td>品名大类</td>
							<td>计件模式</td>
							<td>计重模式</td>
							<td>计量方式</td>
							<td>计价方式</td>
							<td>理算公式</td>
							<td>备注</td>
						</tr>
<%for(var i=0;i<data.length;i++){




var goodsWeightmode_desc='';
if(data[i].goodsWeightmode=='0'){
goodsWeightmode_desc ='默认';
}else if(data[i].goodsWeightmode=='1'){
goodsWeightmode_desc ='过磅理算';
}else if(data[i].goodsWeightmode=='2'){
goodsWeightmode_desc ='湿吨干吨';
}

var goodsPiecemode_desc='';
if(data[i].goodsPiecemode=='0'){
goodsPiecemode_desc ='默认';
}else if(data[i].goodsPiecemode=='1'){
goodsPiecemode_desc ='启用件只模式';
}

var goodsPriceun_desc='';
if(data[i].goodsPriceun=='0'){
goodsPriceun_desc='重量';
}else if(data[i].goodsPriceun=='1'){
goodsPriceun_desc='数量';
}


%>
						<tr industryCode='<%=data[i].industryCode%>' partsnameCode='<%=data[i].partsnameCode%>' class="table_detail">
							<td data='<%=data[i].partsnameName%>'><%=data[i].partsnameName%></td>
							<td data='<%=data[i].partsnameCode%>'><%=data[i].partsnameCode%></td>
							<td data='<%=data[i].partsnameMnemcode%>'><%=data[i].partsnameMnemcode%></td>
							<td data='<%=data[i].goodsTaxrate%>'><%=data[i].goodsTaxrate%></td>
							<td data='<%=data[i].pntreeName%>'><%=data[i].pntreeName%></td>
							<td data='<%=data[i].goodsPiecemode%>'><%=goodsPiecemode_desc%></td>
							<td data='<%=data[i].goodsWeightmode%>'><%=goodsWeightmode_desc%></td>
							<td data='<%=data[i].goodsMetering%>'><%=data[i].goodsMetering%></td>
							<td data='<%=data[i].goodsPriceun%>'><%=goodsPriceun_desc%></td>
							<td data='<%=data[i].partsnameFormula%>'><%=data[i].partsnameFormula%></td>
							<td data='<%=data[i].partsnameRemark%>'><%=data[i].partsnameRemark%></td>
							
							
						</tr>
						
<%}%>
					</table>
				</div>
				
				
				
		</script>
		
		<script src="${base}/js/goodsManage/partsname.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>