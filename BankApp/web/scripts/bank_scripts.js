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

function validateTransfer(){

	var jVal = {
			'fromAccountType' : function() {
				$('body').append('<div id="fromAccountTypeInfo" class="info"></div>');
				var nameInfo = $('fromAccountTypeInfo');
				var ele = $('#fromAccountType');
				var pos = ele.offset();
				nameInfo.css({
					top : pos.top - 3,
					left : pos.left + ele.width() + 15

				});

				if (ele.val().length < 1) {
					jVal.errors = true;
					nameInfo.removeClass('correct').addClass('error').html(
							'&larr; cannot be empty').show();
					ele.removeClass('normal').addClass('wrong');
				} else {
					nameInfo.removeClass('error').addClass('correct').html(
							'OK &radic;').show();
					ele.removeClass('wrong').addClass('normal');
				}
			},
			'toAccountNumber' : function() {
				$('body').append('<div id="toAccountNumberInfo" class="info"></div>');
				var lastNameInfo = $('#toAccountNumberInfo');
				var ele = $('#toAccountNumber');
				var pos = ele.offset();
				lastNameInfo.css({
					top : pos.top - 3,
					left : pos.left + ele.width() + 15

				});

				if (ele.val().length < 1) {
					jVal.errors = true;
					lastNameInfo.removeClass('correct').addClass('error').html(
							'&larr; cannot be empty').show();
					ele.removeClass('normal').addClass('wrong');
				} else {
					lastNameInfo.removeClass('error').addClass('correct').html(
							'OK &radic;').show();
					ele.removeClass('wrong').addClass('normal');
				}
			},
			'scheduleDat' : function() {
				$('body').append('<div id="scheduleDateInfo" class="info"></div>');
				var nickNameInfo = $('#scheduleDateInfo');
				var ele = $('#scheduleDate');
				var pos = ele.offset();
				nickNameInfo.css({
					top : pos.top - 3,
					left : pos.left + ele.width() + 15

				});

				if (ele.val().length < 1) {
					jVal.errors = true;
					nickNameInfo.removeClass('correct').addClass('error').html(
							'&larr; cannot be empty').show();
					ele.removeClass('normal').addClass('wrong');
				} else {
					nickNameInfo.removeClass('error').addClass('correct').html(
							'OK &radic;').show();
					ele.removeClass('wrong').addClass('normal');
				}
			}
	};
	
	
}
