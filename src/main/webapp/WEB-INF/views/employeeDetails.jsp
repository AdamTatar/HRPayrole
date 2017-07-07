<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>

	<div class="container">
	  <h2>Dane pracownika:</h2>
	  <table class="table table-hover">
	   
	       <tr>
	      	<td>Imię:</td>
			<td>${employee.firstName}</td>
		  </tr>
	      <tr>
		  	<td>Drugie imię:</td>
			<td>${employee.secondName}</td>
		  </tr>
	      <tr>
		  	<td>Nazwisko:</td>
			<td>${employee.lastName}</td>
		  </tr>
	      <tr>
		  	<td>PESEL:</td>
			<td>${employee.pesel}</td>
		  </tr>
		  <tr>
		  	<td>Data urodzenia:</td>
			<td>${employee.birthDate}</td>
		  </tr>
	      <tr>
		  	<td>Miejsce urodzenia:</td>
			<td>${employee.birthPlace.name}</td>
	      </tr>
	      <tr>
		  	<td>Pensja podstawowa:</td>
			<td>${employee.salary}</td>
	      </tr>
	      <tr>
		  	<td>Premia stała:</td>
			<td>${employee.bonus}</td>
	      </tr>
	      <tr>
		  	<td>Departament:</td>
			<td>${employee.department.name}</td>
	      </tr>
   		  <tr>
		  	<td>Data zatrudnienia:</td>
			<td>${employee.dateOfEmployment}</td>
		  </tr>
	      <tr>
		  	<td>Email:</td>
			<td><a href="mailto:${employee.email}">${employee.email}</a></td>
		  </tr>
	      <tr>
		  	<td>Telefon:</td>
			<td>${employee.phoneNumber}</td>
		  </tr>
	      <tr>
		  	<td>Numer konta:</td>
			<td>${employee.bankAccountNumber}</td>
		  </tr>
	  </table>
	  <input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
	</div>

<%@include  file="footer.jsp" %>	