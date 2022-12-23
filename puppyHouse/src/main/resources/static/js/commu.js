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
		$("#btn-reply-save").on("click",()=>{
			this.replySave();
		});
		$("#btn-liked").on("click",()=>{
			this.addLike();
		});
		$("#btn-unliked").on("click",()=>{
			this.addLike();
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
	
	replySave: function() {
		var id = $("#commuId").text();
		let data={
			content: $("#reply-content").val()
		};
		console.log(id);
		$.ajax({
			type:"POST",
			url:"/api/commu/"+id+"/reply",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("댓글 작성 완료");
			location.href="/auth/commuBoard/"+id;
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	addLike: function() {
		var commuid = $("#commuId").text();

		console.log(commuid);
		$.ajax({
			type:"POST",
			url:"/api/like/"+commuid,
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("좋아요 완료");
			location.href="/auth/commuBoard/"+commuid;
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

function likes(CommunityId, likes_state) {
		if(!likes_state) {
			$.ajax({
				type:"POST",
				url: `/api/commu/${CommunityId}/likes`,
				dataType: "json"
			}).done(function(resp){
				alert("좋아요 완료");
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		}
	}

function replyDeleteById(commuId, replyId) {
		//var id = $("#commuId").text(); 
		//var id2 = $("#replyId").text(); 
		console.log(replyId);
		console.log(commuId);
		
		$.ajax({
			type:"DELETE",
			url:`/api/commu/${commuId}/reply/${replyId}`,
			dataType:"json"
		}).done(function(resp){
			alert("댓글 삭제 완료");
			location.href=`/auth/commuBoard/${commuId}`;
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
index.init();