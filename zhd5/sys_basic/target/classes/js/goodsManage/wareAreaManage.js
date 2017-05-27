
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
/**
 * 加载仓库
 */


$.post("warehouseManage/query",
			  {
			    memeber_code:'0000'
			  },
			 
			  function(d,status){
				var content= eval("("+d+")");
			
					var html = template('warehouse_tpl', content);
					
					$("#warehouse_ul").html(html);
					
					
					
					aGroup();
					//绑定事件
					$("li.warearea_oper").on('click', function() {
						
						var warehouseCode = $(this).attr("warehouseCode");
						var warehouseName = $(this).attr("warehouseName");
						
						$("#warehouseName_1").val(warehouseName);
						$("#warehouseCode_1").val(warehouseCode);
						
						
						//
						//清空查询表单的库区货区
						$("#wareareaName_").val("");
						$("#wareareaGregion_").val("");
						
						query_(1);
						
					});
					
				
			  });




//查询
function query_form_button(){
	query_(1);
	
}

function reset_form_button(){

	$("#warehouseName_1").val("");
	$("#warehouseCode_1").val("");
	$("#wareareaName_").val("");
	$("#wareareaGregion_").val("");

}



/**
 * 加载库位
 */
	
function query_(current_page_){
	
	var $form = $('#form_query');

	var data = $form.serialize();
	data = data+"&current_page=" +current_page_;
	data = data+"&page_size=" +page_size;
	
	
	
	$.post("wareAreaManage/query/page",
			  data,
			 
			  function(d,status){
		var content= eval("("+d+")");
		//验证返回数据
		
			
				  
				   
					var html = template('LibrarySetting', content);
					
					$("#content_warearea").html(html);
					aTable();
					
				
					page_init(current_page_,content.max_page);
				
			  });

}



		
			
			
			



var Verification_Disabled = function() {
	if($('#ReservoirArea').val() === '') {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}
var TableDetail = function(table_details) {
	$("input[name='wareareaCode']").val(table_details.eq(1).attr("wareareaCode"));
	$('#ReservoirArea').val(table_details.eq(1).attr("data"));
	$('#CargoArea').val(table_details.eq(2).attr("data"));
	$('#Minimum').val(table_details.eq(3).attr("data"));	
	$('#Maximum').val(table_details.eq(4).attr("data"));
	$('#GraphicLines').val(table_details.eq(5).attr("data"));
	$('#GraphicColumns').val(table_details.eq(6).attr("data"));
	$('#Height').val(table_details.eq(7).attr("data"));
	$('#Width').val(table_details.eq(8).attr("data"));
	$('#Types').val(table_details.eq(10).attr("data"));
	$('#Remark').val(table_details.eq(9).attr("data"));
}
/*var table_detail_empty = function() {
	$('#ReservoirArea').val('');
	$('#CargoArea').val('');
	$('#Minimum').val('');
	$('#Maximum').val('');
	$('#GraphicLines').val('');
	$('#GraphicColumns').val('');
	$('#Height').val('');
	$('#Width').val('');
	$('#Types').val('');
	$('#Remark').val('');
}*/
$('#ReservoirArea').on('blur', function() {
	var a = $(this);
	Verification(a);
	Verification_Disabled();
});



//判断是增加还是修改
var flag = "";
$("li.oper_").on('click', function() {
	
	flag = $(this).attr("data");
	
	//弹出
	if(flag=='add'){
		//验证
		if($("li.menu_content_group_node.active").length <1){
			alert("请选择仓库！");
			return;
		}
		 //跳出窗口
		 AddTable();
	}
	
	if(flag=='update'){
		
		 //验证
		if($(".table_detail.active").length<1){
			alert("请选择对应的库区修改！")
			return;
		}
		 //跳出窗口
		 ModifyTable();
	}
	
	
	if(flag=='del'){
		
		//删除
		if($(".table_detail.active").length<1){
			alert("请选择对应的库区！")
			return;
		}
		PromptBox("是否删除库区",'','1',function(r){
			
			if(r=='ok'){
				var wareareaCode= $('.table_detail.active').find('td').eq(1).attr("wareareaCode");
				
				var data={'wareareaCode':wareareaCode};
				 var url ="wareAreaManage/delete";
				$.post(url, data, function(d) {

					var content= eval("("+d+")");
					//验证返回数据
					if(!validated_return_data(content)){
						
						alert(content.msg);
						return;
					}
					query_(current_page_g);
					close_window();
					PromptBox("删除库区成功",'','2',function(r){});
				});
				
				
			}
		}); 
	   
	
	}
});




function wareare_oper(){
	
	var msg = validated_form();
	if(msg !='ok'){
		
		alert(msg);
		return;
	}
	
     if(flag =="add"){
		 
		 save_warearea();
	 }else if(flag =="update"){
		 update_warearea();
	 }
	
	
}


function save_warearea(){
	
	
	//if(current_warehouse_code ==''){
		
	//	alert("选择仓库!");
	//	return;
	//}
	
	var	warehouseCode =$("li.menu_content_group_node.active").attr("warehouseCode");



$("#warehouseCode_2").val(warehouseCode);
	var $form = $('#form_warearea');
	var data = $form.serialize();
	
	var url ="wareAreaManage/add";
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



function update_warearea(){
	
	
	var	warehouseCode =$("li.menu_content_group_node.active").attr("warehouseCode");

	

	$("#warehouseCode_2").val(warehouseCode);
	
	
	var $form = $('#form_warearea');
	var data = $form.serialize();
	
	var url ="wareAreaManage/update";
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



/***
 * 表单验证
 * @returns {String}
 */
function validated_form(){
	var msg ='ok';
	
	if($("#ReservoirArea").val()==''){
		
		msg="库区不能空";
	}
	
	
	
	return msg;
	
}

//@ sourceURL=product.js  