<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New account</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
</head>
<body>
<h1>New account</h1>
<form:form>
    <label for="name">Account name</label>
    <input class="form-control" id="name" type="text" name="name"/>
    <button type="submit" class="btn btn-success">Make account</button>
</form:form>
</body>
</html>
