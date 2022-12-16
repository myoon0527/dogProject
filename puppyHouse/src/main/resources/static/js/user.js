let index = {
	init: function() {
		$("#btn-save").on("click",()=>{
			this.save();
		});
	},
	
	save: function() {
		let data={
			userName: $("#username").val(),
			userId: $("#userid").val(),
			userPassword: $("#userpwd").val(),
			email: $("#useremail").val(),
			phone: $("#userphone").val(),
			addr: $("#useraddr").val()
		};
		console.log(data)
		$.ajax({
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
			
		}).done(function(resp){
			alert("회원가입이 완료되었습니다.");
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	}
}
index.init();