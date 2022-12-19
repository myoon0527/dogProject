<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

  <!-- 섹션 1 start -->
  <div class="container-fluid bg-primary mb-5">
    <div
      class="d-flex flex-column align-items-center justify-content-center"
      style="min-height: 400px"
    >
      <h3 class="display-3 font-weight-bold text-white" style="font-family: Noto sans Korean">커뮤니티</h3>
      <div class="d-inline-flex text-white">
        <p class="m-0"><a class="text-white" href="/">Home</a></p>
        <p class="m-0 px-2">/</p>
        <p class="m-0">커뮤니티</p>
      </div>
    </div>
  </div>
  <!-- 섹션 1 end -->

  <!-- 섹션 2 start -->
  <div class="container-fluid">
    <div class="container">
      <div class="row pb-2">
        <div class="col-lg-12 mb-2">
          <span id="commuId" hidden>${commu.commuId}</span>
          <h3 class="col-lg-12 mb-2">${commu.title}</h3>
          <hr>
          <div class="col-lg-12 mb-2">
            작성자 : ${commu.users.userid}
          </div>
          <hr>
          <div class="col-lg-12 mb-2">
            <div>${commu.content}</div>
          </div>
          <hr>
        </div>
        <div class="col-lg-12">
          <a href="" class="text-primary font-weight-bold navbar-brand mb-3" style="font-size: 25px;">
            <i class="fas fa-heart"></i>
          </a>
          <em>{like-count}</em> &nbsp;&nbsp;&nbsp;&nbsp;
          <i class="text-primary font-weight-bold navbar-brand fas fa-comment" style="font-size: 25px;"></i>
          <em>{comment-count}</em>
          <c:if test="${commu.users.userid==principal.user.userid}">
          	<div class="float-lg-right float-md-right">
	            <a href="/commuBoard/${commu.commuId}/commuUpdate" class="btn btn-link" style="text-decoration: none; background-color: #dee2e6">수정</a>
	            <a class="btn btn-link" id="btn-delete" style="text-decoration: none; background-color: #dee2e6">삭제</a>
          	</div>
          </c:if>          
          <hr>
        </div>
        <div class="col-lg-12">
          <form action="">
            <div class="control-group">
              <input type="text" class="form-control" placeholder="댓글을 입력해주세요">
              <button class="btn btn-outline-primary" style="position: absolute; right: 15px; top: 0;">등록</button>
              <hr>
            </div>
          </form>
          <!-- 댓글 반복 출력 -->
          <div class="comment col-lg-12">
            <div class="col-lg-12">
              <p>username<i class="float-right">date</i></p>
            </div>
            <div class="col-lg-12 border-bottom">
              <p>{comment}<a class="text-dark fas fa-window-close float-right" style="text-decoration: none;"></a></p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
   <script type="text/javascript" src="/js/commu.js"></script>
  <!-- 섹션 2 end -->
<%@ include file="../layout/footer.jsp" %>



