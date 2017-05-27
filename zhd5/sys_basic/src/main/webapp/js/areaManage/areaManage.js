
mainContentLeft();

var current_node ='';
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
			
			var areaNodecode = $("#page_areaNodecode").val();
			var type = $("#page_type").val();
			var areaId = $("#page_areaId").val();
			var areaParent = $("#page_areaParent").val();
			
			//回发事件。。。
			current_page_g = c_page;
			getdata(areaNodecode,type,areaId,areaParent,c_page);
		}
	});
	
}
/****************************分页****************************/

//地区列表
function init_data(){
	
	$.post("area/queryAllArea",
	  {
	    memeber_code:'0000'
	  },
	  function(d,status){
		  	var content= eval("("+d+")");
			var areaTree = template('areaTree', content);
			$("#areaTreeLeft").html(areaTree);
			
			//地区列表点击事件
//			$(".nav_list_toggle").off('click');
			$(".nav_list_toggle").on('click', function(item) {
				var areaNodecode = $(this).attr("id");
				var type = $(this).attr("value");
				var areaId = $(this).attr("areaId");	//地区id
				var areaParent = $(this).attr("areaCode");
				
				$("#page_areaNodecode").val(areaNodecode);
				$("#page_type").val(type);
				$("#page_areaId").val(areaId);
				$("#page_areaParent").val(areaParent);
				
				if(areaId != null){
					$("#areaId").val(areaId);
				}
				getdata(areaNodecode,type,areaId,areaParent,current_page_g);
				aTable();
			});
		aGroup();
	  });
}
init_data();


//获取列表数据
function getdata(areaNodecode,type,areaId,areaParent,current_page_g){
		
		$.ajaxSetup({
		  async: false
		 });
		
		$.post("area/query2BasicArea",
			{
			areaNodecode:areaNodecode,
			type:type,
			areaId:areaId,
			areaParent:areaParent,
			page_size:page_size,
			current_page:current_page_g
			}, 
			function(d) {
				
				var content= eval("("+d+")");
				var content_area = template('AreaSetting', content);
				$("#content_area").html(content_area);
				aTable();
				current_page_g=1;
				page_init(current_page_g,content.max_page);
				
				
				if(type == 0){//增加一级地区
					$("#AreaParent").val(-1);	
					$("#AreaNodecode").val("");	
				}else if(type == 1){//增加二级地区
					$("#AreaParent").val(content.basicArea.areaNodecode);	//上级地区的areaNodecode
					$("#AreaNodecode").val(content.basicArea.areaNodecode+".");	
				}else {
					$("#AreaParent").val(content.basicArea.areaCode);
					$("#AreaNodecode").val(content.basicArea.areaNodecode+".");	
					
					var nextTree = template('nextTree', content);
					$("ul[next="+areaId+"]").html(nextTree);
					$(".nav_list_toggle").off('click');

					$(".nav_list_toggle").on('click', function(item) {
						var areaNodecode = $(this).attr("id");
						var areaParent = $(this).attr("areaCode");
						var type = $(this).attr("value");
						var areaId = $(this).attr("areaId");	//地区id
						
						$("#page_areaNodecode").val(areaNodecode);
						$("#page_type").val(type);
						$("#page_areaId").val(areaId);
						$("#page_areaParent").val(areaParent);
						
						$.ajaxSetup({
							  async: false
							 });
						
						$.post("area/query2BasicArea",  
								{
								areaNodecode:areaNodecode,
								areaParent:areaParent,
								type:type,
								areaId:areaId,
								page_size:page_size,
								current_page:current_page_g
								}, 	function(d) {
							
									
									var content= eval("("+d+")");
									var nextTree = template('nextTree', content);
									$("ul[next="+areaId+"]").html(nextTree);
									
									var content_area = template('AreaSetting', content);
									$("#content_area").html(content_area);
								
									$("#AreaParent").val(content.basicArea.areaCode);
									$("#AreaNodecode").val(areaNodecode+".");	
								
									aTable();
									current_page_g=1;
									page_init(current_page_g,content.max_page);
									
									$(".nav_list_toggle").off('click');
									$(".nav_list_toggle").on('click', function(item) {
										var areaNodecode = $(this).attr("id");
										var type = $(this).attr("value");
										var areaId = $(this).attr("areaId");	//地区id
										var areaParent = $(this).attr("areaCode");
										
										$("#page_areaNodecode").val(areaNodecode);
										$("#page_type").val(type);
										$("#page_areaId").val(areaId);
										$("#page_areaParent").val(areaParent);
										
										if(areaId != null){
											$("#areaId").val(areaId);
										}
										getdata(areaNodecode,type,areaId,areaParent,current_page_g);
										aTable();
									});
								
									aGroup();
								});
					})
				aGroup();
				}
				
			});
		
	}



//操作-------表格
var opt_table_status = "";
$(".opt_").on('click',function(){
	
	opt_table_status = $(this).attr("opt");
	if(opt_table_status == 'add_table'){
		if(!$(".nav_list_toggle").hasClass('active')){
			alert("请选择节点");
			return;
		}
		
		$("#AreaName").val("");
		$("#AssistantCode").val("");
		$("#remarks").val("");
		
		AddTable();
	}
	if(opt_table_status == 'update_table'){
		
	/*	if(!$(".table_detail").hasClass('active')){
			if(!$(".nav_list_toggle").hasClass('active')){
				alert("请选择节点");
				return;
			}else{
				var areaName = $(".nav_list_toggle.active").attr("areaName");
				var areamNemcode = $(".nav_list_toggle.active").attr("areamNemcode");
				var areaRemark = $(".nav_list_toggle.active").attr("areaRemark");
				$("#AreaName").val(areaName);
				$("#AssistantCode").val(areamNemcode);
				$("#Remark").val(areaRemark);
			}
		}*/
		if(!$(".table_detail").hasClass('active')){
			alert("请选择节点");
			return;
		}
		ModifyTable();
	}
	if(opt_table_status == 'del_table'){
		del_table_area();
	}
})

function save_table(){
	if(opt_table_status == 'add_table'){
		add_table_area();
	}
	if(opt_table_status == 'update_table'){
		$("#AreaParent").val("");	
		$("#AreaNodecode").val("");
		update_table_area();
	}
	
}

//新增------表格
function add_table_area(){
	var $form = $('#add_area_table');
	
	var data = $form.serialize();
	var url ="area/insertArea";
	$.post(url, data, function(d) {
		var content = eval("("+d+")");
		if(!validated_return_data(content)){
			PromptBox(content.msg,'','2',function(r){});
			return;
		}
		PromptBox("新增成功",'','2',function(r){});
		init_data();
		close_window();
	});
}

//修改------表格
function update_table_area(){

	var areaId = $(".table_detail.active").attr("areaId");
	var areaNodecode = $(".table_detail.active").attr("areaNodecode");
	var areaParent = $(".table_detail.active").attr("areaParent");
	$("#areaId").val(areaId);
	$("#AreaNodecode").val(areaNodecode);
	$("#AreaParent").val(areaParent);
	$("#afterupdate2query").val(areaParent);
	
	var $form = $('#add_area_table');
	
	var data = $form.serialize();
	var url ="area/updateArea";
	$.post(url, data, function(d) {
		
		var content = eval("("+d+")");
		if(!validated_return_data(content)){
			PromptBox(content.msg,'','2',function(r){});
			return;
		}
		PromptBox("修改成功",'','2',function(r){});
		init_data();
		
		var areaId = $("#areaId").val();
		var areaParent = $("#afterupdate2query").val();
		
		$.post("area/query2BasicArea",  
			{
			areaParent:areaParent,
			type:2,
			areaId:areaId,
			page_size:page_size,
			current_page:current_page_g
			}, 	function(d) {
				var content= eval("("+d+")");
			
				var content_area = template('AreaSetting', content);
				$("#content_area").html(content_area);
				
				//表格选择事件
				$(".table_detail").on('click', function(item) {
					var areaId = $(this).attr("areaId");
					$("#areaId").val(areaId);
					var areaNodecode = $(this).attr("areaNodecode");
					$("#AreaNodecode").val(areaNodecode);
				});
				aTable();
				
			});
		
		
		close_window();
	
	});
}


//删除------表格
function del_table_area(){
	
	var areaNodecode = $(".table_detail.active").attr("areaNodecode");
	var areaParent = $(".table_detail.active").attr("areaCode");
	$("#AreaNodecode").val(areaNodecode);
	$("#AreaParent").val(areaParent);
	
	if(areaNodecode == undefined && areaParent == undefined){
		areaNodecode  = $("#page_areaNodecode").val();
		areaParent = $("#page_areaParent").val();
	}
	
	PromptBox('是否确定删除','','1',function(r){
		if(r == 'ok'){
			var data = {areaNodecode:areaNodecode,areaParent:areaParent};
			var url ="area/deleteArea";
			$.post(url, data, function(d) {
			 	var content= eval("("+d+")");
			 	if(content.msg == "error"){
			 		PromptBox('该地区下有子地区，不可删除','','2',function(r){});
			 		return;
			 	}
		 		PromptBox('删除成功','','2',function(r){});
			 	init_data();
			});
		}
	}
	
}


var Verification_Disabled = function() {
	if($('#AreaName').val() === '') {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}

var TableDetail = function(table_details) {
	$('#AreaName').val(table_details.eq(0).text());
	$('#AssistantCode').val(table_details.eq(2).text());
	$('#Remark').val(table_details.eq(3).text());
}



//@ sourceURL=product.js  