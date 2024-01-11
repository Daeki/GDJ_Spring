<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
<body>
   <c:import url="../temps/header.jsp"></c:import>
    
    <section class="container-fluid">
    	<div>
    		<c:if test="${not empty dto}">
    		<h3>${dto.region_id}</h3>
    		<div>${dto.region_name}</div>
    		<div>
    			<h2>FILE</h2>
    			<c:forEach items="${dto.regionFileDTOs}" var="f">
    			<a href="/resources/upload/regions/${f.fileName}">${f.oriName}</a>
    			</c:forEach>
    		</div>
    		
    		<a href="">Update</a>

			<button id="up" data-region-id="${dto.region_id}">Update</button>
    		<button id="del">Delete</button>
    		<form id="frm" action="./delete" method="post">
    			<input type="hidden" name="region_id" value="${dto.region_id}">
    		</form>
    		</c:if>
    		
    		<c:if test="${empty dto}">
    			<h3>없는 번호 입니다</h3>
    		</c:if>
    	</div>
    
    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
	<script src="../resources/js/regionDetail.js"></script>
	<!-- /regions/-->
	<!-- /reources/-->
</body>
</html>