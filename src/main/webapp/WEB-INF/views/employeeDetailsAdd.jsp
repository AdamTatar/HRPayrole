<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>
	 
	 	<h2>Dodaj pracownika</h2>
	 <form:form method="post" modelAttribute="employee">
	 <form:errors path="*" element="div"/>
	 
	 	<div class="form-group">
	 		<label for="name">Imię:</label>
	 		<form:input path="firstName" autofocus="true" class="form-control" id="name" required="true"/>
    	</div>

	 	<div class="form-group">
	 		<label for="name2">Drugie imię:</label>
	 		<form:input path="secondName" class="form-control" id="name2" />
    	</div>

	 	<div class="form-group">
	 		<label for="lastname">Nazwisko:</label>
	 		<form:input path="lastName" class="form-control" id="lastname" required="true"/>
    	</div>

	 	<div class="form-group">
	 		<label for="pesel">PESEL:</label>
	 		<form:input type="number" path="pesel" class="form-control" id="pesel" required="true"/>
    	</div>

	 	<div class="form-group">
	 		<label for="bDate">Data urodzenia:</label>
	 		<form:input type="date" path="birthDate" class="form-control" id="bDate"/>
    	</div>

    	<div class="form-group">
      		<label for="sel1">Miasto urodzenia:</label>
     		 <form:select path="birthPlace.id" items="${cities}" itemLabel="name" itemValue="id" class="form-control" id="sel1"/>
	    </div>

	 	<div class="form-group">
	 		<label for="salary">Pensja podstawowa:</label>
	 		<form:input type="number" path="salary" class="form-control" id="salary"/>
    	</div>

	 	<div class="form-group">
	 		<label for="bonus">Premia stała:</label>
	 		<form:input type="number" path="bonus" class="form-control" id="bonus"/>
    	</div>

    	<div class="form-group">
      		<label for="dept">Departament:</label>
     		 <form:select path="department.id" items="${departments}" itemLabel="name" itemValue="id" class="form-control" id="dept"/>
	    </div>




	 	<%-- <div class="form-group">
	 		<label for="adres1">Adres:</label>
	 		<form:input path="companyAddress1" class="form-control" id="adres1"/>
    	</div>

	 	<div class="form-group">
	 		<label for="adres2">Adres:</label>
	 		<form:input path="companyAddress2" class="form-control" id="adres2"/>
    	</div>
    	
 
     	<div class="form-group">
      		<label for="sel1">Państwo:</label>
     		 <form:select path="country.id" items="${countries}" itemLabel="name" itemValue="id" class="form-control" id="sel1"/>
	    </div>
    	
    	
	 	<div class="form-group">
	 		<label for="regon">REGON:</label>
	 		<form:input path="companyRegon" class="form-control" id="regon"/>
    	</div>
    	
	 	<div class="form-group">
	 		<label for="phone">Telefon:</label>
	 		<form:input path="companyPhone" class="form-control" id="phone"/>
    	</div>
    	
	 	<div class="form-group">
	 		<label for="fax">Fax:</label>
	 		<form:input path="companyFax" class="form-control" id="fax"/>
    	</div>
    	
	 	<div class="form-group">
	 		<label for="companyBankAccountNumber">Konto bankowe:</label>
	 		<form:input path="companyBankAccountNumber" class="form-control" id="companyBankAccountNumber"/>
    	</div>
    	 --%>
		<input type="submit" value="Dodaj" class="btn btn-success">
		<input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
		
	</form:form> 
	 
	 

<%@include  file="footer.jsp" %>	