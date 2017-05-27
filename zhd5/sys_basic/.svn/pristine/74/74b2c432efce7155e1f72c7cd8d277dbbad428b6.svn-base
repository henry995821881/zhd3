
var entryGet = function(data) {
	$("#content").html(data);
	Window_Width_Height();
}
$.get("about", function(data) {
	entryGet(data);
});



function entry(val) {



	switch(val) {
	
	case undefined:
		$.get("about", function(data) {
			entryGet(data);
		});
		break;
	case '1':
		$.get("orgManage.html", function(data) {
			entryGet(data);
		});
		break;
	case '2':
		$.get("deptManage.html", function(data) {
			entryGet(data);
		});
		break;
	case '3':
		$.get("employeeManage.html", function(data) {
			entryGet(data);
		});
		break;
	case '4':
		$.get("warehouseManage", function(data) {
			entryGet(data);
		});
		break;
	case '5':
		$.get("wareAreaManage", function(data) {
			entryGet(data);
		});
		break;
	case '6':
		$.get("warePlaceManage", function(data) {
			entryGet(data);
		});
		break;
	case '7':
		$.get("partsname", function(data) {
			entryGet(data);
		});
		break;
	case '8':
		$.get("productArea", function(data) {
			entryGet(data);
		});
		break;
	case '9':
		$.get("goodsCode", function(data) {
			entryGet(data);
		});
		break;
	case '30':
		$.get("to_area", function(data) {
			entryGet(data);
		});
		break;
	case '31':
		$.get("to_company", function(data) {
			entryGet(data);
		});
		break;
	}
}