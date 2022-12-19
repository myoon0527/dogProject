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
      <div class="row justify-content-center">
        <div class="col-lg-12 pb-2">
          <a href="/commuBoard/commuSaveForm" class="btn btn-primary" style="float: right;">글 작성하기</a>
        </div>
        <c:forEach var="commu" items="${commu.content}">
        	<div class="col-lg-4 mb-4">
        		<div class="card border-0 shadow-sm mb-2">
        			<img src="/img/blog-1.jpg" alt="img" class="card-img-top mb-2">
        			<div class="card-body bg-light text-center p-4">
	        			<h4>${commu.title}</h4>
	        			<div class="d-flex justify-content-center mb-3">
			                <small class="mr-3">
			                  <i class="fa fa-user text-primary"></i> ${commu.users.userid}
			                </small>
			                <small class="mr-3">
			                  <i class="fa fa-folder text-primary"></i> folder
			                </small>
			                <small class="mr-3">
			                  <i class="fa fa-comments text-primary"></i> comments
			                </small> 
		              	</div>
		              	<p>글 미리보기,.,,,,,</p>
		                <a href="/auth/commuBoard/${commu.commuId}" class="btn btn-primary px-4 mx-auto my-2">자세히 보기</a>
        			</div>
        		</div>
        	</div>
        </c:forEach>
        
        <div class="col-md-12 mb-4">
          <nav aria-label="Page navigation">
            <ul class="pagination justify-content-center mb-0">
            	<c:choose>
            		<c:when test="${commu.first}">
            			<li class="page-item disabled">
            				<a class="page-link" href="?page="${commu.number-1}">
	            				<span aria-hidden="true">«</span>
	                  			<span class="sr-only">Previous</span>
            				</a>
            			</li>
            		</c:when>
            		<c:otherwise>
            			<li class="page-item">
            				<a class="page-link" href="?page=${commu.number-1}">
            					<span aria-hidden="true">«</span>
	                  			<span class="sr-only">Previous</span>
            				</a>
            			</li>
            		</c:otherwise>
            	</c:choose>
	            <li class="page-item"><a href="" class="page-link">1</a></li>
	            <li class="page-item"><a href="" class="page-link">2</a></li>
	            <li class="page-item"><a href="" class="page-link">3</a></li>
	            <c:choose>
            		<c:when test="${commu.last}">
            			<li class="page-item disabled">
            				<a class="page-link" href="?page="${commu.number+1}">
	            				<span aria-hidden="true">»</span>
		                		<span class="sr-only">Next</span>
            				</a>
            			</li>
            		</c:when>
            		<c:otherwise>
            			<li class="page-item">
            				<a class="page-link" href="?page=${commu.number+1}">
            					<span aria-hidden="true">»</span>
		                		<span class="sr-only">Next</span>
            				</a>
            			</li>
            		</c:otherwise>
            	</c:choose>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
  <!-- 섹션 2 end -->

<%@ include file="../layout/footer.jsp" %>