<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %> 

<!-- 섹션 1 start -->
  <div class="container-fluid bg-primary mb-5">
      <div
        class="d-flex flex-column align-items-center justify-content-center"
        style="min-height: 400px"
      >
        <h3 class="display-3 font-weight-bold text-white" style="font-family: Noto sans Korean">애견수첩</h3>
        <div class="d-inline-flex text-white">
          <p class="m-0"><a class="text-white" href="index.html">Home</a></p>
          <p class="m-0 px-2">/</p>
          <p class="m-0">애견 수첩</p>
        </div>
      </div>
    </div>
	<!-- 섹션 1 end -->
 <!-- dogMain -->
<div class="container-fluid pt-5">
  <div class="container">
    <div class="p-5 rounded bg-light">
      <div class="col-lg-12 mb-12">
        <div class="contact-form">
            <form name="sentMessage" id="contactForm" novalidate="novalidate">
              <div class="row">
                <div class="col-12 mb-3 ml-4"><button type="button" class="btn btn-info btn float-right" onclick="location.href='/petNote/petUpdateForm'">수정</button><button type="button" class="btn btn-info btn float-right mr-1" onclick="location.href='/petNote/petImg'">추가하기</button></div>
              </div>
                <div class="row justify-content-center mb-3">
                  <div class="control-group">
                    <div class="border border-2 img-fluid" style="border-radius: 70%; width: 150px; height: 150px; overflow: hidden;">
                      <img src="/images/${pets.imgName}" alt="프로필 사진" style="width: 100%; height: 100%; object-fit: cover; background-color: white;">
                    </div>
                  </div>
               </div>
              <div class="text-center pb-2">
                <h5 class="mb-4 font-weight-bold fs-10">
                	<select class="bg-light" id="sel" name="sel" style="border: none;outline: none;" onchange=changeval() >
                	<!--  <option value="">강아지 이름 선택</option> -->
                	<c:forEach var="pet" items="${loginUserPet}">
                		<option value="/petNote/${pet.petId}" <c:if test='${pet.petId eq petId}'>selected</c:if>>${pet.petName}  </option>
                	</c:forEach>
                	</select></h5>
              </div>
            <div class="row">
              <div class="row justify-content-center">
                <div class="col-lg-5 col-md-6 pb-1">
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="padding: 30px; background-color: white; border: none;" onclick="location.href='/petNote/notice'">
                      <img src="../img/dogImg/icon/강아지채크.png" alt="일기장" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>알림장</h4>
                      </div>
                    </button>
                </div>
                <div class="col-lg-5 col-md-6 pb-1">
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="padding: 30px; background-color: white; border: none;" onclick="location.href='/petNote/activity'">
                      <img src="../img/dogImg/icon/활동.png" alt="활동" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>오늘의 활동</h4>
                      </div>
                    </button>
                </div>
                <div class="col-lg-5 col-md-6 pb-1">
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="padding: 30px; background-color: white; border: none;" onclick="location.href='/petNote/food'">
                      <!--<i class="flaticon-030-crayons h1 font-weight-normal text-primary mb-3"></i>-->
                      <img src="../img/dogImg/icon/pet-food.png" alt="식단" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>오늘의 식단</h4>
                      </div>
                    </button>
                </div>
                <div class="col-lg-5 col-md-6 pb-1">
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="padding: 30px;background-color: white; border: none;" onclick="location.href='/petNote/health'">
                      <!--<i class="flaticon-017-toy-car h1 font-weight-normal text-primary mb-3"></i>-->
                      <img src="../img/dogImg/icon/veterinary (1).png" alt="건강" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>건강체크</h4>
                      </div>
                    </button>
                </div>
                <div class="col-lg-10 col-md-12 pb-1">
                	<c:set var="roles" value="DIARY" scope="session"/>
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="width: 100%; padding: 30px; background-color: white; border: none;" onclick="location.href='/petNote/diary/${petId}'">
                      <!--<i class="flaticon-025-sandwich h1 font-weight-normal text-primary mb-3"></i>-->
                      <img src="../img/dogImg/icon/하트강아지.png" alt="건강" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>소중한 추억들</h4>
                      </div>
                    </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- dogMain end -->

<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>


<script type="text/javascript" >
function changeval(){
	var value = document.getElementById("sel").value;
	location.href= value;
	//var petvalue = $('#sel option:selected').val();
}
</script>
</script>

<%@ include file="../layout/footer.jsp" %> 