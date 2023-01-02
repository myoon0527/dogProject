let index = {
	init: function() {
		$("#btn-save").on("click",()=>{
			this.save();
		}),
		$("#btn-update").on("click",()=>{
			this.update();
		});
	},
	
	save: function() {
		let data={
			username: $("#username").val(),
			userid: $("#userid").val(),
			userpassword: $("#userpwd").val(),
			email: $("#useremail").val(),
			phone: $("#userphone").val(),
			addr: $("#useraddr").val(),
			addrdetail: $("#useraddrdetail").val()
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
	}
}
index.init();

// 유효성 여부를 저장할 변수를 만들고 초기값 false 부여
   let isNickValid=false;
   let isIdValid=false;
   let isPwdValid=false;
   let isMailValid=false;
   let isPhoneValid=false;
   let isAddrValid=false;	

   // nick 인 input 요소에 input 이벤트가 일어났을때 실행할 함수 등록 
   document.querySelector("#username").addEventListener("input", function(){
      //1. 입력한 value 값을 읽어온다.
      let inputNick=this.value;
      //2. 유효성(5글자이상 10글자 이하)을 검증한다.
      isNickValid = inputNick.length >= 2 && inputNick.length <= 10;
      //3. 유효하다면 input 요소에 is-valid 클래스 추가, 아니라면 is-invalid 클래스 추가
      if(isNickValid){
         this.classList.remove("is-invalid");
         this.classList.add("is-valid");
      }else{
         this.classList.remove("is-valid");
         this.classList.add("is-invalid");
      }
   });
   
      //  id 인 input 요소에 input 이벤트가 일어났을때 실행할 함수 등록 
   document.querySelector("#userid").addEventListener("input", function(){
      //1. 입력한 value 값을 읽어온다.
        let isIdValid=this.value;
      //2. 유효성(5글자이상 10글자 이하)을 검증한다.
      //	var pattern1 = /[0-9]/; // 숫자
		//var pattern2 = /[a-zA-Z]/; // 문자
		//var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
      //3. 유효하다면 input 요소에 is-valid 클래스 추가, 아니라면 is-invalid 클래스 추가
      if(isIdValid){
         this.classList.remove("is-invalid");
         this.classList.add("is-valid");
      }else{
         this.classList.remove("is-valid");
         this.classList.add("is-invalid");
      }
   });
   
 
       // pwd 인 input 요소에 input 이벤트가 일어났을때 실행할 함수 등록 
   document.querySelector("#userpwd").addEventListener("input", function(){
      //1. 입력한 value 값을 읽어온다.
      let inputPwd=this.value;
      //2. 유효성(5글자이상 10글자 이하)을 검증한다.
      isPwdValid = inputPwd.length >= 4 && inputPwd.length <= 14;
      //3. 유효하다면 input 요소에 is-valid 클래스 추가, 아니라면 is-invalid 클래스 추가
      if(isPwdValid){
         this.classList.remove("is-invalid");
         this.classList.add("is-valid");
      }else{
         this.classList.remove("is-valid");
         this.classList.add("is-invalid");
      }
   });
   
  
         // email 인 input 요소에 input 이벤트가 일어났을때 실행할 함수 등록 
   document.querySelector("#useremail").addEventListener("input", function(){
      let x = document.getElementById("emailchk");
      //1. 입력한 value 값을 읽어온다.
      let inputEmail = this.value;
      
      //2. 유효성(5글자이상 10글자 이하)을 검증한다.
      isMailValid = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i.test(inputEmail);
      console.log(isMailValid);
      //3. 유효하다면 input 요소에 is-valid 클래스 추가, 아니라면 is-invalid 클래스 추가
      if(isMailValid){
         this.classList.remove("is-invalid");
         this.classList.add("is-valid");
      }else{
         this.classList.remove("is-valid");
         this.classList.add("is-invalid");
         if(inputEmail == "") {
			x.innerText = "이메일은 필수 입력 값입니다."
		}
		 else{
			x.innerText = "올바른 형식으로 작성해 주세요"
		}
      }
   });
   
          // phone 인 input 요소에 input 이벤트가 일어났을때 실행할 함수 등록 
   document.querySelector("#userphone").addEventListener("input", function(){
      //1. 입력한 value 값을 읽어온다.
      let inputPhone = this.value;
      //2. 유효성(5글자이상 10글자 이하)을 검증한다.
   		isPhoneValid = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/.test(inputPhone);
   		console.log(isPhoneValid);
      //3. 유효하다면 input 요소에 is-valid 클래스 추가, 아니라면 is-invalid 클래스 추가
      if(isPhoneValid){
         this.classList.remove("is-invalid");
         this.classList.add("is-valid");
      }else{
         this.classList.remove("is-valid");
         this.classList.add("is-invalid");
      }
   });
   
          // pwd 인 input 요소에 input 이벤트가 일어났을때 실행할 함수 등록 
   document.querySelector("#useraddrdetail").addEventListener("input", function(){
      //1. 입력한 value 값을 읽어온다.
      let isAddrValid=this.value;
      //2. 유효성(5글자이상 10글자 이하)을 검증한다.
      //isAddrValid = inputAddr.length <= 4 && inputAddr.length <= 14;
      //3. 유효하다면 input 요소에 is-valid 클래스 추가, 아니라면 is-invalid 클래스 추가
      if(isAddrValid){
         this.classList.remove("is-invalid");
         this.classList.add("is-valid");
      }else{
         this.classList.remove("is-valid");
         this.classList.add("is-invalid");
      }
   });
   
   
window.onload = function(){
    document.getElementById("useraddr").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("useraddr").value = data.address; // 주소 넣기
                document.querySelector("input[name=useraddr]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}