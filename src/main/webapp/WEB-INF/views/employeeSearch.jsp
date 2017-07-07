<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>
	 
	 	<h2>Wyszukaj pracowników</h2>
	 <form:form method="post" modelAttribute="employee">
	 <form:errors path="*" element="div"/>
	 
	 	<div class="form-group">
	 		<label for="name">Imię:</label>
	 		<form:input path="firstName" class="form-control" id="name"/>
    	</div>

	 	<div class="form-group">
	 		<label for="lastname">Nazwisko:</label>
	 		<form:input path="lastName" autofocus="true" class="form-control" id="lastname"/>
    	</div>

	 	<div class="form-group">
	 		<label for="pesel">PESEL:</label>
	 		<form:input type="number" path="pesel" class="form-control" id="pesel"/>
    	</div>

	 	<div class="form-group">
	 		<label for="salary">Pensja podstawowa większa niż:</label>
	 		<form:input path="salary" class="form-control" id="salary"/>
    	</div>

	 	<div class="form-group">
	 		<label for="bonus">Premia stała większa niż:</label>
	 		<form:input path="bonus" class="form-control" id="bonus"/>
    	</div>

		<div class="form-group">
	 		<label for="empDate">Data zatrudnienia większa niż:</label>
	 		<form:input type="date" path="dateOfEmployment" class="form-control" id="empDate"/>
    	</div>

    
		<input type="submit" value="Szukaj" class="btn btn-success">
		<input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
		
	</form:form> 
	 <p></p>
	 

<%@include  file="footer.jsp" %>	