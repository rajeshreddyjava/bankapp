$(document).ready(
		function() {

			var jVal = {
				'firstName' : function() {
					$('body').append('<div id="nameInfo" class="info"></div>');
					var nameInfo = $('#nameInfo');
					var ele = $('#firstName');
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
				'lastName' : function() {
					$('body').append('<div id="lastNameInfo" class="info"></div>');
					var lastNameInfo = $('#lastNameInfo');
					var ele = $('#lastName');
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
				'nickName' : function() {
					$('body').append('<div id="nickNameInfo" class="info"></div>');
					var nickNameInfo = $('#nickNameInfo');
					var ele = $('#nickName');
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
				},
				'accountNumber' : function() {
					$('body').append('<div id="accountNumberInfo" class="info"></div>');
					var accountNumberInfo = $('#accountNumberInfo');
					var ele = $('#accountNumber');
					var pos = ele.offset();
					accountNumberInfo.css({
						top : pos.top - 3,
						left : pos.left + ele.width() + 15

					});

					if (ele.val().length!=10) {
						jVal.errors = true;
						accountNumberInfo.removeClass('correct').addClass('error').html(
								'&larr; must be 10 characters').show();
						ele.removeClass('normal').addClass('wrong');
					} else {
						accountNumberInfo.removeClass('error').addClass('correct').html(
								'OK &radic;').show();
						ele.removeClass('wrong').addClass('normal');
					}
				},
				'reAccountNumber' : function() {
					$('body').append('<div id="reAccountNumberInfo" class="info"></div>');
					var reAccountNumberInfo = $('#reAccountNumberInfo');
					var ele = $('#reAccountNumber');
					var accountNumVal = $('#accountNumber');
					var pos = ele.offset();
					reAccountNumberInfo.css({
						top : pos.top - 3,
						left : pos.left + ele.width() + 15

					});

					if (ele.val().length!=10 && accountNumVal.val()!=ele.val()) {
						jVal.errors = true;
						reAccountNumberInfo.removeClass('correct').addClass('error').html(
								'&larr; 10 characters and match account number').show();
						ele.removeClass('normal').addClass('wrong');
					} else {
						reAccountNumberInfo.removeClass('error').addClass('correct').html(
								'OK &radic;').show();
						ele.removeClass('wrong').addClass('normal');
					}
				},
				'streetAddress' : function() {
					$('body').append('<div id="streetAddressInfo" class="info"></div>');
					var streetAddressInfo = $('#streetAddressInfo');
					var ele = $('#streetAddress');
					var pos = ele.offset();
					streetAddressInfo.css({
						top : pos.top - 3,
						left : pos.left + ele.width() + 15

					});

					if (ele.val().length == 0) {
						jVal.errors = true;
						streetAddressInfo.removeClass('correct').addClass('error').html(
								'&larr; must not be empty').show();
						ele.removeClass('normal').addClass('wrong');
					} else {
						streetAddressInfo.removeClass('error').addClass('correct').html(
								'OK &radic;').show();
						ele.removeClass('wrong').addClass('normal');
					}
				},
				'city' : function() {
					$('body').append('<div id="cityInfo" class="info"></div>');
					var cityInfo = $('#cityInfo');
					var ele = $('#city');
					var pos = ele.offset();
					cityInfo.css({
						top : pos.top - 3,
						left : pos.left + ele.width() + 15

					});

					if (ele.val().length == 0) {
						jVal.errors = true;
						cityInfo.removeClass('correct').addClass('error').html(
								'&larr; must not be empty').show();
						ele.removeClass('normal').addClass('wrong');
					} else {
						cityInfo.removeClass('error').addClass('correct').html(
								'OK &radic;').show();
						ele.removeClass('wrong').addClass('normal');
					}
				},
				'state' : function() {
					$('body').append('<div id="stateInfo" class="info"></div>');
					var stateInfo = $('#stateInfo');
					var ele = $('#state');
					var pos = ele.offset();
					stateInfo.css({
						top : pos.top - 3,
						left : pos.left + ele.width() + 15

					});

					if (ele.val().length == 0) {
						jVal.errors = true;
						stateInfo.removeClass('correct').addClass('error').html(
								'&larr; must not be empty').show();
						ele.removeClass('normal').addClass('wrong');
					} else {
						stateInfo.removeClass('error').addClass('correct').html(
								'OK &radic;').show();
						ele.removeClass('wrong').addClass('normal');
					}
				},
				'zipCode' : function() {
					$('body').append('<div id="zipCodeInfo" class="info"></div>');
					var zipCodeInfo = $('#zipCodeInfo');
					var ele = $('#zipCode');
					var pos = ele.offset();
					zipCodeInfo.css({
						top : pos.top - 3,
						left : pos.left + ele.width() + 15

					});
					var patt = /^\d{5}(-\d{4})?/;
					if (!patt.test(ele.val())) {
						jVal.errors = true;
						zipCodeInfo.removeClass('correct').addClass('error').html(
								'&larr;please enter valid zipcode').show();
						ele.removeClass('normal').addClass('wrong');
					} else {
						zipCodeInfo.removeClass('error').addClass('correct').html(
								'OK &radic;').show();
						ele.removeClass('wrong').addClass('normal');
					}
				},
				'phoneNumber' : function() {
					$('body').append('<div id="phoneNumberInfo" class="info"></div>');
					var phoneNumberInfo = $('#phoneNumberInfo');
					var ele = $('#phoneNumber');
					var pos = ele.offset();
					phoneNumberInfo.css({
						top : pos.top - 3,
						left : pos.left + ele.width() + 15

					});
					var patt = /[2-9]{2}\d{8}/;
					if (ele.val()=="") {
						jVal.errors = true;
						phoneNumberInfo.removeClass('correct').addClass('error').html(
								'&larr; please enter a valid phonenumber').show();
						ele.removeClass('normal').addClass('wrong');
					} else {
						phoneNumberInfo.removeClass('error').addClass('correct').html(
								'OK &radic;').show();
						ele.removeClass('wrong').addClass('normal');
					}
				},
				'emailAddress' : function() {
					$('body').append('<div id="emailAddressInfo" class="info"></div>');
					var emailAddressInfo = $('#emailAddressInfo');
					var ele = $('#emailAddress');
					var pos = ele.offset();
					emailAddressInfo.css({
						top : pos.top - 3,
						left : pos.left + ele.width() + 15

					});
					var patt = /^.+@.+[.].{2,}$/i;
					if (!patt.test(ele.val())) {
						jVal.errors = true;
						emailAddressInfo.removeClass('correct').addClass('error').html(
								'&larr; please enter a valid email').show();
						ele.removeClass('normal').addClass('wrong');
					} else {
						emailAddressInfo.removeClass('error').addClass('correct').html(
								'OK &radic;').show();
						ele.removeClass('wrong').addClass('normal');
					}
				},
				'sendIt' : function (){
					if(!jVal.errors) {
						$('#jform').submit();
					}
				}
			};
			$('#send').click(function (){
					
					jVal.errors = false;
					jVal.firstName();
					jVal.lastName();
					jVal.nickName();
					jVal.accountNumber();
					jVal.reAccountNumber();
					jVal.streetAddress();
					jVal.city();
					jVal.state();
					jVal.zipCode();
					jVal.phoneNumber();
					jVal.emailAddress();
					jVal.sendIt();
				
				return false;
			});

			$('#firstName').change(jVal.firstName);
			$('#lastName').change(jVal.lastName);
			$('#nickName').change(jVal.nickName);
			$('#accountNumber').change(jVal.accountNumber);
			$('#reAccountNumber').change(jVal.reAccountNumber);
			$('#streetAddress').change(jVal.streetAddress);
			$('#city').change(jVal.city);
			$('#state').change(jVal.state);
			$('#zipCode').change(jVal.zipCode);
			$('#phoneNumber').change(jVal.phoneNumber);
			$('#emailAddress').change(jVal.emailAddress);
		});