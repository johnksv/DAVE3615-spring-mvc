<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loans</title>
</head>
<body>
    <h1>Loans</h1>
<p>We have som great loans. Feel free to apply for any of our loans:</p>

<form:form>
    <form:radiobuttons path="favNumber" items="${loans}"  />
</form:form>

</body>
</html>
