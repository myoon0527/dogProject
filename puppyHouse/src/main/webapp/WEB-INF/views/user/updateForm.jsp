<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>  
	
	<!-- 섹션 1 start -->
  <div class="container-fluid bg-primary mb-5">
      <div
        class="d-flex flex-column align-items-center justify-content-center"
        style="min-height: 400px"
      >
        <h3 class="display-3 font-weight-bold text-white" style="font-family: Noto sans Korean">마이페이지</h3>
        <div class="d-inline-flex text-white">
          <p class="m-0"><a class="text-white" href="/">Home</a></p>
          <p class="m-0 px-2">/</p>
          <p class="m-0">소개</p>
        </div>
      </div>
    </div>
	<!-- 섹션 1 end --> 
	

  <!-- 회원정보 수정 start -->
<div class="container-fluid">
  <div class="container p-5">
    <div class="col-12 text-center mb-2">
      <ul class="list-inline mb-4" id="portfolio-flters">
        <li class="d-inline-block m-1">
         <a href="" class="btn btn-outline-primary active">
           회원정보 수정</a>
       </li>
       <li class="d-inline-block m-1">
         <a href="../reserve/myReserve.jsp" class="btn btn-outline-primary">나의 예약 내역</a>
        </li>
       </ul>
    </div>
  </div>
</div>
     
  <div class="container-fluid">
    <div class="container">
        <div class="text-center">
          <h1>회원정보 수정</h1>
        </div>
        <div class="row justify-content-center">
          <form class="col-4 col-md-8 col-sm-9 px-5" name="updateUserInfo" id="updateUserInfoForm">
            <div class="form-group px-xl-5 px-lg-5">
              <label for="username">성명</label><br>
              <input
                type="text"
                class="form-control"
                id="username"
                placeholder="${username}"
                readonly
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="form-group px-xl-5 px-lg-5">
              <label for="userId">아이디</label><br>
              <input
                type="text"
                class="form-control"
                id="userId"
                placeholder="${userId}"
                readonly
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group px-xl-5 px-lg-5">
              <label for="password">비밀번호</label><br>
              <input
                type="password"
                class="form-control"
                id="password"
                required="required"
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="form-group px-xl-5 px-lg-5">
              <label for="password2">비밀번호 확인</label><br>
              <input
              type="password"
              class="form-control"
              id="password2"
              required="required"
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="form-group px-xl-5 px-lg-5">
              <label for="phone">휴대폰 번호</label><br>
              <input
                type="tel"
                class="form-control"
                id="phone"
                placeholder="${phone}"
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="form-group px-xl-5 px-lg-5">
              <label for="email">이메일</label><br>
              <input
                type="email"
                class="form-control"
                id="email"
                placeholder="${email}"
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="form-group px-xl-5 px-lg-5">
              <label for="address">주소</label><br>
              <input
                type="text"
                class="form-control"
                id="address"
                placeholder="${address}"
              />
              <p class="help-block text-danger"></p>
            </div>
            <div>
              <button
                class="btn btn-primary py-2 px-4"
                type="submit"
                id="sendMessageButton"
              >
                수정완료
              </button>
            </div>
          </form>
        </div>
    </div>
  </div>
      
  <!-- 메인 end -->

<%@ include file="../layout/footer.jsp" %>  