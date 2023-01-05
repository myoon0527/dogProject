let code;
let index = {
	init: function() {
		$("#btn-save").on("click",()=>{
			this.save();
		}),
		$("#btn-update").on("click",()=>{
			this.update();
		}),
		$("#btn-findUserId").on("click",()=>{
			this.findUserId();
		}),
		$("#btn-findPassword").on("click",()=>{
			this.findUserPassword();
		}),
		$("#btn-resetPassword").on("click",()=>{
			this.resetUserPassword();
		}),
		$("#mail-Check-Btn").on("click",()=>{
			this.findUserMail();
		}),
		$('#Num-Check-Btn').on("click",()=>{
			this.checkNum();
		});
	},
	
	save: function() {
		let data={
			username: $("#username").val(),
			userid: $("#userid").val(),
			userpassword: $("#userpwd").val(),
			email: $("#useremail").val(),
			phone: $("#userphone").val(),
			addr: $("#useraddr").val()
		};
		$.ajax({
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
			
		}).done(function(resp){
			alert("회원가입이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});	
	},
	update: function(){
		let id=$("#id").val();
		let data={  
			id: $("#id").val(),
			username: $("#username").val(),
			userid: $("#userid").val(),
			userpassword: $("#userpassword").val(),
			phone: $("#phone").val(),
			email: $("#email").val(),
			addr: $("#addr").val()
		};
		$.ajax({
			type:"PUT",
			url:"/user/"+id,
			data:JSON.stringify(data),  
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("회원수정이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	findUserId: function(){
		let data={
			username: $("#username").val(),
			phone: $("#phone").val()
		};
		console.log(data);
		$.ajax({
			type:"POST",
			url:"/auth/user/findUserId",
			data:JSON.stringify(data),  
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			if(resp.data.userid!=undefined){
				$("#findIdForm").remove();
				$("#findbtn").remove();
				$(".changeDiv").attr('class','col-lg-7 mb-5 changeDiv justify-content-center text-center');
				$(".changeDiv").append("<div id='foundId' class='control-group'><i class='fa fa-circle text-primary mr-3'></i>"+
					"<strong>내 아이디: "+resp.data.userid+"</strong></div>");
				$("#foundId").after("<br><br><div class=''><a href='/auth/loginForm' class='btn btn-primary py-2 px-4'>"+
					 "로그인하기</a><a href='/auth/findUserPassword' class='btn btn-primary py-2 px-4 ml-4'>비밀번호찾기</a></div>");
			}else{
				alert("일치하는 회원 정보가 없습니다.");
			}
			console.log(resp.data.userid);
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	findUserMail: function(){
		let data={
			email: $('#userEmail1').val()+$('#userEmail2').val()
		};
		let checkInput = $('#mail-check-input');
		console.log('완성된 이메일:'+data.email);
		$.ajax({
			type:"POST",
			url:"/auth/user/findUserEmail",
			data:JSON.stringify(data),  
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			if(resp.data.email!=undefined) {
				sendMail(resp.data);
			} else {
				alert("일치하는 회원 정보가 없습니다.");
			}
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	
	// 인증 번호 비교 
	checkNum: function () {
		const inputCode = $('#mail-check-input').val();
		const userpwd = $('#userpwd');
		const chkUserpwd = $('#chk-userpwd');
		$.ajax({
			type : "GET",
			success : function (data) {
				if(inputCode === code){
					alert('인증번호 확인이 완료되었습니다.');
					userpwd.attr('disabled',false);
					chkUserpwd.attr('disabled',false);	         
				}else{
					alert('인증번호가 불일치합니다.');
				}
			}
		});
	},
	
	resetUserPassword: function(){
		console.log("resetUserPassword함수 호출");
		let data={
			email: $('#userEmail1').val()+$('#userEmail2').val(),
			userpassword: $("#userpwd").val()
		};
		console.log(data);
		$.ajax({
			type:"PUT",
			url:"/auth/user/resetUserPassword",
			data:JSON.stringify(data),  
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("비밀번호 변경이 완료되었습니다.");
			location.href="/auth/loginForm";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
}
index.init();

function sendMail(foundData) {
		let data = {email: foundData.email};
		let checkInput = $('#mail-check-input');
		$.ajax({
			type : "GET",
			url : "/auth/mailCheck/"+data.email,
			success : function (data) {
				console.log("data : " +  data);
				checkInput.attr('disabled',false);
				alert('인증번호가 전송되었습니다.');
				code =data;
			}			
		});
	}