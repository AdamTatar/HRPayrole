<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>
	
	
	<div class="container">
	  <h2>Pracownicy</h2>
	  <table class="table table-hover">
	   
	    <thead>
	      <tr>
	        <th>Imię</th>
	        <th>Nazwisko</th>
	        <th>PESEL</th>
	        <th>Departament</th>
	        <th>Pensja</th>
	        <th>Premia</th>
	        <th>Edycja</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    <c:forEach items="${employees}" var="emp">
		  <tr>
			<td>${emp.firstName}</td>
			<td>${emp.lastName}</td>
			<td>${emp.pesel}</td>
			<td>${emp.department.name}</td>
			<td>${emp.salary}</td>
			<td>${emp.bonus}</td>
			<td><a href="employee/edit/${emp.id}" class="btn btn-default">Edytuj</a></td>
		  </tr>
		</c:forEach>
	    </tbody>
	  </table>
	  <input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
	</div>
	
	

<%@include  file="footer.jsp" %>