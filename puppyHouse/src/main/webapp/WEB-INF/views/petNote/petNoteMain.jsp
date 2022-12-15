<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="layout/header.jsp" %> 

<!-- ���� 1 start -->
  <div class="container-fluid bg-primary mb-5">
      <div
        class="d-flex flex-column align-items-center justify-content-center"
        style="min-height: 400px"
      >
        <h3 class="display-3 font-weight-bold text-white" style="font-family: Noto sans Korean">�ְ� ��ø</h3>
        <div class="d-inline-flex text-white">
          <p class="m-0"><a class="text-white" href="index.html">Home</a></p>
          <p class="m-0 px-2">/</p>
          <p class="m-0">�ְ� ��ø</p>
        </div>
      </div>
    </div>
	<!-- ���� 1 end -->
 <!-- dogMain -->
<div class="container-fluid pt-5">
  <div class="container">
    <div class="p-5 rounded bg-light">
      <div class="col-lg-12 mb-12">
        <div class="contact-form">
            <form name="sentMessage" id="contactForm" novalidate="novalidate">
              <div class="row">
                <div class="col-12 mb-3 ml-4"><button class="btn btn-info btn float-right">����</button><button class="btn btn-info btn float-right mr-1">�߰��ϱ�</button></div>
              </div>
                <div class="row justify-content-center mb-3">
                  <div class="control-group">
                    <div class="border border-2 img-fluid" style="border-radius: 70%; width: 150px; height: 150px; overflow: hidden;">
                      <img src="img/dogImg/icon/paws.png" alt="������ ����" style="width: 100%; height: 100%; object-fit: cover; background-color: white;">
                    </div>
                  </div>
               </div>
              <div class="text-center pb-2">
                <h5 class="mb-4 font-weight-bold fs-10"><select class="bg-light" style="border: none;outline: none;"><option>����</option></select></h5>
              </div>
            <div class="row">
              <div class="row justify-content-center">
                <div class="col-lg-5 col-md-6 pb-1">
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="padding: 30px; background-color: white; border: none;" onclick="location.href='DogNotice.html'">
                      <img src="img/dogImg/icon/������äũ.png" alt="�ϱ���" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>�˸���</h4>
                      </div>
                    </button>
                </div>
                <div class="col-lg-5 col-md-6 pb-1">
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="padding: 30px; background-color: white; border: none;" onclick="location.href='dogActivity.html'">
                      <img src="img/dogImg/icon/Ȱ��.png" alt="Ȱ��" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>������ Ȱ��</h4>
                      </div>
                    </button>
                </div>
                <div class="col-lg-5 col-md-6 pb-1">
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="padding: 30px; background-color: white; border: none;" onclick="location.href='dogFood.html'">
                      <!--<i class="flaticon-030-crayons h1 font-weight-normal text-primary mb-3"></i>-->
                      <img src="img/dogImg/icon/pet-food.png" alt="�Ĵ�" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>������ �Ĵ�</h4>
                      </div>
                    </button>
                </div>
                <div class="col-lg-5 col-md-6 pb-1">
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="padding: 30px;background-color: white; border: none;" onclick="location.href='dogHealth.html'">
                      <!--<i class="flaticon-017-toy-car h1 font-weight-normal text-primary mb-3"></i>-->
                      <img src="img/dogImg/icon/veterinary (1).png" alt="�ǰ�" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>�ǰ�üũ</h4>
                      </div>
                    </button>
                </div>
                <div class="col-lg-10 col-md-12 pb-1">
                    <button type="button"
                      class="d-flex shadow-sm rounded mb-4"
                      style="width: 100%; padding: 30px; background-color: white; border: none;" onclick="location.href='dogActivity.html'">
                      <!--<i class="flaticon-025-sandwich h1 font-weight-normal text-primary mb-3"></i>-->
                      <img src="img/dogImg/icon/��Ʈ������.png" alt="�ǰ�" class="h1 font-weight-normal text-primary mb-3" style="width:15%;">
                      <div class="pl-4">
                        <h4>������ �߾��</h4>
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

<%@ include file="layout/footer.jsp" %> 