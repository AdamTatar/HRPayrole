<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>
	
	
	<div class="container">
	  <h2>Lista płac pracowników</h2>
	  <table class="table table-hover">
	   
	    <thead>
	      <tr>
	        <th>Imię</th>
	        <th>Nazwisko</th>
	        <th>Nr konta</th>
	        <th>Wypłata</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    <c:forEach items="${employees}" var="emp">
		  <tr>
			<td>${emp.firstName}</td>
			<td>${emp.lastName}</td>
			<td>${emp.bankAccountNumber}</td>
			<td>${emp.salary}</td>
			<td>
			
			</td>
		  </tr>
		</c:forEach>
	    </tbody>
	  </table>
	  
		 <form:form method="post" modelAttribute="employees">
		 	<div class="form-group"></div>
	    	
			<input type="submit" value="Eksportuj do xml" class="btn btn-success">
			<input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
			
		</form:form> 
	  
	  
	  
	</div>
	
	

<%@include  file="footer.jsp" %>