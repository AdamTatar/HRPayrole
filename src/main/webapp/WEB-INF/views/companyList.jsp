<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>

	<div class="container">
	  <h2>Dane firmy</h2>
	  <table class="table table-hover">
	   
	      <tr>
	      	<td>Nazwa:</td>
			<td>${company.companyName}</td>
		  </tr>
	      <tr>
		  	<td>NIP:</td>
			<td>${company.companyNip}</td>
		  </tr>
	      <tr>
		  	<td>REGON:</td>
			<td>${company.companyRegon}</td>
		  </tr>
	      <tr>
		  	<td>Adres:</td>
			<td>${company.companyAddress1}</td>
		  </tr>
	      <tr>
		  	<td>Adres:</td>
			<td>${company.companyAddress2}</td>
		  </tr>
	      <tr>
		  	<td>Miasto:</td>
			<td>${company.city.name}</td>
	      <tr>
		  	<td>Państwo:</td>
			<td>${company.country.name}</td>
		  </tr>
	      <tr>
		  	<td>Telefon:</td>
			<td>${company.companyPhone}</td>
		  </tr>
	      <tr>
		  	<td>Fax:</td>
			<td>${company.companyFax}</td>
		  </tr>
	      <tr>
		  	<td>Numer konta:</td>
			<td>${company.companyBankAccountNumber}</td>
		  </tr>
		 
	  </table>
	  <input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
	</div>

	
<%@include  file="footer.jsp" %>	