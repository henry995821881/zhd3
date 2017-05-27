
var current_node="";
	


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
			query_(current_node,c_page);
		}
	});
	
}

/********************************************************/


function init_tree(){
	
	$.post("pntree/query",
			  {
			    memeber_code:'0000',
			   
			  },
			 
			  function(d,status){
				  var content= eval("("+d+")");
					
					var html = template('partnameclass_tpl', content);
					
					$("#class_ul").html(html);
					
					$("li.event_tree").on('click', function(){
						
						var pntreeNodecode = $(this).attr("pntreeNodecode");
						current_node =pntreeNodecode;
						query_(pntreeNodecode,1);
						
					});
					
					aGroup();
				
						
					});
	
}


init_tree();
					
				
			 

function query_(pntreeNodecode,current_page_){

	
	$.post("partsname/query/page",
			  {
			    memeber_code:'0000',
			    pntreeNodecode:pntreeNodecode,
			    page_size:page_size,
			    current_page:current_page_
			  },
			 
			  function(d,status){
				  var content= eval("("+d+")");
					//验证返回数据
				
			
					var html = template('partname_tpl', content);
					
					$("#content_partsname").html(html);
					aTable();
					page_init(current_page_,content.max_page);
					
			  });
	
}





//添加 修改 删除树
var tree_oper='';
$("li.pntree_oper").on('click', function(){
	
	
	tree_oper = $(this).attr("data");
	
	
	//选中的节点树的父节点
	var node = $(".menu_content_group_node.active");
	if(node.length <1 ){
		alert("请选择树节点！");
		return;
	}
	
	if(tree_oper =="add"){
		
		add_group_show();
	}
	if(tree_oper =="update"){
		
		ModifyGroup();
		
	}
	
	if(tree_oper =='del'){
		
		PromptBox("是否删除品名大类",'','1',function(r){
			if(r=='ok'){
				
				var pntreeCode  =node.attr("pntreeCode");
				var $form = $('#pntree_form');
				var data = $form.serialize();
			    data = data + "&pntreeCode=" +pntreeCode;
			    
			    $.post("pntree/delete",
						  data,
						 
						  function(d,status){
			    	var content= eval("("+d+")");
					//验证返回数据
					if(!validated_return_data(content)){
						
						alert(content.msg);
						return;
					}
			    	            init_tree();
			    	            PromptBox("删除品名大类成功",'','2',function(r){}); 
						  });
			}
		});
	
		
		
	}
	
	
});

////添加 修改 删除树 表单
function pntree_oper(){
	
	

	
	//选择节点
	var node = $(".menu_content_group_node.active");
	
	var pntreeParentcode = node.attr("pntreeParentcode");
	var pntreeCode  =node.attr("pntreeCode");
	
	if(tree_oper =='add'){
		
		var $form = $('#pntree_form');
		var data = $form.serialize();
		var param = '';
		if(pntreeParentcode =='-1'){
			param =pntreeCode;
		}else{
			param =pntreeParentcode;
		}
	    data = data + "&pntreeParentcode=" +param;
	    
	    $.post("pntree/save",
				  data,
				 
				  function(d,status){
	    	var content= eval("("+d+")");
			//验证返回数据
			if(!validated_return_data(content)){
				
				alert(content.msg);
				return;
			}
	    	            init_tree();
	    	            close_tree_window();
				  });
		
		
	}else if(tree_oper =='update'){
		
		var $form = $('#pntree_form');
		var data = $form.serialize();
	    data = data + "&pntreeCode=" +pntreeCode;
	    
	    $.post("pntree/update",
				  data,
				 
				  function(d,status){
	    	var content= eval("("+d+")");
			//验证返回数据
			if(!validated_return_data(content)){
				
				alert(content.msg);
				return;
			}
	    	            init_tree();
	    	            close_tree_window();
				  });
	}
}




			
			


var Verification_Disabled = function() {
	if($('#Name').val() === ''||$('#IndustryCategory').val() === null||$('#TaxRate').val() === '') {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}
var TableDetail = function(table_details) {
	$('#Name').val(table_details.eq(0).attr("data"));
	$('input[name="partsnameCode"]').val(table_details.eq(1).attr("data"));
	$('#Assistant').val(table_details.eq(2).attr("data"));
	$('#TaxRate').val(table_details.eq(3).attr("data"));	
	$('#NameCategory').val(table_details.eq(4).attr("data"));
	$('#PieceMode').val(table_details.eq(5).attr("data"));
	$('#WeightMode').val(table_details.eq(6).attr("data"));
	$('#MeasurementMethod').val(table_details.eq(7).attr("data"));
	$('#PricingMethod').val(table_details.eq(8).attr("data"));
	$('#Formula').val(table_details.eq(9).attr("data"));
	$('#Remark').val(table_details.eq(10).attr("data"));
	//code
	
	
	
}

$('#Name').on('blur', function() {
	var a = $(this);
	Verification(a);
	Verification_Disabled();
});
$('#IndustryCategory').on('blur', function() {
	var a = $(this);
	Verification(a);
	Verification_Disabled();
});
$('#TaxRate').on('blur', function() {
	var a = $(this);
	Verification(a);
	Verification_Disabled();
});


//品名增加删除修改
var partsname_oper ='';
$("li.partsname_oper").on('click',function(){
	
	partsname_oper = $(this).attr("data");
	//弹出
	if(partsname_oper=='add'){
		//验证
		if($(".menu_content_group_node.active").length<1){
			
			alert("请选择大类");
			return;
		}
		 //跳出窗口
		 AddTable();
	}
	
	if(partsname_oper=='update'){
		
		 //验证
		if($(".table_detail.active").length<1){
			alert("请选择品名");
			return;
		}
		 //跳出窗口
		 ModifyTable();
	}	
	
	/*//品名大类 选择 过滤
	var node = $(".menu_content_group_node.active");
	if(node.length <1 ){
		alert("请选择树节点！");

		return;
	}*/

	$("#NameCategory").html( $(".menu_content_group_node.active").attr("pntreeName"));
	
	if(partsname_oper =='update'){
		//更新时请选择
		var node_active = $(".table_detail.active");
		if(node_active.length<1){
			alert("请选择！");
			return;
		}
		
	}
	
	
	//加载行业分类
	init_industry();
	
	
	if(partsname_oper =='del'){
		//删除品名
		//验证
		if($(".table_detail.active").length<1){
			alert("请选择品名");
			return;
		}	
	
		PromptBox("是否删除品名",'','1',function(r){
			if(r=='ok'){
				
				var partsnameCode =$(".table_detail.active").attr("partsnameCode");
				
				$.post("partsname/delete",
						  {partsnameCode:partsnameCode},
						  function(d,status){
							  
							  var content= eval("("+d+")");
								//验证返回数据
								if(!validated_return_data(content)){
									
									alert(content.msg);
									return;
								}
							  
			  	        close_window();
			  	        query_(current_node,current_page_g);
			  	      PromptBox("删除品名成功",'','2',function(r){});
						  });
			}
			
			
		});
		
	
		
	}
	
	
});


//保存 修改 品名
function save_update(){
	
	var msg = validated_form();
	
	if(msg != 'ok'){
		alert(msg);
		return;
	}

	
	//form form_partsname 
	
	var pntreeNodecode =  $(".menu_content_group_node.active").attr("pntreeNodecode");
	var pntreeName =  $(".menu_content_group_node.active").attr("pntreeName");
	
	var $form = $('#form_partsname');
	var data = $form.serialize();
	
	if(partsname_oper == 'add'){
		
		
	  data =data +"&pntreeParentname="+pntreeName;
	  data =data +"&pntreeNodecode="+pntreeNodecode;
	  data =data +"&pntreeName="+pntreeName;
	   
	    $.post("partsname/add",
				  data,
				  function(d,status){
	    	
	    	var content= eval("("+d+")");
			//验证返回数据
			if(!validated_return_data(content)){
				
				alert(content.msg);
				return;
			}
	    	
	    	        close_window();
	    	        query_(current_node,current_page_g);
	    	
				  });
		
		
	}else if(partsname_oper == 'update'){
		
		
	var partsnameCode =	$('input[name="partsnameCode"]').val();
	
	// data =data +"&partsnameCode="+partsnameCode;	
	$.post("partsname/update",
			  data,
			  function(d,status){
		var content= eval("("+d+")");
		//验证返回数据
		if(!validated_return_data(content)){
			
			alert(content.msg);
			return;
		}
  	        close_window();
  	      query_(current_node,current_page_g);
  	
			  });	
		
		
	}
	
}



function init_industry(){
	
	
	$.post("industry/query",
			  {},
			  function(d,status){
				  var content= eval("("+d+")");
					//验证返回数据
					
				  var html='';
					var data = content.data;
					  for(var i =0;i<data.length;i++){
						  
						html +='<option   value="'+data[i].industryCode+'">'+data[i].industryName+'</option>';  
					  }
					  $("#IndustryCategory").html(html);
					  
					  if(partsname_oper =='update'){
							
							//赋值之前的
							
							var industryCode = $(".table_detail.active").attr("industryCode");
							
							$("#IndustryCategory").val(industryCode);
						}
	
			  });	
		
		
	
	
}



/***
 * 表单验证
 * @returns {String}
 */
function validated_form(){
	var msg ='ok';
	
	if($("#Name").val()==''){
		
		msg="品名不能空";
	}
	
	
	
	return msg;
	
}


//@ sourceURL=product.js  