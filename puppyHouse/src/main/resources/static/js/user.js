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
				$("#findIdForm").remove();
				$("#findbtn").remove();
				$(".changeDiv").attr('class','col-lg-7 mb-5 changeDiv justify-content-center text-center');
				$(".changeDiv").append("<div id='foundId' class='control-group'><i class='fa fa-circle text-primary mr-3'></i>"+
					"<strong>내 아이디: "+resp.data.userid+"</strong></div>");
				$("#foundId").after("<br><br><div class=''><a href='/auth/loginForm' class='btn btn-primary py-2 px-4'>"+
					 "로그인하기</a><a href='/auth/findUserPassword' class='btn btn-primary py-2 px-4 ml-4'>비밀번호찾기</a></div>");
					 
			console.log(resp.data.userid);
		}).fail(function(error){
			alert("일치하는 회원 정보가 없습니다.");
		});
	},
	
	findUserPassword: function(){
		let data={
			userid: $("#userid").val(),
			username: $("#username").val(),
			phone: $("#phone").val()
		};
		console.log(data);
		$.ajax({
			type:"POST",
			url:"/auth/user/findUserPassword",
			data:JSON.stringify(data),  
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			location.href="/auth/resetUserPassword/"+resp.data.id;
			console.log(resp.data.userid);
		}).fail(function(error){
			alert("일치하는 회원 정보가 없습니다.");
		});
	},
	
	resetUserPassword: function(){
		console.log("resetUserPassword함수 호출");
		let data={
			id: $("#id").val(),
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
	}
}
index.init();