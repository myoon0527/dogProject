let index = {
	init: function() {
		$("#btn-save").on("click",()=>{
			this.save();
		}),
		$("#btn-update").on("click",()=>{
			this.update();
		});
	},
	
	zzz: function() {
		console.log(idCheck());
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
		console.log("namecheck"+nameCheck());
		console.log("idCheck"+idCheck());
		console.log("pwdCheck"+pwdCheck());
		console.log("pwdCheck2"+pwdCheck2());
		console.log("emailCheck"+emailCheck());
		console.log("phoneCheck"+phoneCheck());
		console.log("addrCheck"+addrCheck());
		console.log("addrCheck2"+addr());
		let test = 	nameCheck()&&idCheck()&&pwdCheck()&&pwdCheck2()&&emailCheck()&&phoneCheck()&&addrCheck()&&addr();
		
		if(test){		
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
		}
		else {
			alert("정보를 확인해 주세요")
		}
	},
	
	update: function(){
		let id=$("#id").val();
		let data={  
			id: $("#id").val(),
			username: $("#username").val(),
			userid: $("#userid").val(),
			userpassword: $("#userpassword").val(),
			phone: $("#userphone").val(),
			email: $("#useremail").val(),
			addr: $("#useraddr").val(),
			addrdetail: $("#useraddrdetail").val()
		};
		console.log("pwdCheck"+pwdCheck());
		console.log("pwdCheck2"+pwdCheck2());
		console.log("emailCheck"+emailCheck());
		console.log("phoneCheck"+phoneCheck());
		let test = pwdCheck()&&pwdCheck2()&&emailCheck()&&phoneCheck()&&addrCheck()&&addr();
		console.log("test =" + test);
		if(test) {
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
		else {
			alert("정보를 확인해 주세요.")
		}
		
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

//이름
function nameCheck(){ 
	let inputNick = document.getElementById("username").value;
	let f = document.getElementById("username");
	let x = document.getElementById("namechk");
	
	var pattern_kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글체크
	var pattern1 = /[0-9]/; // 숫자
	var pattern2 = /[a-zA-Z]/; // 영문자
	var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
	
	var nametest = (pattern_kor.test(inputNick) || pattern2.test(inputNick));
	if(!nametest || pattern3.test(inputNick) || pattern1.test(inputNick) || inputNick.length > 10) {
		x.innerText = "10글자 이하로 입력해주세요.(숫자와 특수문자를 사용할 수 없습니다.)"
		isNickValid = false;
	}
	else {
		isNickValid = true;
	}		
 
    if(isNickValid) {
    	f.classList.remove("is-invalid");
        f.classList.add("is-valid");
        return true;
        }
    else {
    	f.classList.remove("is-valid");
    	f.classList.add("is-invalid");
    	
    	if(inputNick == "") {
			x.innerText = "이름은 필수 입력 값입니다."
		}
		else {
			x.innerText = "10글자 이하로 입력해주세요.(숫자와 특수문자를 사용할 수 없습니다.)"
		}
		return false;
	}
}

//아이디
function idCheck() {
	let inputId = document.getElementById("userid").value;
		
	let x = document.getElementById("idchk");
	let y = document.getElementById("idchk2");
	let f = document.getElementById("userid");
     
 	var pattern1 = /[0-9]/; // 숫자
	var pattern2 = /[a-zA-Z]/; // 문자
	var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
     
 	var numtextyn = (pattern1.test(inputId) || pattern2.test(inputId));
	if(!numtextyn || pattern3.test(inputId) || inputId.length > 14) {
		x.innerText = "아이디는 14자리 이하 문자 또는 숫자로 구성하여야 합니다."
		isIdValid = false;	
	}
	else {
		isIdValid = true;
	}
     
	if(isIdValid){
		let id=$("#userid").val();
	
		$.ajax({
			type:"POST",
			url:"/auth/idCheck/"+id,
			contentType:"application/json; charset=utf-8",
			dataType:"json"
			}).done(function(resp){
				console.log(resp.data)
				if(resp.data == 1) {
					 x.innerText = "이미 사용중인 아이디 입니다."
					 f.classList.remove("is-valid");
	     			 f.classList.add("is-invalid");
	     			 return false;
				}
				else {
					y.innerText = "사용 가능한 아이디 입니다."
					f.classList.remove("is-invalid");
	     			f.classList.add("is-valid");
	     			return true;
				}
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
  return true;
  }
  else {
     f.classList.remove("is-valid");
     f.classList.add("is-invalid");
     
     if(inputId == ""){
		x.innerText = "아이디는 필수 입력 값입니다."	
	}
     else {
		x.innerText = "아이디는 14자리 이하 문자 또는 숫자로 구성하여야 합니다."
	}
	return false;
  }
}

//비밀번호
function pwdCheck() {
	let inputPwd = document.getElementById("userpwd").value;
	let f = document.getElementById("userpwd");
	let x = document.getElementById("pwdchk");
	
	var pattern1 = /[0-9]/; // 숫자
	var pattern2 = /[a-zA-Z]/; // 문자
	var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
    
      if(!pattern1.test(inputPwd) || !pattern2.test(inputPwd) || !pattern3.test(inputPwd) || inputPwd.length < 8) {
	  	x.innerText = "비밀번호는 8자리 이상 문자, 숫자, 특수문자로 구성하여야 합니다."
	  	isPwdValid = false;
	  }
	  else {
		isPwdValid = true;
	  }
	  
      if(isPwdValid){
         f.classList.remove("is-invalid");
         f.classList.add("is-valid");
         return true;
      }
      else {
         f.classList.remove("is-valid");
         f.classList.add("is-invalid");
         if(inputPwd == ""){
			x.innerText = "비밀번호는 필수 입력 값입니다."	
		}
		return false;
      }
} 
   
//비밀번호 확인
function pwdCheck2() {
	let inputPwdChk = document.getElementById("userpwdChk").value;
	let f = document.getElementById("userpwdChk");	
	let inputPwd = document.getElementById("userpwd").value;

	if(inputPwd != inputPwdChk) {
		 f.classList.remove("is-valid");
     	 f.classList.add("is-invalid");
     	 return false;
	}
	else {
		f.classList.remove("is-invalid");
     	f.classList.add("is-valid");
     	return true;
	}
}  

//이메일
function emailCheck() {
	let x = document.getElementById("emailchk");
	let inputEmail = document.getElementById("useremail").value;
	let f = document.getElementById("useremail");
	  
	  //2. 유효성(5글자이상 10글자 이하)을 검증한다.
	  isMailValid = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i.test(inputEmail);
	  //3. 유효하다면 input 요소에 is-valid 클래스 추가, 아니라면 is-invalid 클래스 추가
	  if(isMailValid){
	     f.classList.remove("is-invalid");
	     f.classList.add("is-valid");
	     return true;
	  }
	  else {
	     f.classList.remove("is-valid");
	     f.classList.add("is-invalid");
	     if(inputEmail == "") {
			x.innerText = "이메일은 필수 입력 값입니다."
		}
		 else{
			x.innerText = "올바른 형식으로 작성해 주세요"
		}
		return false;
	  }
} 

//전화번호
function phoneCheck() {

	  let inputPhone = document.getElementById("userphone").value;
	  let f = document.getElementById("userphone");
	  
	  isPhoneValid = /^01(?:0|1|[6-9])(?:\d{4})\d{4}$/.test(inputPhone);
     
      if(isPhoneValid){
         f.classList.remove("is-invalid");
         f.classList.add("is-valid");
         return true;
      }
      else {
         f.classList.remove("is-valid");
         f.classList.add("is-invalid");
         return false;
      }
} 
 
//주소
function addr() {
	let inputAddr = document.getElementById("useraddr").value;
	 new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("useraddr").value = data.address; // 주소 넣기
                document.querySelector("input[name=useraddr]").focus(); //상세입력 포커싱
            }
        }).open();
    
	
	let f = document.getElementById("useraddr");
	if(inputAddr == "") {
		f.classList.remove("is-valid");
		f.classList.add("is-invalid");
		return false;
		
	}
	else {
		f.classList.remove("is-invalid");
        f.classList.add("is-valid");
		return true;
	}
    
}
function addrcheeeck() {

	let inputAddr = document.getElementById("useraddr").value;
	let f = document.getElementById("useraddr");
	if(inputAddr == "") {
		f.classList.remove("is-valid");
		f.classList.add("is-invalid");
		return false;
		
	}
	else {
		f.classList.remove("is-invalid");
        f.classList.add("is-valid");
		return true;
	}
}


//상세주소
function addrCheck() {
	
      let isAddrValid = document.getElementById("useraddrdetail").value;
      let f = document.getElementById("useraddrdetail")
     
      if(isAddrValid){
         f.classList.remove("is-invalid");
         f.classList.add("is-valid");
         return true;
      }else{
         f.classList.remove("is-valid");
         f.classList.add("is-invalid");
         return false;
      }
}
   

  


    
