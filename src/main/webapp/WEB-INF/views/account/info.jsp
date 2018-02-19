<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
</head>
<body>
<h2>Welcome ${user.firstName}.</h2>

<c:choose>
    <c:when test="${empty account}">
        <p>You have no accounts registered at the moment</p>
    </c:when>
    <c:otherwise>
        <c:forEach items="${account}" var="item">
            <h3>${item.name}</h3>
            <p>Current balance is</p>
            <span>${item.amount}</span>
        </c:forEach>
    </c:otherwise>
</c:choose>
<a class="btn btn-primary" href="./account/new">Make new account</a>

<h3>Loans</h3>

<c:choose>
    <c:when test="${empty loan}">
        <p>You have no loans.</p>
    </c:when>
    <c:otherwise>
        <c:forEach items="${loan}" var="item">
            <p>Loan info:</p>
        </c:forEach>
    </c:otherwise>
</c:choose>
<a class="btn btn-primary" href="./loan">See all loans</a>


<h3>Options</h3>

<h4>Deposit</h4>
<form:form>
    <div class="form-group">

        <label for="amount">Amount</label>
        <input class="form-control" min="0" placeholder="Amount" id="amount" name="amount" type="number">
        <label for="cent">Cent</label>
        <input class="form-control cent" value="0" min="0" max="99" id="cent" name="amountCent" type="number">
        <input hidden value="true" name="deposit">
        <button type="submit" class="btn btn-success">Deposit</button>
    </div>
</form:form>


<h4>Withdraw</h4>
<form:form>
    <div class="form-group">
        <label for="amountWith">Amount</label>
        <input class="form-control" min="0" placeholder="Amount" id="amountWith" name="amount" type="number">
        <label for="centWith">Cent</label>
        <input class="form-control cent" value="0" min="0" max="99" id="centWith" name="amountCent" type="number">
        <input hidden value="false" name="withdraw">
        <button type="submit" class="btn btn-success">Withdraw</button>
    </div>
</form:form>

</body>
</html>
