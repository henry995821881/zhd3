/*var Verification_Disabled = function() {
	if($('#MeetingBank').val() === '') {
		add_table_submit.attr("disabled", "disabled");
	} else {
		add_table_submit.attr("disabled", false);
	}
}*/
var TableDetail = function(table_details) {
	$('#MeetingBank').val(table_details.eq(0).text());
	$('#Code').val(table_details.eq(1).text());
	$('#Address').val(table_details.eq(2).text());
	$('#Tel').val(table_details.eq(3).text());
	$('#Contact').val(table_details.eq(4).text());
}
/*
$('#MeetingBank').on('blur', function() {
	var a = $(this);
	Verification(a);
	Verification_Disabled();
});*/