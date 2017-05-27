
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
			$("#current_page").val(c_page);
			$("#page_size").val(page_size);
			
			
			//回发事件。。。
			current_page_g = c_page;
			query_(current_page_g);
		}
	});
	
}

/********************************************************/


function init_data(){
	var $form = $("#query_company");
	
	$("#current_page").val(current_page_g);
	$("#page_size").val(page_size);
	
	var data = $form.serialize();
	var url = "company/queryCompany";
	
	$.post(url,data,
	  function(d,status){
		  	var content= eval("("+d+")");
			var SetCompany = template('SetCompany', content);
			$("#content_SetCompany").html(SetCompany);
			aTable();
			page_init(current_page_g,content.max_page);
	  });
	
	areaLoad();
}
init_data();


/*$(".areaPart").on("click",function(){
		
	$.post("area/queryAllArea",
	  {
	    memeber_code:'0000'
	  },
	  function(d,status){
		  	var content= eval("("+d+")");
			var areaTree = template('areaTree', content);
			$("#areaTreeLeft").html(areaTree);
			aGroup();
			
	  });
})*/

//加载上级单位
function companyLoad(){
	var url = "company/queryUpCompany";
	
	$.post(url, {}, function(d,status){
		var content= eval("("+d+")");	
		var select = $("#companyParent");  
		$.each(content.data,function(index,item){
			var option = $("<option value="+item.companyCode+"></option>").text(item.companyName);  
			select.append(option);  
		})
			
	  });
}

//加载分管部门
function deptLoad(){
	var url = "company/queryDept";
	
	$.post(url, {}, function(d,status){
		var content= eval("("+d+")");	
		var select = $("#deptCode");  
		$.each(content.data,function(index,item){
			var option = $("<option value="+item.deptCode+"></option>").text(item.deptName);  
			select.append(option);  
		})
			
	  });
}

//加载单位类型
function companyClassLoad(){
	var url = "company/queryByClass";
	var datas = {ddtypeClass:"companyClass"};
	$.post(url, datas, function(d,status){
		var content= eval("("+d+")");	
		var select = $("#companyClass");  
		$.each(content.data,function(index,item){
			var option = $("<option value="+item.ddId+"></option>").text(item.ddName);  
			select.append(option);  
		})
			
	  });
}


//客户来源
function companySourceLoad(){
	var url = "company/queryByClass";
	var datas = {ddtypeClass:"companySource"};
	$.post(url, datas, function(d,status){
		var content= eval("("+d+")");	
		var select = $("#companySource");  
		$.each(content.data,function(index,item){
			var option = $("<option value="+item.ddId+"></option>").text(item.ddName);  
			select.append(option);  
		})
			
	  });
}

//所属行业
function companyIndustryLoad(){
	var url = "company/queryByClass";
	var datas = {ddtypeClass:"companyIndustry"};
	$.post(url, datas, function(d,status){
		var content= eval("("+d+")");	
		var select = $("#companyIndustry");  
		$.each(content.data,function(index,item){
			var option = $("<option value="+item.ddId+"></option>").text(item.ddName);  
			select.append(option);  
		})
			
	  });
}

//查询
function query(){
	var $form = $("#query_company");
	
	$("#current_page").val(current_page_g);
	$("#page_size").val(page_size);
	
	var data = $form.serialize();
	var url = "company/queryCompany";
	$.post(url, data, function(d,status){
		var content= eval("("+d+")");
		var SetCompany = template('SetCompany', content);
		$("#content_SetCompany").html(SetCompany);
		
		//删除时用到的companyId
		$(".table_detail").on('click', function(item) {
			var companyId = $(this).attr("companyId");
			$("#companyId").val(companyId);
		});
		aTable();
		current_page_g = 1;
		page_init(current_page_g,content.max_page);
	})
};

//分页
function query_(current_page_g){
	var $form = $("#query_company");
	var data = $form.serialize();
	var url = "company/queryCompany";
	$.post(url, data, function(d,status){
		var content= eval("("+d+")");
		var SetCompany = template('SetCompany', content);
		$("#content_SetCompany").html(SetCompany);
		
		//删除时用到的companyId
		$(".table_detail").on('click', function(item) {
			var companyId = $(this).attr("companyId");
			$("#companyId").val(companyId);
		});
		aTable();
		page_init(current_page_g,content.max_page);
	})
}



//操作-------表格
var opt_status = "";
$(".opt_").on('click',function(){
	
	
	//先删除所有select上一次加载的option
	//$("#companyParent").find("option").remove(); 
	$("#deptCode").find("option").remove(); 
	$("#companyClass").find("option").remove(); 
	$("#companySource").find("option").remove(); 
	$("#companyIndustry").find("option").remove(); 
	$("#search").find("option").remove(); 
	opt_status = $(this).attr("opt");
	if(opt_status == 'add' || opt_status == 'update'){
		if(opt_status == 'add'){
			document.getElementById("add_company").reset();	//jquery中没有reset方法  
			$('#table_linkman #table_linkman_body').empty();
			$('#table_account #table_account_body').empty();
			$('#table_project #table_project_body').empty();
			AddTable();
		}
		if(opt_status == 'update'){
			
			if(!$(".table_detail").hasClass('active')){
				PromptBox("请选择节点",'','2',function(r){});
				return;
			}
			
			var companyId = $(".table_detail.active").attr("companyid");
			$("#companyId").val(companyId); 
			
			$('#table_linkman #table_linkman_body').empty();
			$('#table_account #table_account_body').empty();
			$('#table_project #table_project_body').empty();
			var companyCode = $(".table_detail.active").attr("companyCode");
			update_load_liknman(companyCode);
			update_load_account(companyCode);
			update_load_project(companyCode);
			ModifyTable();
		}
		companyClassLoad();
		companySourceLoad();
		companyIndustryLoad();
		//areaLoad();
		//companyLoad();
		deptLoad();
		
		$("#linkman").show();
		$("#account").hide();
		$("#project").hide();
		
		var _opt = "linkman";
		btn(_opt);
		//联系人、单位账号、项目
		$("#lxr").on("click",function(){
			$("#linkman").show();
			$("#account").hide();
			$("#project").hide();
			_opt = "linkman";
			btn(_opt);
		})
		$("#dwzh").on("click",function(){
			$("#linkman").hide();
			$("#account").show();
			$("#project").hide();
			_opt = "account";
			btn(_opt);
		})
		$("#xm").on("click",function(){
			$("#linkman").hide();
			$("#account").hide();
			$("#project").show();
			_opt = "project";
			btn(_opt);
		})
		
		
	}
	if(opt_status == 'del'){
		if(!$(".table_detail").hasClass('active')){
			PromptBox("请选择节点",'','2',function(r){});
			return;
		}
		
		init_data();
		del_company();
	}
	if(opt_status == 'combine'){
		if(!$(".table_detail").hasClass('active')){
			PromptBox("请选择节点",'','2',function(r){});
			return;
		}
		
		var old_company_code =  $(".table_detail.active").attr("companyCode");
		var old_company_name =  $(".table_detail.active").attr("companyName");
		var old_company_id =  $(".table_detail.active").attr("companyId");
		
		$("#old_company_code").val(old_company_code);
		$("#old_company_name").val(old_company_name);
		$("#old_company_id").val(old_company_id);
		
		$("#combine_table").show();
		mask.show();
		$(".add_table_close.combine").on("click",function(){
			mask.hide();
			$("#combine_table").hide();
		})
	}
	
})

//保存
function save(){
	if(opt_status == 'add'){
		add_company();
	}
	if(opt_status == 'update'){
		update_company();
	}
	
}


var linkmans = [];	//联系人
var accounts = [];	//账号
var projects = [];	//项目

//新增
function add_company(){
	
	save_company_table();
	
	$("#linkman_list").val(linkmans);
	$("#account_list").val(accounts);
	$("#project_list").val(projects);
	
	var $form = $('#add_company');
	
	var data = $form.serialize();
	var url ="company/addCompany";
	$.post(url, data, function(d) {
		var content = eval("("+d+")");
		if(content.msg != 'ok'){
			PromptBox(content.msg,'','2',function(r){});
			return;
		}
		close_window();
		PromptBox('新增成功','','2',function(r){});
		init_data();
	});
}

//编辑
function update_company(){
	
	save_company_table();
	
	$("#linkman_list").val(linkmans);
	$("#account_list").val(accounts);
	$("#project_list").val(projects);

	var $form = $('#add_company');
	
	var data = $form.serialize();
	var url ="company/updateCompany";
	$.post(url, data, function(d) {
		var content = eval("("+d+")");
		if(content.msg != 'ok'){
			PromptBox(content.msg,'','2',function(r){});
			return;
		}
		close_window();
		PromptBox('修改成功','','2',function(r){});
		init_data();
	});
}

//删除
function del_company(){
	var companyId = $(".table_detail.active").attr("companyId");
	PromptBox('是否确定删除','','1',function(r){
		if(r=='ok'){
			var data = {companyId:companyId};
			var url ="company/deleteCompany";
			$.post(url, data, function(d) {
				var content = eval("("+d+")");
				if(content.msg != 'ok'){
					PromptBox('删除失败','','2',function(r){});
					return;
				}else{
					PromptBox('删除成功','','2',function(r){});
				}
				init_data();
			});
			
		}
	});
	

}
var areaNameArr = [];//地区名字
var areaCodeArr = [];//地区代号

//地区下拉框加载
function areaLoad(){
//	$("#select_areaCode").css({"display":""});  
	$.post("area/queryAllArea",
			  {
			    memeber_code:'0000'
			  },
			  function(d,status){
				  	var content= eval("("+d+")");
					var areaTree = template('areaTree', content);
					$("#areaTreeLeft").html(areaTree);
					
					//地区列表点击事件
					$(".company_tree").off('click');
					$(".company_tree").on('click', function(item) {
						var areaNodecode = $(this).attr("id");
						var type = $(this).attr("value");
						var areaId = $(this).attr("areaId");	//地区id
						var areaParent = $(this).attr("areaCode");
						
						$("#page_areaNodecode").val(areaNodecode);
						$("#page_type").val(type);
						$("#page_areaId").val(areaId);
						$("#page_areaParent").val(areaParent);
						
						uploadByArea2table(areaParent);
						current_page_g = 1;
						getdata1(areaNodecode,type,areaId,areaParent,current_page_g);
					});
				aGroup();
			  });
  
}

//获取列表数据
function getdata1(areaNodecode,type,areaId,areaParent,current_page_g){
	
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
		
				var nextTree = template('nextTree', content);
				$("ul[next="+areaId+"]").html(nextTree);
				$(".nextTree").on('click', function(item) {
				$(".nav_list_toggle").off('click');		
				aGroup();
							
				var areaParent = $(this).attr("areaCode");
				var type = $(this).attr("value");
				var areaId = $(this).attr("areaId");	//地区id
					
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

							$(".nav_list_toggle").off('click');
							$(".nav_list_toggle").on('click', function(item) {
								var areaNodecode = $(this).attr("id");
								var type = $(this).attr("value");
								var areaId = $(this).attr("areaId");	//地区id
								var areaParent = $(this).attr("areaCode");
								uploadByArea2table(areaParent);
								current_page_g = 1;
								getdata1(areaNodecode,type,areaId,areaParent,current_page_g);
							});
						
							aGroup();
						});
				})
			});
		
	}

//点击地区时加载表数据
function uploadByArea2table(areaCode){
	$("#areaCode").val(areaCode);
	$.post("company/queryCompanyByAreaCode",  
			{
				areaCode:areaCode,
				current_page:1,
				page_size:page_size
			}, 	function(d) {
				var content= eval("("+d+")");
				var SetCompany = template('SetCompany', content);
				$("#content_SetCompany").html(SetCompany);
				
				aTable();
				current_page_g = 1;
				page_init(current_page_g,content.max_page);
			});
}

/*
//选择地区后隐藏select 并副职到input
function selectArea(item){
	$(item).prev("input[name='areaCode']").val($(item).find("option:selected").text());  
//	$(item).prev("input[name='areaCode']").val($(item).find("option:selected").val());  
	$("#select_areaCode").css({"display":"none"});  
}

//地区下拉框模糊查询
function vague(item){
	var select = $("#select_areaCode");  
    select.html("");  
    for(i=0;i<areaNameArr.length;i++){  
        //若找到以txt的内容开头的，添option  
        if(areaNameArr[i].substring(0,item.value.length).indexOf(item.value)==0){ 
            var option = $("<option value="+areaCodeArr[i]+"></option>").text(areaNameArr[i]);  
            select.append(option);  
        }  
    }  

}*/

var Verification_Disabled = function() {
	if($('#AreaName').val() === '') {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}

var TableDetail = function(table_details) {
	$('#companyCode_table').val(table_details.eq(0).text());		//代码
	$('#companyName_table').val(table_details.eq(1).text());		//名称
	$('#companyAbbreviate_table').val(table_details.eq(3).text());	//简称
	$('#companyMnemcode').val(table_details.eq(18).text());			//助记码

	$('#select_areaCode').val(table_details.eq(17).text());			//地区
	$('#companyAddr').val(table_details.eq(16).text());				//联系地址
	$('#companyLinkman').val(table_details.eq(19).text());			//联系人
	$('#companyCorporation').val(table_details.eq(12).text());		//法人代表

	$('#companyBank').val(table_details.eq(14).text());				//开户行
	$('#companyInvoiceaddr').val(table_details.eq(21).text());		//开票地址
	$('#companyBankaccounts').val(table_details.eq(13).text());		//账号
	$('#companyTanu').val(table_details.eq(15).text());				//税号
	
	$('#companyPhone').val(table_details.eq(10).text());			//电话
	$('#companyFax').val(table_details.eq(11).text());				//传真
	$('#companyPostcode').val(table_details.eq(20).text());			//邮政编码
	$('#employeeCode').val(table_details.eq(22).text());			//业务员
	
	$('#deptCode').val(table_details.eq(23).text());				//分管部门
	$('#companyAssessType').val(table_details.eq(24).text());		//业务关系
	$('#companyClass').val(table_details.eq(34).text());				//单位类型
//	$('#companyAssessCredit').val(table_details.eq(5).text());		//信誉额度
	
	$('#companyAssessGrade').val(table_details.eq(29).text());		//资信等级
	$('#companyAssessState').val(table_details.eq(30).text());		//客户状态
	$('#companyProperty').val(table_details.eq(31).text());			//单位性质
	$('#companySource').val(table_details.eq(7).text());			//客户来源

	$('#companyType').val(table_details.eq(6).text());				//客户类别
//	$('#companyParent').val("0001");			//上级单位	
	$('#companyIndustry').val(table_details.eq(9).text());			//所属行业
	$('#companyRemark').val(table_details.eq(28).text());			//经营范围
	
	$('input[name="allowquery"]').eq(table_details.eq(32).text()).click();//是否允许对其他货主显示信息
//	$('input[name="companyState"]').val(table_details.eq(33).text()).click();			//状态
}


//弹出框下半部份的增加删除按钮
function btn(_opt){
	$("#btn_add").off("click");
	$("#btn_add").on("click",function(){
		add_company_table(_opt);
	});
	
	$("#btn_del").off("click");
	$("#btn_del").on("click",function(){
		del_company_table();
	});
}

//弹出框下半部份的增加表格
function add_company_table(_opt){
	if(_opt == "linkman"){
		var add_linkman = template('add_table_linkman', content);
		$("#table_linkman #table_linkman_body").append(add_linkman);
	}
	if(_opt == "account"){
		var add_account = template('add_table_account', content);
		$("#table_account #table_account_body").append(add_account);
	}
	if(_opt == "project"){
		var add_project = template('add_table_project', content);
		$("#table_project #table_project_body").append(add_project);
	}
	load_table_click();
}

//加载后表格点击事件
function  load_table_click(){
	var table_detail = $('.table_detail');
	table_detail.on('click', function() {
		table_detail.find('td').removeClass('active');
		table_detail.removeClass('active');
		$(this).find('td').addClass('active');
		$(this).addClass('active');
	});
}

//弹出框下半部份的删除表格
function del_company_table(_opt){
	//	删除 table
	var delete_table_icon = $('.delete_table_icon');
	delete_table_icon.on('click', function() {
		$('.table_detail.active').removeClass('active').remove();
	});

}

//保存弹出框下半部份的表格数据
function save_company_table(){
	//linkman
	linkman_list();
	account_list();
	project_list();
}

//弹出框下半部份的表格数据--------------linkman
function linkman_list(){
	linkmans = [];
	var trList = $('#table_linkman').find('#table_linkman_body').children("tr");
	 for (var i=0;i<trList.length;i++) {
	        var tdArr = trList.eq(i).find("td");
	        var companyLinkmanName = tdArr.eq(0).find('input').val();//姓名
	        var companyLinkmanSex = tdArr.eq(1).find('select').val();//性别
	        var companyLinkmanBirthday = tdArr.eq(2).find('input').val();//生日
	        var companyLinkmanPhone = tdArr.eq(3).find('input').val();//电话
	        var companyLinkmanMsn = tdArr.eq(4).find('input').val();//MSN
	        var companyLinkmanQq = tdArr.eq(5).find('input').val();//QQ
	        var companyLinkmanFax = tdArr.eq(6).find('input').val();//传真
	        var companyLinkmanEmail = tdArr.eq(7).find('input').val();//邮箱
	        var companyLinkmanMobile = tdArr.eq(8).find('input').val();//手机
	        var companyLinkmanAddr = tdArr.eq(9).find('input').val();//住址
	        var companyLinkmanJob = tdArr.eq(10).find('input').val();//职位
	        var companyLinkmanRemark = tdArr.eq(11).find('input').val();//备注

	        var arr_linkman = [];
	        arr_linkman.push(companyLinkmanName);
	        arr_linkman.push(companyLinkmanSex);
	        arr_linkman.push(companyLinkmanBirthday);
	        arr_linkman.push(companyLinkmanPhone);
	        arr_linkman.push(companyLinkmanMsn);
	        arr_linkman.push(companyLinkmanQq);
	        arr_linkman.push(companyLinkmanFax);
	        arr_linkman.push(companyLinkmanEmail);
	        arr_linkman.push(companyLinkmanMobile);
	        arr_linkman.push(companyLinkmanAddr);
	        arr_linkman.push(companyLinkmanJob);
	        arr_linkman.push(companyLinkmanRemark);
	        linkmans.push(arr_linkman.join(":"));
	  }
}

//弹出框下半部份的表格数据--------------account
function account_list(){
	accounts = [];
	var trList =  $('#table_account').find('#table_account_body').children("tr");
	 for (var i=0;i<trList.length;i++) {
	        var tdArr = trList.eq(i).find("td");
	        var companyAccountsCode = tdArr.eq(0).find('input').val();//账号
	        var companyAccountsName = tdArr.eq(1).find('input').val();//开户银行
	        var companyAccountsRemark = tdArr.eq(2).find('input').val();//备注
	        
	        var arr_account = [];
	        arr_account.push(companyAccountsCode);
	        arr_account.push(companyAccountsName);
	        arr_account.push(companyAccountsRemark);
	        accounts.push(arr_account.join(":"));
	  }
}

//弹出框下半部份的表格数据--------------project
function project_list(){
	projects = [];
	var trList = $('#table_project').find('#table_project_body').children("tr");
	 for (var i=0;i<trList.length;i++) {
	        var tdArr = trList.eq(i).find("td");
	        var obj = {};
	        var companyProjectDate = tdArr.eq(0).find('input').val();//日期
	        var companyProjectName = tdArr.eq(1).find('input').val();//开户银行
	        var companyProjectRemark = tdArr.eq(2).find('input').val();//备注
	        
	        var arr_project = [];
	        arr_project.push(companyProjectDate);
	        arr_project.push(companyProjectName);
	        arr_project.push(companyProjectRemark);
	        projects.push(arr_project.join(":"));
	  }
}

//修改时加载已有联系人
function update_load_liknman(companyCode){
	
	var url = "linkman/queryCompanyLinkman";
	var data = {companyCode:companyCode};
	$.post(url,data,function(d) {
		
		var content= eval("("+d+")");
		var liknman_content = template('update_table_linkman', content);
		$("#table_linkman_body").html(liknman_content);

	});
}

//修改时加载已有单位账号
function update_load_account(companyCode){
	
	var url = "account/queryCompanyAccounts";
	var data = {companyCode:companyCode};
	$.post(url,data,function(d) {
		
		var content= eval("("+d+")");
		var account_content = template('update_table_account', content);
		$("#table_account_body").html(account_content);

	});
}


//修改时加载已有项目
function update_load_project(companyCode){
	
	var url = "project/queryCompanyProject";
	var data = {companyCode:companyCode};
	$.post(url,data,function(d) {
		
		var content= eval("("+d+")");
		var account_content = template('update_table_project', content);
		$("#table_project_body").html(account_content);

	});
}


//往来单位保存
function combine_save(){
	var $form = $("#combine_company");
	
	var data = $form.serialize();
	var url = "company/combineCompany";
	$.post(url, data, function(d,status){
		
		var content = eval("("+d+")");
		if(content.msg != ok){
			PromptBox('合并失败','','2',function(r){});
			mask.hide();
			$("#combine_table").hide();
			init_data();
			return;
		}
		PromptBox('合并成功','','2',function(r){});
		mask.hide();
		$("#combine_table").hide();
		init_data();
	})
}

//@ sourceURL=product.js  