<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: johnkasper
  Date: 18.02.18
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<h1>Account summary</h1>
<p>You have 123,-</p>

<c:if test="${not empty message}">
    ${message}
</c:if>


<p>${user}</p>

<form:form>
    <div class="form-group">

        <input class="form-control" min="0" placeholder="Amount" name="amount" type="number">
        <input class="form-control cent" value="0" min="0" max="99" name="amountCent" type="number">
        <input hidden value="true" name="deposit">
        <button type="submit" class="btn btn-success">Deposit</button>
    </div>
</form:form>


<form:form>
    <div class="form-group">
        <input class="form-control" min="0" placeholder="Amount" name="amount" type="number">
        <input class="form-control cent" value="0" min="0" max="99" name="amountCent" type="number">
        <input hidden value="false" name="deposit">
        <button type="submit" class="btn btn-success">Withdraw</button>
    </div>
</form:form>

</body>
</html>
