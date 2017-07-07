<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>
	 
	 	<h2>Dodaj pracownika</h2>
	 <form:form method="post" modelAttribute="employee">
	 <form:errors path="*" element="div"/>
	 
	 		<form:input path="firstName" type="hidden"/>
	 		<form:input path="secondName" type="hidden"/>
	 		<form:input path="lastName" type="hidden"/>
	 		<form:input path="pesel" type="hidden"/>
	 		<form:input path="birthDate" type="hidden"/>
	 		<form:input path="salary" type="hidden"/>
	 		<form:input path="bonus" type="hidden"/>
	 		<form:input path="department.id" type="hidden"/>
	 		<form:input path="dateOfEmployment" type="hidden"/>
	 
	 	<div class="form-group">
	 		<label for="adres1">Ulica, nr domu, nr mieszkania:</label>
	 		<form:input path="address1"  autofocus="true" class="form-control" id="adres1"/>
    	</div>

	 	<div class="form-group">
	 		<label for="code">Kod pocztowy:</label>
	 		<form:input path="postalCode" class="form-control" id="code"/>
    	</div>

    	<div class="form-group">
      		<label for="cit">Miasto zamieszkania:</label>
     		 <form:select path="city.id" items="${cities}" itemLabel="name" itemValue="id" class="form-control" id="cit"/>
	    </div>
 
     	<div class="form-group">
      		<label for="sel1">Państwo:</label>
     		 <form:select path="country.id" items="${countries}" itemLabel="name" itemValue="id" class="form-control" id="sel1"/>
	    </div>

    	<div class="form-group">
      		<label for="tax">Urząd skarbowy:</label>
     		 <form:select path="taxOffice.id" items="${taxOffices}" itemLabel="name" itemValue="id" class="form-control" id="tax"/>
	    </div>

	 	<div class="form-group">
	 		<label for="phone">Telefon:</label>
	 		<form:input path="phoneNumber" class="form-control" id="phone"/>
    	</div>
    	
    	<div class="form-group">
	 		<label for="email">Email:</label>
	 		<form:input type="email" path="email" class="form-control" id="email"/>
    	</div>
	  	
	 	<div class="form-group">
	 		<label for="bankAccountNumber">Konto bankowe:</label>
	 		<form:input path="bankAccountNumber" class="form-control" id="bankAccountNumber"/>
    	</div>
    	 
    	 
		<input type="submit" value="Dodaj" class="btn btn-success">
		<input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
		
	</form:form> 
	 <p></p>
	 

<%@include  file="footer.jsp" %>	