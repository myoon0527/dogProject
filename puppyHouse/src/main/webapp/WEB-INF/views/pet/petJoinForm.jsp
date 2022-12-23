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
          <form>
          <input type="text" id="petId" value="${pets.petId}"/>
             <div class="row justify-content-center">
              <div class="control-group">
                <div class="border border-2 img-fluid" style="border-radius: 70%; width: 150px; height: 150px; overflow: hidden; background-color: white;">
                  <img src="/images/${pets.imgName}" alt="프로필 사진" style="width: 100%; height: 100%; object-fit: cover;">
                </div>
              </div>
           	</div>
            <div class="control-group">
              <input type="text" class="form-control" id="petName" name="petName" placeholder="강아지 이름" value="${pets.petName}" required="required">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
               <!--   <input type="radio" id="birthday" name="birthday" value="0" checked="checked">생년월일-->
                <!-- <input type="radio" id="birthday" name="birthday" value="1">나이입력 -->
              <div><input type="date" class="form-control" name="petage" id="petage" size="20" value="${pets.age}" required="required"></div>
              <!--  <div><input type="text" class="form-control" name="petage" id="petage" size="20" placeholder="강아지 나이" required="required"></div> -->
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="species" name="species" value="${pets.species}" placeholder="강아지 품종" required="required">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <select class="form-control" id="gender" name="gender">
                <optgroup label="성별">
                  <option value="male">남아</option>
                  <option value="female">여아</option>
                </optgroup>
              </select>
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <select class="form-control" id="neutered" name="neutered">
                <optgroup label="중성화 여부">
                  <option value="yes">했어요</option>
                  <option value="no">안 했어요</option>
                </optgroup>
              </select>
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="weight" name="weight" placeholder="강아지 몸무게" required="required">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="allergy" name="allergy" placeholder="알러지">
              <p class="help-block text-danger"></p>
            </div>
            <div class="control-group">
              <input type="text" class="form-control" id="etc" name="etc" placeholder="특이사항">
              <p class="help-block text-danger"></p>
            </div>
      	</form>
            <div class="row">
              <div class="col text-center">
                <button type ="submit" class="btn btn-primary py-2 px-4" id="pet_btn_save">등록하기</button>
              </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<script type="text/javascript" src="/js/pet.js"></script>
<!-- 컨텐츠 end -->
<%@ include file="../layout/footer.jsp" %> 