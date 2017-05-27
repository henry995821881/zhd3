


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

//查询按钮
function query_form_button(){
	query_(1);
}
//重置

	
	
	

			
function query_(current_page_){
	
	
	var $form = $('#form_query');

	var data = $form.serialize();
	data = data+"&current_page=" +current_page_;
	data = data+"&page_size=" +page_size;
	
	$.post("productArea/query/page",
			 data,
			 
			  function(d,status){
		var content= eval("("+d+")");
		
					var html = template('product_area_tpl', content);
					
					$("#content_product_area").html(html);
					
					
					
					aTable();
					page_init(current_page_,content.max_page);
					
				
			  });
	
	
}			
			
	



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
		if($(".table_detail.active").length <1){
			
			alert("请选择产地");
			return;
		}
		 //跳出窗口
		 ModifyTable();
	}
	
	
	if(flag=='del'){
		
		//删除
		 //验证
		if($(".table_detail.active").length <1){
			
			alert("请选择产地");
			return;
		}
	   
		PromptBox("是否删除产地",'','1',function(r){
			if(r=='ok'){
				
				var productareaCode= $('.table_detail.active').find('td').eq(0).attr("data");
				
				var data={'productareaCode':productareaCode};
				 var url ="productArea/delete";
				$.post(url, data, function(d) {
					var content= eval("("+d+")");
					//验证返回数据
					if(!validated_return_data(content)){
						
						alert(content.msg);
						return;
					}
				
					close_window();
					query_(current_page_g);
					PromptBox("删除产地成功",'','2',function(r){});
				});
			}
			
			
		}); 
	
		
	}
});





function product_area_oper(){
	
	var msg = validated_form();
	if(msg !='ok'){
		
		alert(msg);
		return;
	}
	
    if(flag =="add"){
		 
		 save_product_area();
	 }else if(flag =="update"){
		 update_product_area();
	 }
	
	
	
}


function save_product_area(){
	
	

	
	
	var $form = $('#form_product_area');
	var data = $form.serialize();
	
	var url ="productArea/add";
	$.post(url, data, function(d) {
		var content= eval("("+d+")");
		//验证返回数据
		if(!validated_return_data(content)){
			
			alert(content.msg);
			return;
		}
	
		
		close_window();
		query_(current_page_g);
			
		

	});
	
	
}
function update_product_area(){
	
	var $form = $('#form_product_area');
	var data = $form.serialize();
	
	var url ="productArea/update";
	$.post(url, data, function(d) {
		var content= eval("("+d+")");
		//验证返回数据
		if(!validated_return_data(content)){
			
			alert(content.msg);
			return;
		}
	
		
		close_window();
		query_(current_page_g);
			
		

	});
}




var Verification_Disabled = function() {
	if($('#Origin').val() === '') {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}
var TableDetail = function(table_details) {

	$('#productareaCode_1').val(table_details.eq(0).attr("data"));
	$('#Origin').val(table_details.eq(1).attr("data"));
	$('#Assistant').val(table_details.eq(2).attr("data"));
	$('#Remark').val(table_details.eq(3).attr("data"));
}

$('#Origin').on('blur', function() {
	var a = $(this);
	Verification(a);
	Verification_Disabled();
});


/***
 * 表单验证
 * @returns {String}
 */
function validated_form(){
	var msg ='ok';
	
	if($("#ReservoirArea").val()==''){
		
		msg="产地名不能空";
	}
	
	
	
	return msg;
	
}


//@ sourceURL=product.js  

