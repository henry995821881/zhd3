pageHtml();//初始化分页元素
mainContentLeft();


var page_size = 23;
var current_page=1;

var type = "";
var deptId = "";
var deptCode = "";

var parentType = "";
var parentDeptId = "";
var parentDeptCode = "";

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
				getdata(type,deptId,deptCode);
			}
		});
		
	}
var add_table_submit = $(".add_table_submit");
add_table_submit.attr("disabled", "disabled");
//保存按钮校验
var Verification_Disabled = function() {
	if($('#Department').val() === '' || $('#Organization') === null) {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}

$('#Department').on('blur', function() {
	Verification_Disabled();
});
$('#Organization').on('blur', function() {
	Verification_Disabled();
});


var TableDetail = function(table_details) {
	$('#Department').val(table_details.eq(0).text());
	//$("input[name='deptCode']").val(table_details.eq(0).attr("dept_code"));
	$('#DeptCode').val(table_details.eq(1).text());
	$('#Organization').val(table_details.eq(2).text());
	$('#Principal').val(table_details.eq(3).text());
}

function init_data(){
	$.post("deptManage/queryAllDept",
		  {
		    memeber_code:'0000'
		  },
		 
		  function(d,status){
			  var content= eval("("+d+")");
			  var deptTree = template('deptTree', content);
			 $("#deptTreeLeft").html(deptTree);
			 
			 var parentList = content.parentList;
			 var appendParentDept = "";
			 for ( var i = 0; i < parentList.length; i++) {
				 appendParentDept += "<option value='"+parentList[i].deptCode+"'>"+parentList[i].deptName+"</option></br>";
			 }
			 $("#Organization").html(appendParentDept);
			 getdata(type,deptId,deptCode);
			 aGroup();
			//组织列表点击事件
			$(".nav_list_toggle").on('click', function(item) {
				type = $(this).attr("value");
				deptId = $(this).attr("deptId");
				deptCode = $(this).attr("deptCode");
				if(deptId != null){
					$("#deptId").val(deptId);
				}
				getdata(type,deptId,deptCode);
				parentType = type;
				parentDeptId = deptId;
				parentDeptCode = deptCode;
			});
			
			  
	  });
}
	
init_data();

function getdata(type,deptId,deptCode){
	$.ajaxSetup({
		  async: false
		 });
		
		$.post("deptManage/queryBasicDept",  
			{
			type:type,
			deptId:deptId,
			deptCode:deptCode,
			current_page:current_page,
			page_size:page_size
			}, 
			function(d) {
				
				var content= eval("("+d+")");
				var content_dept = template('DeptManage', content);
				$("#content_dept").html(content_dept);
				
				$(".opt_").off('click');
				$('.add_table_submit').off('click');
				aTable();
				
				page_init(content.max_page);
				
				optTable();
			});
}


//操作-------表格
var opt_table_status = "";
var optTable=function(){
	
	$(".opt_").on('click',function(){
		opt_table_status = $(this).attr("data_opt");
		
		if(opt_table_status=='add_table'){
			AddTable();
		}
		if(opt_table_status=='update_table'){
			//验证
			if($(".table_detail.active").length<1){
				alert("请选择对应的记录修改！")
				return;
			}
			ModifyTable();
		}
		
		if(opt_table_status == 'del_table'){
			//验证
			if($(".table_detail.active").length<1){
				alert("请选择对应的记录删除！")
				return;
			}
			del_table_dept();
		}
	});

	$('.add_table_submit').on('click',function(){
		
		if(opt_table_status == 'add_table'){
			add_table_dept();
		}else if(opt_table_status == 'update_table'){
			$("#DeptParent").val("");	
			$("#DeptNodecode").val("");	
			update_table_dept();
		}
	});
}

//新增------表格
function add_table_dept(){
	var $form = $('#add_dept_table');
	
	var data = $form.serialize();
	var url ="deptManage/add";
	$.post(url, data, function(d) {
		
		close_window();
		init_data();
	});
	getdata(parentType,parentDeptId,parentDeptCode);
}

//修改------表格
function update_table_dept(){
	var $form = $('#add_dept_table');
	
	var data = $form.serialize();
	var url ="deptManage/update";
	
	$.post(url, data, function(d) {
		close_window();
		init_data();
		var DeptName = $("#DeptName").val();
		var Remark = $("#Remark").val();
		var deptId = $("#tab_deptId").val();
		
	});
	getdata(parentType,parentDeptId,parentDeptCode);
}


//删除------表格
function del_table_dept(){
	PromptBox('是否删除','','1',function(result){
		if(result=='ok'){
			var deptCode = $('.table_detail.active').find("td").attr("deptCode");
			var data = {deptCode:deptCode}
			var url ="deptManage/delete";
			$.post(url, data, function(d) {
				PromptBox('删除成功','','2',function(result){});
				getdata(parentType,parentDeptId,parentDeptCode);
			});
		}
	})
	/*PromptConfirm();
	$(".Prompt_cancel").off('click');
	$(".Prompt_cancel").on('click', function() {
		PromptConfirmHide();
		return;
	});
	$(".Prompt_confirm").off('click');
	$(".Prompt_confirm").on('click', function() {
		PromptConfirmHide();
		var deptCode = $('.table_detail.active').find("td").attr("deptCode");
		var data = {deptCode:deptCode}
		var url ="deptManage/delete";
		$.post(url, data, function(d) {
			PromptSuccess();
			$(".Prompt_success_confirm").off('click');
			$(".Prompt_success_confirm").on('click', function() {
				PromptSuccessHide();
			});
			getdata(parentType,parentDeptId,parentDeptCode);
		});
	})*/
	
}


//@ sourceURL=product.js 