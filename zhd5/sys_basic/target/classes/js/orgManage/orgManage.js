pageHtml();//初始化分页元素
mainContentLeft();

var page_size = 23;
var current_page=1;

var type = "";
var orgId = "";
var orgCode = ""; 

var parentType = "";
var parentOrgId = "";
var parentOrgCode = "";
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
				getdata(type,orgId,orgCode);
			}
		});
		
	}
var add_table_submit = $('.add_table_submit');
add_table_submit.attr("disabled", "disabled");
//保存按钮校验
var Verification_Disabled = function() {
	if($('#Institution').val() === '' || $('#Abbreviation').val() === '' || $('#Organization').val() === '') {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}

$('#Institution').on('blur', function() {
	Verification_Disabled();
});
$('#Organization').on('blur', function() {
	Verification_Disabled();
});
$('#Abbreviation').on('blur', function() {
	Verification_Disabled();
});


var TableDetail = function(table_details) {
	$('#Institution').val(table_details.eq(0).text());
	
	$('#OrgCode').val(table_details.eq(1).text());
	$('#Abbreviation').val(table_details.eq(2).text());
	$('#Organization').val(table_details.eq(3).text());
	$('#Legal').val(table_details.eq(4).text());
	$('#Tel').val(table_details.eq(5).text());
	$('#Fax').val(table_details.eq(6).text());
	$('#Account').val(table_details.eq(7).text());
	$('#Bank').val(table_details.eq(8).text());
	$('#TaxNum').val(table_details.eq(9).text());
	$('#Add').val(table_details.eq(10).text());
	$('#Remark').val(table_details.eq(11).text());
	
	
}


function init_data(){
	$.post("orgManage/queryAllOrg",
		  {
		    memeber_code:'0000'
		  },
		 
		  function(d,status){
			  var content= eval("("+d+")");
			  var orgTree = template('orgTree', content);
			 $("#orgTreeLeft").html(orgTree);
			 
			 var parentList = content.parentList;
			 var appendParentOrg = "";
			 for ( var i = 0; i < parentList.length; i++) {
				 appendParentOrg += "<option value='"+parentList[i].orgCode+"'>"+parentList[i].orgName+"</option></br>";
			 }
			 $("#Organization").html(appendParentOrg);
			 getdata(type,orgId,orgCode);
			 
			 aGroup();
			//组织列表点击事件
			$(".nav_list_toggle").on('click', function(item) {
				type = $(this).attr("value");
				orgId = $(this).attr("orgId");
				orgCode = $(this).attr("orgCode");
				
				if(orgId != null){
					$("#orgId").val(orgId);
				}
				getdata(type,orgId,orgCode);
				parentType = type;
				parentOrgId = orgId;
				parentOrgCode = orgCode;
			});
			
			  
	  });
}
	
init_data();

function getdata(type,orgId,orgCode){
	$.ajaxSetup({
		  async: false
		 });
		
		$.post("orgManage/queryBasicOrg",  
			{
			type:type,
			orgId:orgId,
			orgCode:orgCode,
			current_page:current_page,
			page_size:page_size
			}, 
			function(d) {
				
				var content= eval("("+d+")");
				var content_org = template('OrgManage', content);
				$("#content_org").html(content_org);
				
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
			del_table_org();
		}
	});
	
	$('.add_table_submit').on('click',function(){
		if(opt_table_status == 'add_table'){
			add_table_org();
		}else if(opt_table_status == 'update_table'){
			$("#OrgParent").val("");	
			$("#OrgNodecode").val("");	
			update_table_org();
		}
		
	});
}

//新增------表格
function add_table_org(){
	var $form = $('#add_org_table');
	
	var data = $form.serialize();
	
	var url ="orgManage/add";
	$.post(url, data, function(d) {
		
		close_window();
		init_data();
	});
	getdata(parentType,parentOrgId,parentOrgCode);
}

//修改------表格
function update_table_org(){
	var $form = $('#add_org_table');
	
	var data = $form.serialize();
	var url ="orgManage/update";
	$.post(url, data, function(d) {
		close_window();
		init_data();
		var OrgName = $("#OrgName").val();
		var orgMnemcode = $("#AssistantCode").val();
		var Remark = $("#Remark").val();
		var orgId = $("#tab_orgId").val();
		
	});
	getdata(parentType,parentOrgId,parentOrgCode);
}


//删除------表格
function del_table_org(){
	PromptBox('是否删除','','1',function(result){
		if(result=='ok'){
			var orgCode = $('.table_detail.active').find("td").attr("orgCode");
			var data = {orgCode:orgCode}
			var url ="orgManage/delete";
			$.post(url, data, function(d) {
				PromptBox('删除成功','','2',function(result){});
				getdata(parentType,parentOrgId,parentOrgCode);
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
		var orgCode = $('.table_detail.active').find("td").attr("orgCode");
		var data = {orgCode:orgCode}
		var url ="orgManage/delete";
		$.post(url, data, function(d) {
			PromptSuccess();
			$(".Prompt_success_confirm").off('click');
			$(".Prompt_success_confirm").on('click', function() {
				PromptSuccessHide();
			});
			getdata(parentType,parentOrgId,parentOrgCode);
		});
		
	})*/
	
}





//@ sourceURL=product.js  

