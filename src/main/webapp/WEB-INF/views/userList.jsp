<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>


<div class="container">
	  <h2>Użytkownicy</h2>
	  <table class="table table-hover">
	   
	    <thead>
	      <tr>
	        <th>Nick</th>
	        <th>Email</th>
	        <th>Rola</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    <c:forEach items="${users}" var="user">
		  <tr>
			<td>${user.nick}</td>
			<td><a href="mailto:${user.email}">${user.email}</a></td>
			<td>${user.role}</td>
		  </tr>
		</c:forEach>
	    
	    </tbody>
	  </table>
	  <input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
	</div>
<%@include  file="footer.jsp" %>