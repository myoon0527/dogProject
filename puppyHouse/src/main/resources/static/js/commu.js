let index={
	init: function() {
		$("#btn-save").on("click",()=>{
			this.save();
		});
	},
	
	save: function() {
		let data={
			title: $("#title").val(),
			content: $("#content").val()
		};
		$.ajax({
			type:"POST",
			url:"/api/commu",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("작성 완료");
			location.href="/auth/commuBoard/commuMain";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
}
index.init();