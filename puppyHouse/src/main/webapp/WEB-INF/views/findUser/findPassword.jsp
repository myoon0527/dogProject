<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<!-- 섹션 1 start -->
<div class="container-fluid bg-primary mb-5">
  <div
    class="d-flex flex-column align-items-center justify-content-center"
    style="min-height: 400px"
  >
    <h3 class="display-3 font-weight-bold text-white" style="font-family: Noto sans Korean">비밀번호찾기</h3>
    <div class="d-inline-flex text-white">
      <p class="m-0"><a class="text-white" href="/">Home</a></p>
      <p class="m-0 px-2">/</p>
      <p class="m-0">비밀번호찾기</p>
    </div>
  </div>
</div>
<!-- 섹션 1 end -->

<!-- 섹션 2 start -->
<div class="container-fluid">    
  <div class="container">
    <div class="row justify-content-center pb-2">
      <div class="col-lg-7 mb-5 changeDiv">
        <form class="form-group email-form">
	 		<label for="email">이메일</label>
			<input type="text" class="form-control" name="useremail1" id="useremail1" placeholder="이메일" onkeyup="emailCheck()">
			
		</form>
        <div class="input-group-addon">
			<button type="button" class="btn btn-primary" id="mail-Check-Btn">인증번호 받기</button>
		</div>
		<div class="mail-check-box">
			<input id="mail-check-input" placeholder="인증번호 6자리를 입력해주세요!" disabled="disabled" maxlength="6">
		</div>
		<div class="input-group-addon">
			<button type="button" class="btn btn-primary" id="Num-Check-Btn">확인</button>
		</div>
		<form name="resetPwdForm" id="resetPwdForm">
          <div class="control-group">
            <input type="password" class="form-control" id="userpwd" disabled="disabled" placeholder="새 비밀번호">
            <p class="help-block text-danger"></p>
          </div>
          <div class="control-group">
            <input type="password" class="form-control" id="chk-userpwd" disabled="disabled" placeholder="새 비밀번호 확인">
            <p class="help-block text-danger"></p>
          </div>
        </form>
        <div>
            <button class="btn btn-primary py-2 px-4" id="btn-resetPassword">확인</button>
        </div>    
      </div>
    </div>
  </div>
</div>
<!-- 섹션 2 end -->
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>