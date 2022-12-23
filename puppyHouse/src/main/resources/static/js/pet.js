let index={
	init: function(){
		$("#pet_btn_save").on("click",()=>{
			this.save();
		});
	},
	
	save: function(){
		let userid=$("#userid").text();
		let userpwd=$("#userpwd").text();
		
		let data={
			petId: $("#petId").val(),
			petName: $("#petName").val(),
			petage: $("#petage").val(),
			species: $("#species").val(),
			gender: $("#gender").val(),
			neutered: $("#neutered").val(),
			weight: $("#weight").val(),
			allergy: $("#allergy").val(),
			etc: $("#etc").val()
			
		};
		console.log(data);
		$.ajax({
			type:"PUT",
			url:"/api/pet",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json",
		}).done(function(resp){
			alert("강아지 정보가 등록되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		})
	}
}
index.init();