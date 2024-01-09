<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <c:import url="../temps/bootStrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../temps/header.jsp"></c:import>	

	<h1>Regions List</h1>
	
	<div>
		<form class="row g-3" action="./list">
		  <div class="col-auto">
		  <select name="kind" class="form-select" aria-label="Default select example">
			  <option value="kind1">Title</option>
			  <option value="kind2">Contents</option>
			  <option value="kind3">Writer</option>
			  <option value="kind4">Title+Contents+Writer</option>
		</select>
		  
		  </div>		
		
		  <div class="col-auto">
		    <label for="search" class="visually-hidden">Search</label>
		    <input type="text" name="search" class="form-control" id="search">
		  </div>
		  <div class="col-auto">
		    <button type="submit" class="btn btn-primary mb-3">검색</button>
		  </div>
		</form>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th><th>NAME</th>
			</tr>
		</thead>
		<!-- for(int i=0;i<;i++) -->
		<!-- for(타입명 변수명:배열명) -->
		<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${pageScope.dto.region_id}</td>
				<td><a href="./detail?region_id=${dto.region_id}">${pageScope.dto.region_name}</a></td>
			</tr>
		</c:forEach>


		<tbody>
			
		</tbody>
		
	</table>
	
	<div>
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  	<c:if test="${!pager.start}">
		    <li class="page-item">
		      <a class="page-link" href="./list?page=${pager.startNum-1}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    </c:if>
		    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    <li class="page-item"><a class="page-link" href="./list?page=${i}&search=${pager.search}">${i}</a></li>
		    </c:forEach>
		   
		   <c:if test="${!pager.last}"> 
		    <li class="page-item">
		      <a class="page-link" href="./list?page=${pager.lastNum+1}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		    </c:if>
		  </ul>
		</nav>
	</div>
	
	<a href="add" class="btn btn-success">Add</a>
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
 	
</body>
</html>