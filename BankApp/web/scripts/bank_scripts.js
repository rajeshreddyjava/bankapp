$(document).ready(function(){
	
	$('#cash').click(function () {
        $('#checkFile').hide();
	});

	$('#check').click(function () {
        $('#checkFile').show();
	});

    $('.date-picker').datepicker( {
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        showOn: "button",
        buttonImage: "images/calendar.gif",
        buttonImageOnly: true
       }
    );
});