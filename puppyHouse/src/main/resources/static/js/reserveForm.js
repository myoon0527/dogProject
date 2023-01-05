let index={
	init: function(){
		$("#reserve_btn").on("click",()=>{
			this.save();
		});
		
	},
	
	save: function(){
		
		let	petId= $("#dogname").val();
		let	teacherId= $("#trainer").val();
		let data={
			reservdate: $("#reserveDate").val()
			};
			console.log(data);
			$.ajax({
			type:"POST",
			url:"/api/petReserve/"+petId+"/"+teacherId,
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("예약이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
}
index.init();