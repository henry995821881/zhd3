//pageHtml();//初始化分页元素
mainContentLeft();






/****************************分页****************************/
var page_size = 23;
var current_page_g=1;
function page_init(current_page_,max_page_){
		
	//初始化页面分页
	   pageHtml();
//分页
	 $('.pagination').jqPagination({
		//link_string : '/?page={page_number}',
		current_page: current_page_, //设置当前页 默认为1
		max_page : max_page_, //设置最大页 默认为1
		page_string : '当前第{current_page}页,共{max_page}页',
		paged :function(c_page) {
			//回发事件。。。
			current_page_g = c_page;
			query_(c_page);
		}
	});
	
}
/********************************************************/

query_(1);






//表单查询
function query_form_button(){
	query_(1);
	
}
//查询表单重置
//.....


/**
 * 模糊查询
 */
function query_(current_page_){
	
	
	
	var $form = $('#form_query');

	var data = $form.serialize();
	data = data+"&current_page=" +current_page_;
	data = data+"&page_size=" +page_size;
	
	$.post("warehouseManage/query/page",
			  data,
			  function(d,status){
		var content= eval("("+d+")");
		//验证返回数据
	
					var WarehouseSettinghtml = template('WarehouseSetting', content);
				
					
					$("#content_warehouse").html(WarehouseSettinghtml);
				
					aTable();
					
					
					page_init(current_page_,content.max_page);
					
				 
			  });
	
	
}




/**
 * 
 * 
 * 
 */

var Verification_Disabled = function() {
	if($('#WarehouseName').val() === '') {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}
var TableDetail = function(table_details) {
	
	$('#WarehouseName').val(table_details.eq(0).attr("data"));
	//
	$("#warehouseCode_1").val(table_details.eq(0).attr("warehouse_code"));
	 
	$('#Assistant').val(table_details.eq(2).attr("data"));
	$('#WarehouseType').val(table_details.eq(3).attr("data"));	
	
	if(table_details.eq(4).attr("data") =="1") {
		$('#Supervision').attr("checked", true);
		$("input[name='warehouseOwnSupervise']").val("1");
	}else{
		$('#Supervision').removeAttr("checked");
		$("input[name='warehouseOwnSupervise']").val("0");
	}
	
	
	if(table_details.eq(5).attr("data")=="1") {
		$('#Location').attr("checked", true);
		$("input[name='warehouseWareplace']").val("1");
	}else{
		
		$('#Location').removeAttr("checked");
		$("input[name='warehouseWareplace']").val("0");
	}
	
	
	
	$('#Area').val(table_details.eq(6).attr("data"));
	$('#Contact').val(table_details.eq(7).attr("data"));
	$('#Phone').val(table_details.eq(8).attr("data"));
	$('#Tel').val(table_details.eq(9).attr("data"));
	$('#Add').val(table_details.eq(10).attr("data"));
	$('#Remark').val(table_details.eq(11).attr("data"));
}
/*
 * var table_detail_empty = function() { $('#WarehouseName').val('');
 * $('#Assistant').val(''); $('#WarehouseType').val(''); $('#Area').val('');
 * $('#Contact').val(''); $('#Phone').val(''); $('#Tel').val('');
 * $('#Add').val(''); $('#Remark').val('');
 * $('#Location').removeAttr('checked');
 * $('#Supervision').removeAttr('checked'); }
 */
/*
 * $('#WarehouseName').on('blur', function() { var a = $(this); Verification(a);
 * Verification_Disabled();
 * 
 * 
 * 
 * 
 * });
 */

//判断是增加还是修改
var flag = "";
$("li.oper_").on('click', function() {
	
	flag = $(this).attr("data");
	
	//弹出
	if(flag=='add'){
		//验证
		 //跳出窗口
		 AddTable();
	}
	
	if(flag=='update'){
		
		 //验证
		if($('.table_detail.active').length <1){
			alert("请选择在修改！");
			return;
		}
		 //跳出窗口
		 ModifyTable();
	}
	
	
	if(flag=='del'){
		 //验证
		if($('.table_detail.active').length <1){
			alert("请选择！");
			return;
		}
	
		//删除
		PromptBox("是否删除仓库",'','1',function(r){
			
			if(r=='ok'){
				var warehouse_code= $('.table_detail.active').find('td').eq(0).attr("warehouse_code");
				
				var data={'warehouse_code':warehouse_code};
				var url = "warehouseManage/delete";
				$.post(url, data, function(d) {
					var content= eval("("+d+")");
					//验证返回数据
					if(!validated_return_data(content)){
						
						alert(content.msg);
						return;
					}
					query_(current_page_g);
					close_window();
					PromptBox("删除仓库成功",'','2',function(r){});
				});
				
			}
			
			
			
			
		});
		
		
	}
});





function oper_warehouse(){

	
	 if($("#Location").is(':checked')){
			
			$("input[name='warehouseWareplace']").val(1);
		}else{
			
			$("input[name='warehouseWareplace']").val(0);
			
		}
		
	   if($("#Supervision").is(':checked')){
			
			$("input[name='warehouseOwnSupervise']").val(1);
		}else{
			
			$("input[name='warehouseOwnSupervise']").val(0);
			
		}
	
	//验证
	   var msg =validated_form();
	   if(msg != 'ok'){
		   alert(msg);
		   return;
	   }
	
	 if(flag =="add"){
		 
		 
		 
		 save_warehouse();
		 
		 
	 }else if(flag =="update"){
		 
		
		 
		 update_warehouse();
		 
	 }
	

	
	
}


function update_warehouse(){
	
	//表单验证
	var $form = $('#add_warehouse');


   
   
   
	var data = $form.serialize();
	var url ="warehouseManage/update";
	$.post(url, data, function(d) {
		var content= eval("("+d+")");
		//验证返回数据
		if(!validated_return_data(content)){
			
			alert(content.msg);
			return;
		}
	
		query_(current_page_g);
		close_window();
			
		

	});
	
}





function save_warehouse(){
	
	
	//表单验证
	var $form = $('#add_warehouse');

	
   
   //
	
	var data = $form.serialize();
	var url ="warehouseManage/add";
	$.post(url, data, function(d) {
		var content= eval("("+d+")");
		//验证返回数据
		if(!validated_return_data(content)){
			
			alert(content.msg);
			return;
		}
	
		query_(1);
		close_window();
			
		

	});
	
	
}

/***
 * 表单验证
 * @returns {String}
 */
function validated_form(){
	var msg ='ok';
	
	if($("#WarehouseName").val()==''){
		
		msg="仓库名不能空";
	}
	
	
	
	return msg;
	
}


//@ sourceURL=product.js  

