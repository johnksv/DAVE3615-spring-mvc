<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <h2>Welcome ${user.firstName}.</h2>

    <c:choose>
        <c:when test="${empty account}">
            <p>You have no accounts registered at the moment</p>
        </c:when>
        <c:otherwise>
            <c:forEach items="${account}" var="item">
                <div class="panel panel-default">
                    <div class="panel-heading"><h4>Account: ${item.name}</h4></div>
                    <div class="panel-body">
                        <p>Current balance is</p>
                        <span>${item.amount}</span>

                        <br>
                    </div>
                    <div class="panel-footer">
                        <a class="btn btn-primary btn-md"
                           href="./account/transaction?type=deposit&accountId=${item.id}">Deposit</a>
                        <a class="btn btn-primary btn-md"
                           href="./account/transaction?type=withdraw&accountId=${item.id}">Withdraw</a>
                    </div>

                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    <div class="row">
        <div class="col-md-12">
            <a class="btn btn-primary" href="./account/new">Make new account</a>
        </div>
    </div>

    <h3>Loans</h3>

    <c:choose>
        <c:when test="${empty loan}">
            <p>You have no loans.</p>
        </c:when>
        <c:otherwise>
            <c:forEach items="${loan}" var="item">
                <div class="panel panel-default">
                    <div class="panel-heading"><b>Loan of type: ${item.type}</b></div>
                    <div class="panel-body">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Amount: ${item.amount}</li>
                            <li class="list-group-item">Payed amount: ${item.payedAmount}</li>
                            <li class="list-group-item">Remaining Amount: ${item.amount - item.payedAmount}</li>
                            <li class="list-group-item">Rent: ${item.rent} %</li>
                            <li class="list-group-item">Payoff time: ${item.payoffTimeMonths} months
                            </li>
                            <li class="list-group-item">Start: ${item.start.toString()}</li>
                        </ul>
                    </div>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    <div class="row">
        <div class="col-md-12">
            <a class="btn btn-primary" href="./loan">See all loans</a>
        </div>
    </div>
</div>
</body>
</html>
