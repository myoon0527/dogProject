<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<!-- 섹션 1 start -->
  <div class="container-fluid bg-primary mb-5">
      <div
        class="d-flex flex-column align-items-center justify-content-center"
        style="min-height: 400px"
      >
        <h3 class="display-3 font-weight-bold text-white" style="font-family: Noto sans Korean">애견수첩 등록하기</h3>
        <div class="d-inline-flex text-white">
          <p class="m-0"><a class="text-white" href="index.html">Dog Note</a></p>
          <p class="m-0 px-2">/</p>
          <p class="m-0">애견수첩</p>
        </div>
      </div>
    </div>
	<!-- 섹션 1 end -->
<!-- 컨텐츠 start -->
<div class="container-fluid pt-5">
  <div class="container">
    <div class="bg-light p-5 rounded">
    <div class="text-center pb-2">
      <h1 class="mb-4">반려동물 등록</h1>
    </div>
    <div class="row justify-content-center">
      <div class="col-lg-7 mb-5">
        <div class="contact-form">
          <div id="success"></div>
          <form name="sentMessage" id="contactForm" novalidate="novalidate">
            <div class="row justify-content-center">
              <div class="control-group">
                <div class="border border-2 img-fluid" style="border-radius: 70%; width: 150px; height: 150px; overflow: hidden; background-color: white;">
                  <img src="img/dogImg/icon/paws.png" style="width: 100%; height: 100%; object-fit: cover;">
                </div>
              </div>
           </div>
            <div class="row">
              <div class="col text-center">
                <div class="control-group">
                  <label for="chooseFile" class="border border-2 btn btn-light py-2 px-4" style="padding: 8px; margin-top: 15px;">사진 등록하기</label>
                  <input type="file" class="d-none" id="chooseFile" name="chooseFile" accept="image/*">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="petname" placeholder="강아지 이름" required="required">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
                <input type="radio" name="birthday" value="0" checked="checked">생년월일
                <input type="radio" name="birthday" value="1">나이입력
              <div><input type="date" class="form-control" name="petage" id="petage" size="20" required="required"></div>
              <div><input type="text" class="form-control" name="petage" id="petage" size="20" placeholder="강아지 나이" required="required"></div>
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="kind" placeholder="강아지 품종" required="required">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <select class="form-control">
                <optgroup label="성별">
                  <option value="male">남아</option>
                  <option value="female">여아</option>
                </optgroup>
              </select>
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <select class="form-control" id="">
                <optgroup label="중성화 여부">
                  <option value="yes">했어요</option>
                  <option value="no">안 했어요</option>
                </optgroup>
              </select>
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="kind" placeholder="강아지 몸무게" required="required">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="kind" placeholder="알러지">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="kind" placeholder="특이사항">
              <p class="help-block text-danger"></p>
            </div>
            <div class="row">
              <div class="col text-center">
                <button class="btn btn-primary py-2 px-4" type="submit" id="sendMessageButton">등록하기</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<!-- 컨텐츠 end -->
<%@ include file="../layout/footer.jsp" %> 