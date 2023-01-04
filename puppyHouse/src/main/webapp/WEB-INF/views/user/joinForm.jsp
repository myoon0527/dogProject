<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>  

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
          <form novalidate action="" name="sentMessage" name="frm" id="joinForm" method="post">
            <div class="control-group">
             <label class="form-label" for="username">이름</label>
              <input type="text" class="form-control mb-2" name="username" id="username"  placeholder="Your Name" required>
                <div class="invalid-feedback my-2">닉네임은 필수 입력 값입니다.</div>
				<div class="valid-feedback my-2">사용가능한 닉네임입니다.</div>                  
            </div>
              <div class="control-group">
             <label class="form-label" for="userid">아이디</label>
              <input type="text" class="form-control mb-2" name="userid" id="userid"  placeholder="Your id" required>
             <div class="invalid-feedback my-2" id="idchk"></div>

            </div>
       		<div class="control-group">
               <label class="form-label" for="userpwd">비밀번호</label>
              <input type="password" class="form-control mb-2" name="userpwd" id="userpwd"  placeholder="Your password" required>
              <div class="invalid-feedback my-2">비밀번호는 필수 입력 값입니다.</div>
            </div>
            <div class="control-group">
             <label class="form-label" for="useremail">이메일</label>
              <input type="email" class="form-control mb-2" name="useremail" id="useremail"  placeholder="Your email" required>
           <div class="invalid-feedback my-2" id="emailchk">이메일은 필수 입력 값입니다.</div>
            </div>
             <div class="control-group">
             <label class="form-label" for="userphone">전화번호</label>
              <input type="text" class="form-control mb-2" name="userphone" id="userphone"  placeholder="Your phone" required>
           <div class="invalid-feedback my-2">전화번호는 필수 입력 값입니다.(하이픈을 제외하고 입력해 주세요.)</div>
            </div>
               <div class="control-group">
             <label class="form-label" for="useraddr">주소</label>
              <input type="text" class="form-control mb-2" name="useraddr" id="useraddr"  placeholder="Your addr" required>
              <input type="text" class="form-control mb-2" name="useraddrdetail" id="useraddrdetail"  placeholder="Your addr detail" required>
           <div class="invalid-feedback mb-2">상세 주소는 필수 입력 값입니다.</div>
            </div>
          </form>
          <div>
              <input type="button" class="btn btn-primary py-2 px-4 mt-2" id="btn-save" value="회원가입"></input>
          </div>
          
          <script src="/js/joinCheck.js"></script>
          <script src="/js/user.js"></script>
        </div>
      </div>
    </div>
  </div>
  
  
  <!-- 섹션 2 end -->
  <%@ include file="../layout/footer.jsp" %>  