$(function() {
	$("#messageForm").submit(function() {
		var str = $("#content").val();
		if (str.length < 5) {
			alert("������5�����ϵ��ַ� " + str.length);
			return false;
		}
		return true;
	});

	$(".login").click(function() {
		var page = "checklogin";
		$.get(page, function(result) {
			if (result == "success") {
				alert("�ѵ�¼");
			} else {
				$("#loginModal").modal("show");
			}
		});
		return false;
	});

	$(".checklogin").click(function() {
		var page = "checklogin";
		var href = this.href;
		$.get(page, function(result) {
			if (result == "success") {
				window.location.href = href;
			} else {
				alert("δ��¼");
				$("#loginModal").modal("show");
			}
		});
		return false;
	});

	$(".loginSubmitButton").click(function() {
		var account = $("#account").val();
		var password = $("#password").val();

		if (account.length == 0 || password.length == 0) {
			$("span.errorMessage").html("�������˺�����");
			$("div.loginErrorMessageDiv").show();
			return false;
		}

		var page = "loginAjax";
		$.post(page,
			{ "account": account, "password": password },
			function(result) {
				if (result == "success") {
					location.reload();
				} else {
					$("span.errorMessage").html(result);
					$("div.loginErrorMessageDiv").show();
				}
			});
		return true;
	});

	$("#addBookmarkForm").submit(function() {
		var data = $("#addBookmarkForm").serialize();
		var url = "addBookmark";
		$.post(url,data,
			function(result){
				if(result=="success"){
					var msg = $("div.message");
					msg.fadeIn(1000);
					msg.fadeOut(2000);
				} else {
					alert("���ʧ��");
				}
			});
		return false;
	});
	
	function addsuccess(){
		var msg = $("div.message");
		msg.fadeIn(1000);
		msg.fadeOut(2000);
		
	}
});