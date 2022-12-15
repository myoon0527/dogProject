<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="layout/header.jsp" %> 
  <!-- ���� 1 start -->
  <div class="container-fluid bg-primary mb-5">
    <div
      class="d-flex flex-column align-items-center justify-content-center"
      style="min-height: 400px"
    >
      <h3 class="display-3 font-weight-bold text-white" style="font-family: Noto sans Korean">�α���</h3>
      <div class="d-inline-flex text-white">
        <p class="m-0"><a class="text-white" href="index.html">Home</a></p>
        <p class="m-0 px-2">/</p>
        <p class="m-0">�α���</p>
      </div>
    </div>
  </div>
  <!-- ���� 1 end -->

  <!-- ���� 2 start -->
  <div class="container-fluid">
    <div class="container">
      <div class="row justify-content-center pb-2">
        <div class="col-lg-7 mb-5">
          <form action="" name="login" id="loginForm">
            <div class="control-group">
              <input type="text" class="form-control" id="userid" placeholder="Your ID">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="password" class="form-control" id="userpwd" placeholder="Your Password">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="checkbox" id=""> �α��λ�������
              <a href="" style="float: right;">���̵� / ��й�ȣ ã��</a>
              <p class="help-block text-danger"></p>
            </div>
            <div>
              <button class="btn btn-primary px-3" type="submit" id="login-btn">�α���</button>
              <a href="join.html" class="btn btn-primary px-3 ml-4" id="join-btn">ȸ������</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <!-- ���� 2 end -->
<%@ include file="layout/footer.jsp" %> 
