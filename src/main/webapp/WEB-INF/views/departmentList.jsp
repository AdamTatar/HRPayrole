<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include  file="header.jsp" %>


<div class="container">
	  <h2>Departamenty</h2>
	  <table class="table table-hover">
	   
	    <thead>
	      <tr>
	        <th>Departament</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    <c:forEach items="${departments}" var="dept">
		  <tr>
			<td>${dept.name}</td>
		  </tr>
		</c:forEach>
	    
	    </tbody>
	  </table>
	  <input type="button" value="Cofnij" onClick="history.go(-1);return true;" class="btn">
	</div>
<%@include  file="footer.jsp" %>