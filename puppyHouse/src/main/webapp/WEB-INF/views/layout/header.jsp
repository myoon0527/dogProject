<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>index</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <!-- 아이콘 -->
    <link href="/img/favicon.ico" rel="icon" />

    <!-- 구글 웹 폰트 -->
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Handlee&family=Nunito&display=swap"
      rel="stylesheet"
    />

    <!-- Font Awesome -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
      rel="stylesheet"
    />

    <!-- Flaticon Font -->
    <link href="/lib/flaticon/font/flaticon.css" rel="stylesheet" />

    <!-- 라이브러리 스타일시트 <link href="/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" /> -->
    
    <link href="/lib/lightbox/css/lightbox.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/style.css" rel="stylesheet" />
    
        <!-- 캘린더 스타일시트 -->
    <link href="/css/myReservation.css" rel="stylesheet" />
    
     <!--카카오 지도 API-->
     <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5994d78f64b564c1aaf75803fce10a44"></script>
     
    <!-- Summernote -->
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
  
  <!-- isotope -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.isotope/3.0.6/isotope.pkgd.min.js" integrity="sha512-Zq2BOxyhvnRFXu0+WE6ojpZLOU2jdnqbrM1hmVdGzyeCa1DgM3X5Q4A/Is9xA1IkbUeDd7755dNNI/PzSf2Pew==" crossorigin="anonymous"></script>
</head>

<body>
	<!-- 메뉴 Start -->
    <div class="container-fluid position-relative shadow">
      <nav
        class="navbar navbar-expand-lg navbar-light py-3 py-lg-0 px-0 px-lg-5"
      >
          <a
          href="/"
          class="navbar-brand font-weight-bold text-secondary"
          style="font-size: 50px"
        >
      	<img class="img-fluid" src="/img/logo.png" alt="logo">
        </a>
        <button
          type="button"
          class="navbar-toggler"
          data-toggle="collapse"
          data-target="#navbarCollapse"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
          <div class="navbar-nav font-weight-bold mx-auto">
            <a href="/" class="nav-item nav-link active mr-3">Home</a>
            <a href="/auth/introduce" class="nav-item nav-link mr-3">소개</a>
            <a href="/auth/reserveMain" class="nav-item nav-link mr-3">예약</a>
			<a href="/auth/commuBoard/commuMain" class="nav-item nav-link mr-3">커뮤니티</a>
			<a href="/auth/news/newsMain" class="nav-item nav-link mr-3">고객센터</a>
			<a href="/user/updateForm" class="nav-item nav-link mr-3">마이페이지</a>
          </div>
          <a href="/user/loginForm.jsp" class="btn btn-primary px-3">로그인</a>
		  <a href="/user/joinForm.jsp" class="btn btn-primary px-3 ml-4">회원가입</a>
        </div>
      </nav>
    </div>
    <!-- 메뉴 End --> 