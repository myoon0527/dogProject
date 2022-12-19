let index={
	init: function() {
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-delete").on("click",()=>{
			this.deleteById();
		});
		$("#btn-update").on("click",()=>{
			this.update();
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
	
	deleteById: function() {
		var id = $("#commuId").text();
		
		$.ajax({
			type:"DELETE",
			url:"/api/commu/"+id,
			dataType:"json"
		}).done(function(resp){
			alert("삭제 완료");
			location.href="/auth/commuBoard/commuMain";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	update: function() {
		let id=$("#commuId").val();
		
		let data={
			title: $("#title").val(),
			content: $("#content").val()
		};
		$.ajax({
			type:"PUT",
			url:"/api/commu/"+id,
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("수정 완료");
			location.href="/auth/commuBoard/commuMain";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
}
index.init();