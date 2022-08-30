<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
	<%-- TODO add links to resources --%>
	<link href="/resources/css/test.css" rel="stylesheet"/>
</head>
<body>
<h1>Login Form</h1>
<form:form action="/auth-user" method="post">
	<c:if test="${param.logout != null}">
		<i>You have been logout!</i>
	</c:if>
	<c:if test="${param.error != null}">
		<i>Invalid username or password!</i>
	</c:if>
	<p>
		User name: <input class="form-control" type="text" name="username"/>
	</p>
	<p>
		Password: <input class="form-control" type="password" name="password"/>
	</p>
	<input class="btn btn-primary" type="submit" value="Login"/>
</form:form>
</body>
</html>
