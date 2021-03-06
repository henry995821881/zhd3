<#assign base=request.contextPath />

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>

	<body>
	
	<div class="main_content_left">
	
				<h4 class="title">品名大类</h4>
				<ul class="menu_content" id="class_ul_1">
					
				</ul>
			</div>
			<div class="main_content_right">
				<div class="crud_menu">
					<ul class="">
						<li data="add" class="fl_l add_table_icon goods_code_oper"><i class="icon iconfont icon-tianjia "></i>增加</li>
						<li data="update" class="fl_l modify_table_icon goods_code_oper"><i class="icon iconfont icon-zhibiaopeizhi"></i>修改</li>
						<li data="del" class="fl_l delete_table_icon goods_code_oper"><i class="icon iconfont icon-shanchu1"></i>删除</li>
						<li data="import" class="fl_l Import_table_icon goods_code_oper"><i class="icon iconfont icon-tianjia "></i>导入</li>
					</ul>
				</div>
				
				
				<!-- 内容-->
				<div id="content_goodsCode"></div>
				
				<div id="pageHtml" class="main_content_right_page">
					
				</div>
				<div class="add_table" id="Import_table">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_table_close"></i>
						<span>物资代码导入</span>
					</h4>
					<ul class="add_table_content">
						<form id="form_goods_code_import">
							<li >
								<span>附件：</span>
								<input type="file" name="" id="" value="" />
							</li>
							<li class="text_r">
								<input type="submit" class="add_table_submit" value="保存" />
							</li>
						</form>
					</ul>
				</div>
				<div class="add_table" id="add_table">
					<h4 class="add_table_title">
						<i class="icon iconfont icon-shibai-yin add_table_close"></i>
						<span>物资代码设置</span>
					</h4>
					<ul class="add_table_content">
						<form id="form_goods_code">
							<li class="fl_l">
								<span>品名<b class="required">*</b>：</span>
								<!--<input type="text" class="table_detail_empty" name="partsnameName" id="Name" value="" />-->
								
								
								<select class="table_detail_empty" name="partsnameName" id="Name">
								<!--<option value="品名a">品名a</option> -->
									
								</select>
							</li>
							<li class="fl_l">
								<span>材质<b class="required">*</b>：</span>
								<!--<input type="text" class="table_detail_empty" name="goodsMaterial" id="Material" value="" />-->
								
									<select class="table_detail_empty" name="goodsMaterial" id="Material">
								
								   </select>
							</li>
							<li class="fl_l">
								<span>规格<b class="required">*</b>：</span>
							<!--	<input type="text" class="table_detail_empty" name="goodsSpec" id="Specification" value="" />-->
								
								<select class="table_detail_empty" name="goodsSpec" id="Specification">
								
								   </select>
							</li>
							<li class="fl_l">
								<span>产地<b class="required">*</b>：</span>
								<select class="table_detail_empty" name="productareaName" id="Origin">
								<!-- <option value="产地a">产地a</option>
									<option value="产地b">产地b</option>
									<option value="产地c">产地c</option>
									<option value="产地d">产地d</option>
									<option value="产地D">产地D</option>
									-->
								</select>
							</li>
							<li class="fl_l">
								<span>数量单位：</span>
								<select class="table_detail_empty" name="partsnameNumunit" id="QuantityUnits">
									<option value="件">件</option>
									
								</select>
							</li>
							<li class="fl_l">
								<span>重量单位：</span>
								<select class="table_detail_empty" name="partsnameWeightunit" id="WeightUnit">
									<option value="吨">吨</option>
									
								</select>
							</li>
							<li class="fl_l">
								<span>助记码：</span>
								<input type="text" class="table_detail_empty" name="partsnameMnemcode" id="AssistantCode" value="" />
							</li>
							<li class="fl_l">
								<span>计件模式：</span>
								<select name="goodsPiecemode" class="table_detail_empty" id="goodsPiecemode_id">
									<option value="0">默认</option>
									<option value="1">启用件支模式</option>
								</select>
							</li>
							<li class="fl_l">
								<span>计重模式：</span>
								<select class="table_detail_empty" name="goodsWeightmode" id="goodsWeightmode_id">
									<option value="0">默认</option>
									<option value="1">过磅理算</option>
									<option value="2">湿吨干吨</option>
									
								</select>
							</li>
							<li class="fl_l">
								<span>计量方式：</span>
								<select class="table_detail_empty" name="goodsMetering" id="goodsMetering_id">
									<option value="理计">理计</option>
									<option value="磅计">磅计</option>
									<option value="干吨">干吨</option>
									<option value="湿吨">湿吨</option>
								</select>
							</li>
								<li class="fl_l">
								<span>计价方式：</span>
								<select class="table_detail_empty" name="goodsPriceun" id="goodsPriceun_id">
									<option value="0">重量</option>
									<option value="1">数量</option>							
								</select>
							</li>
								<li class="fl_l">
								<span>税率：</span>
								<input class="table_detail_empty" type="number" name="goodsTaxrate" id="goodsTaxrate_id" value="" />
							</li>
							<li class="fl_l">
								<span>米：</span>
								<input type="text" class="table_detail_empty" name="goodsProperty1" id="goodsProperty1_id" value="" />
							</li>
							<li class="fl_l">
								<span>米重：</span>
								<input type="text" class="table_detail_empty" name="goodsProperty2" id="goodsProperty2_id" value="" />
							</li>
							<li class="fl_l">
								<span>厂发理重：</span>
								<input type="number" class="table_detail_empty" name="goodsPmeterweight" id="goodsPmeterweight_id" value="" />
							</li>
							<li class="fl_l">
								<span>统计品名：</span>
								<select class="table_detail_empty" name="staPartsnameName" id="staPartsnameName_id">
									<option value="">1231</option>
								</select>
							</li>
							<li class="fl_l">
								<span>统计材质：</span>
								<select class="table_detail_empty" name="staGoodsMaterial" id="staGoodsMaterial_id">
									
								</select>
							</li>
							<li class="fl_l">
								<span>统计规格：</span>
								<select class="table_detail_empty" name="staGoodsSpec" id="staGoodsSpec_id">
									<option value="">1231</option>
								</select>
							</li>
							<li class="fl_l">
								<span>统计产地：</span>
								<select class="table_detail_empty" name="staProductareaName" id="staProductareaName_id">
									
								</select>
							</li>
							<li class="fl_l">
								<span>理重可改：</span>
								<!-- 0 or 1-->
								<input type="checkbox" class="table_detail_empty" name="dataAwedit" id="dataAwedit_id" value="1" />
							</li>
							
							<li class="fl_l">
								<span>10标米重：</span>
								<input type="number" class="table_detail_empty" name="m10sWeight" id="m10sWeight_id" value="" />
							</li>
							<li class="fl_l">
								<span>工作组：</span>
								<select class="table_detail_empty" name="workgroupName" id="workgroupName_id">
									<option value="">1231</option>
								</select>
							</li>
							<li class="cl remark">
								<span>备注：</span>
								<textarea id="Remark" name="partsnameRemark" class="remarks table_detail_empty"></textarea>
							</li>
							<li class="text_r">
								<input type="button" onclick="save_update();" class="add_table_submit" value="保存" />
								<input type="reset" name="" id="" class="add_table_reset" value="重置" />
							</li>
						</form>
					</ul>
				</div>
			</div>
		<script id="goods_code_tpl" type="text/html">
			
				<div class="main_content_right_table">
					<table id="tbl" class="table" cellspacing="1">
						<tr class="table_title">
							<td>物资代码</td>
							<td>品名大类</td>
							<td>品名</td>
							<td>材质</td>
							<td>规格</td>
							<td>产地</td>
							<td>税率</td>
							<td>数量单位</td>
							<td>重量单位</td>
							<td>助记码</td>
							<td>计件模式</td>
							<td>计重模式</td>
							<td>计量模式</td>
							<td>计价方式</td>
							<td>备注</td>
							<td>米</td>
							<td>米重</td>
							<td>厂发米重</td>
							<td>统计品名</td>
							<td>统计材质</td>
							<td>统计规格</td>
							<td>统计产地</td>
							<td>理重可改</td>
							<td>10标米重</td>
							
							<td>工作组</td>
						</tr>
						<%for(var i=0;i<data.length;i++){
						
						 var dataAwedit_ ='';
						if(data[i].dataAwedit==1){
						dataAwedit_ ='是';
						}else{
							dataAwedit_ ='否';
						}
						
						
						
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
						<tr class="table_detail">
							<td 
							goodscodeCode='<%=data[i].goodscodeCode%>'
							pntreeName='<%=data[i].pntreeName%>'
							partsnameName='<%=data[i].partsnameName%>'
							goodsMaterial='<%=data[i].goodsMaterial%>'
							goodsSpec='<%=data[i].goodsSpec%>'
							productareaName='<%=data[i].productareaName%>'
							goodsTaxrate='<%=data[i].goodsTaxrate%>'
							partsnameNumunit='<%=data[i].partsnameNumunit%>'
							partsnameWeightunit='<%=data[i].partsnameWeightunit%>'
							partsnameMnemcode='<%=data[i].partsnameMnemcode%>'
							goodsPiecemode='<%=data[i].goodsPiecemode%>'
							goodsWeightmode='<%=data[i].goodsWeightmode%>'
							goodsMetering='<%=data[i].goodsMetering%>'
							goodsPriceun='<%=data[i].goodsPriceun%>'
							partsnameRemark='<%=data[i].partsnameRemark%>'
							goodsProperty1='<%=data[i].goodsProperty1%>'
							goodsProperty2='<%=data[i].goodsProperty2%>'
							goodsPmeterweight='<%=data[i].goodsPmeterweight%>'
							staPartsnameName='<%=data[i].staPartsnameName%>'
							staGoodsMaterial='<%=data[i].staGoodsMaterial%>'
							staGoodsSpec='<%=data[i].staGoodsSpec%>'
							staProductareaName='<%=data[i].staProductareaName%>'
							dataAwedit='<%=data[i].dataAwedit%>'
							m10sWeight='<%=data[i].m10sWeight%>'
							workgroupName='<%=data[i].workgroupName%>'
							
							><%=data[i].goodscodeCode%></td>
							<td ><%=data[i].pntreeName%></td>
							<td ><%=data[i].partsnameName%></td>
							<td ><%=data[i].goodsMaterial%></td>
							<td ><%=data[i].goodsSpec%></td>
							<td ><%=data[i].productareaName%></td>
							<td ><%=data[i].goodsTaxrate%></td>
							<td ><%=data[i].partsnameNumunit%></td>
							<td ><%=data[i].partsnameWeightunit%></td>
							<td ><%=data[i].partsnameMnemcode%></td>
							<td ><%=goodsPiecemode_desc%></td>
							<td ><%=goodsWeightmode_desc%></td>
							<td ><%=data[i].goodsMetering%></td>
							<td ><%=goodsPriceun_desc%></td>
							<td ><%=data[i].partsnameRemark%></td>
							<td ><%=data[i].goodsProperty1%></td>
							<td ><%=data[i].goodsProperty2%></td>
							<td ><%=data[i].goodsPmeterweight%></td>
							<td ><%=data[i].staPartsnameName%></td>
							<td ><%=data[i].staGoodsMaterial%></td>
							<td ><%=data[i].staGoodsSpec%></td>
							<td ><%=data[i].staProductareaName%></td>
							<td ><%=dataAwedit_%></td>
							<td ><%=data[i].m10sWeight%></td>
							
							<td ><%=data[i].workgroupName%></td>
							
						</tr>
						<%}%>
						
					</table>
				</div>
				
			
		</script>
		
		
		<script id="partnameclass_tpl_1" type="text/html">


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
		<script src="${base}/js/goodsManage/goodsCode.js" type="text/javascript" charset="utf-8"></script>
		
		
	</body>

</html>