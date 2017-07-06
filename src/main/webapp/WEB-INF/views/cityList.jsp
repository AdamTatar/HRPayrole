<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>
	
	
	<div class="container">
	  <h2>Miasta</h2>
	  <table class="table table-hover">
	   
	    <thead>
	      <tr>
	        <th>Miasto</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    <c:forEach items="${cities}" var="city">
		  <tr>
			<td>${city.name}</td>
		  </tr>
		</c:forEach>
	    
	    </tbody>
	  </table>
	</div>
	
<%@include  file="footer.jsp" %>	