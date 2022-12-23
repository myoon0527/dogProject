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
         <a href="/user/updateForm" class="btn btn-outline-primary active">
           회원정보 수정</a>
       </li>
       <li class="d-inline-block m-1">
         <a href="/reserve/myReserve" class="btn btn-outline-primary">나의 예약 내역</a>
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
        <div class="col justify-content-center">
          <form class="col-7 mx-auto">
         	<input type="hidden" id="id" value="${principal.user.id}">
            <div class="form-group px-xl-5 px-lg-5">
              <label for="username">성명</label><br>
              <input
                type="text"
                class="form-control"
                id="username"
                placeholder="${principal.user.username}"
                value="${principal.user.username}"
                readonly
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="form-group px-xl-5 px-lg-5">
              <label for="userid">아이디</label><br>
              <input
                type="text"
                class="form-control"
                id="userid"
                placeholder="${principal.user.userid}"
                value="${principal.user.userid}"
                readonly
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group px-xl-5 px-lg-5">
              <label for="userpassword">비밀번호</label><br>
              <input
                type="password"
                class="form-control"
                id="userpassword"
                required="required"
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="form-group px-xl-5 px-lg-5">
              <label for="userpassword2">비밀번호 확인</label><br>
              <input
              type="password"
              class="form-control"
              id="userpassword2"
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
                placeholder="${principal.user.phone}"
                value="${principal.user.phone}"
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="form-group px-xl-5 px-lg-5">
              <label for="email">이메일</label><br>
              <input
                type="email"
                class="form-control"
                id="email"
                placeholder="${principal.user.email}"
                value="${principal.user.email}"
              />
              <p class="help-block text-danger"></p>
            </div>
            <div class="form-group px-xl-5 px-lg-5">
              <label for="addr">주소</label><br>
              <input
                type="text"
                class="form-control"
                id="addr"
                placeholder="${principal.user.addr}"
                value="${principal.user.addr}"
              />
              <p class="help-block text-danger"></p>
            </div>
          </form>
          <div class="col-3 mx-auto text-center">
              <button
                class="btn btn-primary py-2 px-4"
                type="submit"
                id="btn-update"
              >수정완료
              </button>
            </div>
        </div>
    </div>
  </div>
  <script type="text/javascript" src="/js/user.js"></script>
  <!-- 메인 end -->

<%@ include file="../layout/footer.jsp" %>  