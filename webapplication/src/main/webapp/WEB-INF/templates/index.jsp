<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 

    <title>Equipement Manager | Home</title>
    
      <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
     <link href="../../static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="../../static/js/html5shiv.min.js"></script>
		<script src="../../static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="http://localhost:8080/demo/all-equipement" class="navbar-brand">Intercom app</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="http://localhost:8080/demo/new-equipement">New Equipement</a></li>
					<li><a href="http://localhost:8080/demo/all-equipement">All Equipement</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Equipement Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_TASKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Equipements</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
							
								<th>id</th>
								<th>model</th>
								<th>numSerie</th>
								<th>type</th>
								<th>id_util</th>
								<th>associe</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="equipement" items="${equipements}">
								<tr>
									<td>${equipement.id}</td>
									<td>${equipement.model}</td>
									<td>${equipement.numSerie}</td>
									<td>${equipement.type}</td>
									<td>${equipement.id_util}</td>
									<td>${equipement.associe}</td>
									<td><a href="update-equipement?id=${equipement.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-equipementk?id=${equipement.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Equipement</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-equipement">
					<input type="hidden" name="id" value="${equipement.id}"/>
					<div class="form-group">
						<label class="control-label col-md-3">Model</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="model" value="${equipement.model}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Num Serie</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="numSerie" value="${equipement.numSerie}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Type</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="type" value="${equipement.type}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">L'id utilisateur</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="id_util" value="${equipement.id_util}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Associe</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="associe" value="true"/>
							<div class="col-sm-1">Yes</div>
							<input type="radio" class="col-sm-1" name="associe" value="false" checked/>
							<div class="col-sm-1">No</div>
						</div>				
					</div>		
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
					</div>
				</form>
			</div>
		</c:when>		
	</c:choose>

	<script src="../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../static/js/bootstrap.min.js"></script>
</body>
</html>