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
      <div class="row pb-2 justify-content-center">
        <div class="col-lg-9">
          <form action="">
            <div class="control-group">
              <input type="hidden" id="commuId" value="${commu.commuId}">
              <input type="text" class="form-control" id="title" value="${commu.title}">
              <p class="help-block text-dnager"></p>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="username" value="${commu.users.userid}" readonly>
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <textarea class="form-control summernote" id="content" rows="10">${commu.content}</textarea>
              <p class="help-block text-dnager"></p>
            </div> 
          </form>
          <button class="btn btn-primary py-2 px-4" id="btn-update">수정</button>
        </div>
      </div>
    </div>
  </div>
  <script>
    $('.summernote').summernote({
      tabsize: 2,
      height: 300
    })
  </script>
  <script type="text/javascript" src="/js/commu.js"></script>
  <!-- 섹션 2 end -->

<%@ include file="../layout/footer.jsp" %>