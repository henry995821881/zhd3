pageHtml();//初始化分页元素
mainContentLeft();

var page_size = 23;
var current_page=1;


query_();



function page_init(max_page_){
		
//分页
	$('.pagination').jqPagination({
		link_string : '/?page={page_number}',
		//current_page: current_page, //设置当前页 默认为1
		max_page : max_page_, //设置最大页 默认为1
		page_string : '当前第{current_page}页,共{max_page}页',
		paged : function(current_page_) {
			//回发事件。。。
			current_page = current_page_;
			query_();
		}
	});
	
}




$.post("orgManage/queryCombo",
		  {orgIsleaf:1},
		  function(d,status){
		var content= eval("("+d+")");
		
		var orgList = content.data;
		var appendOrg = "";
				
		for ( var i = 0; i < orgList.length; i++) {
			appendOrg += "<option value='"+orgList[i].orgCode+"'>"+orgList[i].orgName+"</option></br>";
		}
		$("#Organization").html("<option value=''></option></br>"+appendOrg);
		$("#OrgInquire").html("<option value=''></option></br>"+appendOrg);
				
		});

$.post("deptManage/queryCombo",
		  {deptIsleaf:1},
		  function(d,status){
		var content= eval("("+d+")");
		
		var deptList = content.data;
		var appendDept = "";
				
		for ( var i = 0; i < deptList.length; i++) {
			appendDept += "<option value='"+deptList[i].deptCode+"'>"+deptList[i].deptName+"</option></br>";
		}
		$("#Department").html("<option value=''></option></br>"+appendDept);
		$("#DepartmentInquire").html("<option value=''></option></br>"+appendDept);
				
		});
	
	

/**
 * 模糊查询
 */
function query_(){
	
	var $form = $('#form_query');

	var data = $form.serialize();
	data = data+"&current_page=" +current_page;
	data = data+"&page_size=" +page_size;
	
	$.post("employeeManage/queryForPage",
			  data,
			  function(d,status){
			var content= eval("("+d+")");
			
					var EmployeeManagehtml = template('EmployeeManage', content);
				
					
					$("#content_employee").html(EmployeeManagehtml);
				
					
					
					aTable();
					
					page_init(content.max_page);
					
				 
			  });
	
	
}

var Verification_Disabled = function() {
	if($('#Name').val() === '' || $('#Department').val() === null || $('#Organization') === null) {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}

$('#Name').on('blur', function() {
	Verification_Disabled();
});
$('#Department').on('blur', function() {
	Verification_Disabled();
});
$('#Organization').on('blur', function() {
	Verification_Disabled();
});

var TableDetail = function(table_details) {
	$('#Name').val(table_details.eq(0).text());
	$('#employeeCode_1').val(table_details.eq(1).text());
	$('#Organization').val(table_details.eq(2).text());
	$('#Department').val(table_details.eq(3).text());
	$('#Assistant').val(table_details.eq(4).text());
	$('#EmployeeCategory').val(table_details.eq(5).text());
	$('#Office').val(table_details.eq(6).text());
	$('#Profession').val(table_details.eq(7).text());
	$('#JobTitle').val(table_details.eq(8).text());
	if($('#SexGirl').val() === table_details.eq(9).text()) {
		$('#SexGirl').attr("checked", "checked");
	} else {
		$('#SexMan').attr("checked", "checked");
	}
	$('#Education').val(table_details.eq(10).text());
	$('#PoliticalStatus').val(table_details.eq(11).text());
	$('#Nation').val(table_details.eq(12).text());
	$('#NativePlace').val(table_details.eq(13).text());
	$('#Birthday').val(table_details.eq(16).text());
	if($('#Unmarried').val() === table_details.eq(14).text()) {
		$('#Unmarried').attr("checked", "checked");
	} else {
		$('#Married').attr("checked", "checked");
	}
	$('#EntryTime').val(table_details.eq(17).text());
	$('#Email').val(table_details.eq(22).text());
	$('#Phone').val(table_details.eq(20).text());
	$('#Tel').val(table_details.eq(21).text());
	$('#IdNum').val(table_details.eq(18).text());
	$('#NameJobs').val(table_details.eq(19).text());
	if($('#StatusDisabled').val() === table_details.eq(15).text()) {
		$('#StatusDisabled').attr("checked", "checked");
	} else {
		$('#StatusOpen').attr("checked", "checked");
	}
	$('#Address').val(table_details.eq(23).text());
	$('#Remark').val(table_details.eq(24).text());
}

/*var table_detail_empty = function() {
	$('#employeeName').val('');
	$('#Organization').val('');
	$('#Department').val('');
	$('#Assistant').val('');
	$('#EmployeeCategory').val('');
	$('#Office').val('');
	$('#Profession').val('');
	$('#JobTitle').val('');
	$('#Education').val('');
	$('#PoliticalStatus').val('');
	$('#Nation').val('');
	$('#NativePlace').val('');
	$('#Birthday').val('');
	$('#EntryTime').val('');
	$('#Email').val('');
	$('#Phone').val('');
	$('#Tel').val('');
	$('#IdNum').val('');
	$('#NameJobs').val('');
	$('#Address').val('');
	$('#Remark').val('');
}*/



//判断是增加还是修改
var flag = "";
$("li.oper_").on('click', function() {
	
	flag = $(this).attr("data");
	
	if(flag=='add'){
		AddTable();
	}
	if(flag=='update'){
		//验证
		if($(".table_detail.active").length<1){
			alert("请选择对应的记录修改！")
			return;
		}
		
		ModifyTable();
	}
	if(flag=='del'){
		//验证
		if($(".table_detail.active").length<1){
			alert("请选择对应的记录删除！")
			return;
		}
		//删除
		PromptBox('是否删除','','1',function(result){
			if(result=='ok'){
				var employee_code= $('.table_detail.active').find('td').eq(0).attr("employee_code");
				var data={'employee_code':employee_code};
				var url = "employeeManage/delete";
				$.post(url, data, function(d) {
					PromptBox('删除成功','','2',function(result){});
					query_();
				});
			}
		})
		
		/*PromptConfirm();
		$(".Prompt_confirm").off('click');
		$(".Prompt_confirm").on('click', function() {
			PromptConfirmHide();
			var employee_code= $('.table_detail.active').find('td').eq(0).attr("employee_code");
			
			var data={'employee_code':employee_code};
			var url = "employeeManage/delete";
			$.post(url, data, function(d) {
				
				PromptSuccess();
				$(".Prompt_success_confirm").off('click');
				$(".Prompt_success_confirm").on('click', function() {
					PromptSuccessHide();
				});
				query_();

			});
			
		})*/
		
		
	}
});


function oper_employee(){

	 if(flag =="add"){
		 save_employee();
	 }else if(flag =="update"){
		 update_employee();
	 }
	
	
}


function update_employee(){
	
	//表单验证
	var $form = $('#add_employee');

	var data = $form.serialize();
	var url ="employeeManage/update";
	
	$.post(url,data,function(d) {

		var content= eval("("+d+")");
		//验证返回数据
	/*	if(!validated_return_data(content)){
			
			alert(content.msg);
			return;
		}*/
		
		query_();
		close_window();

	});
	
}





function save_employee(){
	
	//表单验证
	var $form = $('#add_employee');

	
	var data = $form.serialize();
	var url ="employeeManage/add";
	$.post(url, data, function(d) {
		var content= eval("("+d+")");
		//验证返回数据
		if(!validated_return_data(content)){
			
			alert(content.msg);
			return;
		}
	
		query_();
		close_window();
	});
	
}

//@ sourceURL=product.js  

