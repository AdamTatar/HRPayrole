<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>
	 
	 	<h2>Dodaj użytkownika</h2>
	 <form:form method="post" modelAttribute="user">
	 <form:errors path="*" element="div"/>
	 
	 	<div class="form-group">
	 		<label for="nick">Nick:</label>
	 		<form:input path="nick" autofocus="true" class="form-control" id="nick" required="true"/>
    	</div>

	 	<div class="form-group">
	 		<label for="email">Email:</label>
	 		<form:input type="email" path="email" class="form-control" id="email" required="true"/>
    	</div>

	 	<div class="form-group">
	 		<label for="pass">Hasło:</label>
	 		<form:input type="password" path="password" class="form-control" id="pass" required="true"/>
    	</div>

	 	<div class="form-group">
	 		<label for="role">Rola:</label>
	 		<form:input list="listaRol" path="role" class="form-control" id="role" required="true"/>
			<datalist id="listaRol">
			  <option value="Użytkownik">
			  <option value="Administrator">
			</datalist> 
    	</div>
	 	
	 	<input type="submit" value="Dodaj" class="btn btn-success">
		<input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
		
	</form:form> 
	 
<%@include  file="footer.jsp" %>	