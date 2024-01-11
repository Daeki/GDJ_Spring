<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<!--summer note-->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	
  </head>
<body>
<header>
    	<nav class="navbar bg-dark  navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">Navbar</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavDropdown">
		      <ul class="navbar-nav">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="/">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/regions/list">Regions</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/departments/list">Departments</a>
		        </li>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Dropdown link
		          </a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="#">Action</a></li>
		            <li><a class="dropdown-item" href="#">Another action</a></li>
		            <li><a class="dropdown-item" href="#">Something else here</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
    
    </header>
    
    <section id="contents" class="container-fluid" >
    	<div class="row mt-4">
			<form action="add" method="post" enctype="multipart/form-data">
			  
			  <div class="mb-3">
			    <label for="regionName" class="form-label">RegionName</label>
			    <input type="text" name="region_name" class="form-control" id="regionName">
			  </div>

			  <div class="mb-3">
				<label for="regionContents" class="form-label">RegionContents</label>
				<textarea id="regionContents" class="form-control" ></textarea>

			  </div>

			  <div>
				<input type="checkbox" name="ch" value="1">
				<input type="checkbox" name="ch" value="2">
				<input type="checkbox" name="ch" value="3">
				<input type="checkbox" name="ch" value="4">

			  </div>

			  <div class="mb-3">
				<input type="file" name="photo">
				<input type="file" name="photo">
				<input type="file" name="photo">
			  </div>

			  <button type="submit" class="btn btn-primary">Add</button>
			</form>    		
    	
    	</div>
	
    </section>

	<script>
		$('#regionContents').summernote()
	</script>
</body>
</html>