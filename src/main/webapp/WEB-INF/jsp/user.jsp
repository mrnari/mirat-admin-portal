<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Add New Employee</h3>

	<div id="addEmployee">
		<form:form action="/admin/addNewUser" method="post"
			modelAttribute="user">
			<p>
				<label>Name</label>
				<form:input path="name" />
			</p>
			<p>
				<label>Mail</label>
				<form:input path="email" />
			</p>
				<p>
				<label>Password</label>
				<form:input path="password" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>
