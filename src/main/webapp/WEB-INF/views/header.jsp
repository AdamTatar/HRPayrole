<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@	page errorPage="error.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="bootstrap.css">
	<meta charset="UTF-8">
	<title>HRPayrole</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>

	/* Remove the navbar's default margin-bottom and rounded borders */
	.navbar {
		margin-bottom: 0;
		border-radius: 0;
	}
	
	/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
	.row.content {
		height: 917px;
		
	}
	
	/* Set gray background color and 100% height */
	.sidenav {
		padding-top: 20px;
		background-color: #f1f1f1;
		height: 100%;
	}
	
	/* Set black background color, white text and some padding */
	footer {
		background-color: #555;
		color: white;
		padding: 15px;
	}
	
	/* On small screens, set height to 'auto' for sidenav and grid */
	@media screen and (max-width: 767px) {
		.sidenav {
			height: auto;
			padding: 15px;
		}
		.row.content {
			height: auto;
		}
	}
	</style>
	
	</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/HRPayrole/">Kadry
				i płace</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/HRPayrole/">Strona
						główna</a></li>
				<li><a href="/HRPayrole/about">O
						stronie</a></li>
				<li><a href="/HRPayrole/info">Aplikacja
						- informacje</a></li>
				<li><a href="/HRPayrole/contact">Kontakt</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/HRPayrole/login"><span
						class="glyphicon glyphicon-log-in"></span> Zaloguj się</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<a href="/HRPayrole/country/add"><div
						class="well">
						<p>Dodaj kraj</p>
					</div></a> <a href="/HRPayrole/city/add"><div
						class="well">
						<p>Dodaj miasto</p>
					</div></a> <a href="/HRPayrole/company/add"><div
						class="well">
						<p>Dodaj firmę</p>
					</div></a> <a href="/HRPayrole/employee/add"><div
						class="well">
						<p>Dodaj pracownika</p>
					</div></a> <a href="/HRPayrole/department/add">
					<div class="well">
						<p>Dodaj departament</p>
					</div>
				</a>
				
				<a href="/HRPayrole/user/add">
					<div class="well">
						<p>Dodaj użytkownika</p>
					</div>
				</a>

				<a href="/HRPayrole/taxOffice/add">
					<div class="well">
						<p>Dodaj US</p>
					</div>
				</a>

			</div>
			<div class="col-sm-8 text-left">