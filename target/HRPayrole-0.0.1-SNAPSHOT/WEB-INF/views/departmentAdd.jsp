<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>
	
	<h2>Dodaj departament</h2>
	 <form:form method="post" modelAttribute="department">
	 <form:errors path="*" element="div"/>
	 
	 	<div class="form-group">
	 		<label for="name">Departament:</label>
	 		<form:input path="name" autofocus="true" class="form-control" id="usr"/>
    	</div>
    	
    	<div class="form-group">
      		<label for="sel1">Wybierz miasto:</label>
     		 <form:select path="city.id" items="${cities}" itemLabel="name" itemValue="id" class="form-control" id="sel1"/>
	    </div>
    	
		<input type="submit" value="Dodaj" class="btn btn-success">
		<input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
		
	</form:form> 
	
<%@include  file="footer.jsp" %>




