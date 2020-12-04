<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">

	<a href="${pageContext.request.contextPath}/welcome">Home</a> | &nbsp;
    
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    	<a href="${pageContext.request.contextPath}/user/addNewUser">Add User</a>   | &nbsp;
    </sec:authorize>
    
    <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
      <a href="${pageContext.request.contextPath}/user/getUsers">Show Users</a> 
    </sec:authorize>

	<div>
		<h2 style="color: red;">
	     <a onclick="document.forms['logoutForm'].submit()">Logout</a>
		</h2>
	    <form id="logoutForm" method="POST" action="${contextPath}/logout"></form>
	</div>

</div>