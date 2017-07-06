<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>
	 
	 	<h2>Zaloguj się</h2>
	 <form:form method="post" modelAttribute="user">
	 <form:errors path="*" element="div"/>
	 
	 	<div class="form-group">
	 		<label for="nick">Nick:</label>
	 		<form:input path="nick" class="form-control" id="nick" required="true" value="admin"/>
    	</div>

	 	<div class="form-group">
	 		<label for="pass">Hasło:</label>
	 		<form:input type="password" path="password"  autofocus="true" class="form-control" id="pass" />
    	</div>

		<input type="submit" value="Zaloguj" class="btn btn-success">
		
	</form:form> 
	 
	 

<%@include  file="footer.jsp" %>	