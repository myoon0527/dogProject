<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>  

  <!-- 섹션 1 start -->
  <div class="container-fluid bg-primary mb-5">
    <div
      class="d-flex flex-column align-items-center justify-content-center"
      style="min-height: 400px"
    >
      <h3 class="display-3 font-weight-bold text-white" style="font-family: Noto sans Korean">회원가입</h3>
      <div class="d-inline-flex text-white">
        <p class="m-0"><a class="text-white" href="/">Home</a></p>
        <p class="m-0 px-2">/</p>
        <p class="m-0">회원가입</p>
      </div>
    </div>
  </div>
  <!-- 섹션 1 end -->

  <!-- 섹션 2 start -->
  <div class="container-fluid">
    <div class="container">
      <div class="row justify-content-center pb-2">
        <div class="col-lg-7 mb-5">
          <form action="" name="sentMessage" id="joinForm">
            <div class="control-group">
              <input type="text" class="form-control" id="username" placeholder="Your Name">
              <div class="valid-feedback" style="display: block">이름을 입력하세요</div>
              <p class="help-block text-danger"></p> 
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="userid" placeholder="Your ID" onkeyup="CV_checkIdPattern()">
              <div class="valid-feedback" id="idchk" style="display: block">아이디를 입력하세요</div>
              <p class="help-block text-danger"></p> 
            </div>
            <div class="control-group">
              <input type="password" class="form-control" id="userpwd" name="pw" placeholder="Your Password" onkeyup="CV_checkPasswordPattern()">
              <div class="valid-feedback" id="pwdchk" style="display: block">비밀번호를 입력하세요</div>
              <p class="help-block text-danger"></p> 
            </div>
            <div class="control-group">
              <input type="email" class="form-control" id="useremail" placeholder="Your Email">
              <div class="valid-feedback" id="emailchk" style="display: block">이메일을 입력하세요</div>
              <p class="help-block text-danger"></p> 
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="userphone" placeholder="Your Phone Number">
              <div class="valid-feedback" style="display: block">전화번호를 입력하세요</div>
              <p class="help-block text-danger"></p> 
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="useraddr" placeholder="Your Address">
              <div class="valid-feedback" style="display: block">주소를 입력하세요</div>
              <p class="help-block text-danger"></p> 
            </div>
            
          </form>
          <div>
              <input type="button" class="btn btn-primary py-2 px-4" id="btn-save" value="회원가입"></input>
          </div>
          <script src="/js/user.js"></script>
	       	
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="/js/joinCheck.js?v=<%=new java.util.Date().getTime()%>"></script>
  <!-- 섹션 2 end -->
  
  <%@ include file="../layout/footer.jsp" %>  