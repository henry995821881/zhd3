
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
			//回发事件。。。
			current_page_g = c_page;
			query_(current_node,c_page);
		}
	});
	
}

/********************************************************/

//初始化树
function init_tree(){
	
	$.post("pntree/query",
			  {
			    memeber_code:'0000',
			   
			  },
			 
			  function(d,status){
				
				  var content=eval("("+d+")");	
				
					var html = template('partnameclass_tpl_1', content);
					
					$("#class_ul_1").html(html);
					
					$("li.event_tree").on('click', function(){
						
						var pntreeNodecode = $(this).attr("pntreeNodecode");
						current_node =pntreeNodecode;
						query_(pntreeNodecode,1);
						
						
						
					});
					
					aGroup();
				
						
					});
	
}


init_tree();
//查询品名
function init_partsname(pntreeNodecode){

	
	$.post("partsname/query",
			  {
			    memeber_code:'0000',
			    pntreeNodecode:pntreeNodecode
			  
			  },
			 
			  function(d,status){
				var content=eval("("+d+")");
			
				// goodsPiecemode goodsWeightmode goodsMetering goodsPriceun goodsTaxrate
				
				var html='';
				var data = content.data;
				  for(var i =0;i<data.length;i++){
					  
					html +='<option goodsPiecemode="'+data[i].goodsPiecemode+'" goodsWeightmode="'+data[i].goodsWeightmode+'" goodsMetering="'+data[i].goodsMetering+'" goodsPriceun="'+data[i].goodsPriceun+'" goodsTaxrate="'+data[i].goodsTaxrate+'" class="option_parts_name"  value="'+data[i].partsnameName+'">'+data[i].partsnameName+'</option>';  
					
				  }
				  $("#Name").html(html);
				  $("#staPartsnameName_id").html(html);
				  
				  //如果是修改 选择之前的品名
					if(goods_code_oper =='update'){
						var name =  $('.table_detail.active').find('td').eq(0).attr("partsnameName");
						$("#Name").val(name);
						
						//
						var name_ =  $('.table_detail.active').find('td').eq(0).attr("staPartsnameName");
						$("#staPartsnameName_id").val(name_);
						
					}
					
				
			  });
	
}






function query_(pntreeNodecode,current_page_){
	
	//  /goodsCode/query/page
	

	$.post("goodsCode/query/page",
			  {
			    memeber_code:'0000',
			    goodsNodecode:pntreeNodecode,
			    page_size:page_size,
			    current_page:current_page_
			  },
			 
			  function(d,status){
				var content=eval("("+d+")");
				
				
				
			
					var html = template('goods_code_tpl', content);
					
					$("#content_goodsCode").html(html);
					aTable();
					
					page_init(current_page_,content.max_page);
			  });
	
}

//查询产地
function init_product_area(){
	
	
	$.post("productArea/query",
			  {
			    memeber_code:'0000'
			   
			  },
			 
			  function(d,status){
				var content=eval("("+d+")");
			
			
				
				var html='';
				var data = content.data;
				  for(var i =0;i<data.length;i++){
					  
					html +='<option label="'+data[i].productareaName+'"  class="option_product_area" value="'+data[i].productareaName+'">'+data[i].productareaName+'</option>';  
				  }
				  $("#Origin").html(html);
				  $("#staProductareaName_id").html(html);
				  
				//如果是修改 选择之前的品名
					   if(goods_code_oper =='update'){
						var origin =  $('.table_detail.active').find('td').eq(0).attr("productareaName");
						$("#Origin").val(origin);
						
						//
						var origin_ =  $('.table_detail.active').find('td').eq(0).attr("staProductareaName");
						$("#staProductareaName_id").val(origin_);
						
					}
				
			  });
	
}

//查询材质
function init_goodsMaterial(){
	
	
	$.post("goodsCode/query/goodsMaterial",
			  {
			    memeber_code:'0000'
			   
			  },
			 
			  function(d,status){
				var content=eval("("+d+")");
			
			
				
				var html='';
				var data = content.data;
				  for(var i =0;i<data.length;i++){
					  
					html +='<option   value="'+data[i].goodsMaterial+'">'+data[i].goodsMaterial+'</option>';  
				  }
				  $("#Material").html(html);
				  $("#staGoodsMaterial_id").html(html);
				  
				//如果是修改 选择之前的品名
					   if(goods_code_oper =='update'){
						var Material =  $('.table_detail.active').find('td').eq(0).attr("goodsMaterial");
						$("#Material").val(Material);
						
						//
						var Material_ =  $('.table_detail.active').find('td').eq(0).attr("staGoodsMaterial");
						$("#staGoodsMaterial_id").val(Material_);
						
					}
				
			  });
	
}



//查询规格
function init_goodsSpce(){
	
	
	$.post("goodsCode/query/goodsSpec",
			  {
			    memeber_code:'0000'
			   
			  },
			 
			  function(d,status){
				var content=eval("("+d+")");
			
			
				
				var html='';
				var data = content.data;
				  for(var i =0;i<data.length;i++){
					  
					html +='<option   value="'+data[i].goodsSpec+'">'+data[i].goodsSpec+'</option>';  
				  }
				  $("#Specification").html(html);
				  $("#staGoodsSpec_id").html(html);
				  
				//如果是修改 选择之前的品名
					   if(goods_code_oper =='update'){
						var Specification =  $('.table_detail.active').find('td').eq(0).attr("goodsSpec");
						$("#Specification").val(Specification);
						
						//
						var Specification_ =  $('.table_detail.active').find('td').eq(0).attr("staGoodsSpec");
						$("#staGoodsSpec_id").val(Specification_);
						
					}
				
			  });
	
}





//查询工作组
function init_workgroup(){
	
	
	$.post("workgroup/query",
			  {
			    memeber_code:'0000'
			   
			  },
			 
			  function(d,status){
				var content=eval("("+d+")");
			
			
				
				var html='';
				var data = content.data;
				  for(var i =0;i<data.length;i++){
					  
					html +='<option   value="'+data[i].workgroupName+'">'+data[i].workgroupName+'</option>';  
				  }
				  $("#workgroupName_id").html(html);
				
				  
				//如果是修改 选择之前的品名
					   if(goods_code_oper =='update'){
						var workgroup_ =  $('.table_detail.active').find('td').eq(0).attr("workgroupName");
						$("#workgroupName_id").val(workgroup_);
						
						
						
					}
				
			  });
	
}







var  goods_code_oper = '';
$("li.goods_code_oper").on('click',function(){
	
	goods_code_oper = $(this).attr("data");
	//弹出
	if(goods_code_oper=='add'){
		//验证
		if($(".menu_content_group_node.active").length <1){
			alert("请选择大类");
			return;
		}
		 //跳出窗口
		 AddTable();
	}
	
	if(goods_code_oper=='update'){
		
		 //验证
		if($(".table_detail.active").length<1){
			alert("请选择物资代码");
			return;
		}
		 //跳出窗口
		 ModifyTable();
	}

	  if(goods_code_oper =='del'){
		  
		  //验证
			if($(".table_detail.active").length<1){
				alert("请选择物资代码");
				return;
			}
			PromptBox("是否删除物资代码",'','1',function(r){
				if(r=='ok'){
					  var goodscodeCode = $('.active.table_detail').find('td').eq(0).attr("goodscodeCode");
						 
						
					    $.post("goodsCode/delete",
								  {goodscodeCode:goodscodeCode},
								 
								  function(d,status){
									var content=eval("("+d+")");
									//验证返回数据
									if(!validated_return_data(content)){
										
										alert(content.msg);
										return;
									}
									
									
									
									query_(current_node,current_page_g);
					    	            close_window();
					    	            PromptBox("删除物资代码成功",'','2',function(r){});
								  });
					
				}
				
				
				
			});
		  
		
		  
	  }
	 
	  if(goods_code_oper =='add' || goods_code_oper =='update'){
		  
		  
		  
		  //加载品名下拉
		  init_partsname(current_node);
		  //加载下拉产地
		  init_product_area();
		  //下拉规格
		  init_goodsSpce();
		  //下拉材质
		  init_goodsMaterial();
		  //下拉工作组
		  init_workgroup();
	  }

	
});



//
function save_update(){
	//form_goods_code
	var msg = validated_form();
	if(msg != 'ok'){
		alert(msg);
		return;
	}


	
	if(goods_code_oper =='add'){
		
		var $form = $('#form_goods_code');
		var data = $form.serialize();
	
	 
	    
	    $.post("goodsCode/add",
				  data,
				 
				  function(d,status){
	    	var content=eval("("+d+")");
	    	//验证返回数据
			if(!validated_return_data(content)){
				
				alert(content.msg);
				return;
			}
	    	
	    	
				
			query_(current_node,current_page_g);
	    	            close_window();
				  });
		
		
		
		
		
	}else if(goods_code_oper =='update'){
		
		
		var $form = $('#form_goods_code');
		var data = $form.serialize();
	
		var goodscodeCode = $('.table_detail.active').find('td').eq(0).attr("goodscodeCode");
	    
		data = data +"&goodscodeCode="+goodscodeCode;
	    $.post("goodsCode/update",
				  data,
				 
				  function(d,status){
					var content=eval("("+d+")");
					
					//验证返回数据
					if(!validated_return_data(content)){
						
						alert(content.msg);
						return;
					}
				
					query_(current_node,current_page_g);
	    	            close_window();
				  });
		
	}
	
	
}





















var TableDetail = function(table_details) {
	$('#Name').val(table_details.eq(0).attr("partsnameName"));
	$('#Material').val(table_details.eq(0).attr("goodsMaterial"));
	$('#Specification').val(table_details.eq(0).attr("goodsSpec"));
	$('#Origin').val(table_details.eq(0).attr("productareaName"));
	$('#goodsTaxrate_id').val(table_details.eq(0).attr("goodsTaxrate"));
	$('#QuantityUnits').val(table_details.eq(0).attr("partsnameNumunit"));
	$('#WeightUnit').val(table_details.eq(0).attr("partsnameWeightunit"));
	$('#AssistantCode').val(table_details.eq(0).attr("partsnameMnemcode"));
	$('#goodsPiecemode_id').val(table_details.eq(0).attr("goodsPiecemode"));
	$('#goodsWeightmode_id').val(table_details.eq(0).attr("goodsWeightmode"));
	$('#goodsMetering_id').val(table_details.eq(0).attr("goodsMetering"));
	$('#goodsPriceun_id').val(table_details.eq(0).attr("goodsPriceun"));
	$('#Remarks').val(table_details.eq(0).attr("partsnameRemark"));

	$("#goodsProperty1_id").val(table_details.eq(0).attr("goodsProperty1"));
	$("#goodsProperty2_id").val(table_details.eq(0).attr("goodsProperty2"));
	$("#goodsPmeterweight_id").val(table_details.eq(0).attr("goodsPmeterweight"));
	$("#staPartsnameName_id").val(table_details.eq(0).attr("staPartsnameName"));
	$("#staGoodsMaterial_id").val(table_details.eq(0).attr("staGoodsMaterial"));
	$("#staGoodsSpec_id").val(table_details.eq(0).attr("staGoodsSpec"));
	$("#staProductareaName_id").val(table_details.eq(0).attr("staProductareaName"));
	$("#m10sWeight_id").val(table_details.eq(0).attr("m10sWeight"));
	$("#workgroupName_id").val(table_details.eq(0).attr("workgroupName"));
	
	
	if(table_details.eq(0).attr("dataAwedit")=="1") {
		$('#dataAwedit_id').attr("checked", true);
		
	}else{
		
		$('#dataAwedit_id').removeAttr("checked");
		
	}
	

}



$("#Name").on('blur',function(){
	
var partsname_ = $(".option_parts_name[value='"+$("#Name").val()+"']").eq(0);
// goodsPiecemode goodsWeightmode goodsMetering goodsPriceun goodsTaxrate
	
$("#goodsPiecemode_id").val(partsname_.attr("goodsPiecemode"));
$("#goodsWeightmode_id").val(partsname_.attr("goodsWeightmode"));
$("#goodsMetering_id").val(partsname_.attr("goodsMetering"));
$("#goodsPriceun_id").val(partsname_.attr("goodsPriceun"));
$("#goodsTaxrate_id").val(partsname_.attr("goodsTaxrate"));
});



/***
 * 表单验证
 * @returns {String}
 */
function validated_form(){
	

	var msg ='ok';
	
	if($("#Name").val()==''){
		
		msg="品名不能空";
	}
	
	if($("#Material").val()==''){
		msg='材质不能空';
	}
	
	if($("#Specification").val()==''){
		msg='规格不能空';
	}
	
	if($("#Origin").val()==''){
		msg='产地不能空';
	}
	
	return msg;
	
}


//@ sourceURL=product.js 