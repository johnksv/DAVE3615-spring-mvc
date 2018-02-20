<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loan</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <h1>Apply for a loan</h1>
    <p>We offer 2 different loans. It is also possible to apply for a custom loan.</p>

    <div class="row">


        <c:forEach items="${loans}" var="item">
            <div class="panel panel-default col-md-4">
                <div class="panel-header">
                    <h4>${item.type.toString()}</h4>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Amount: ${item.amount}</li>
                    <li class="list-group-item">Rent: ${item.rent} %</li>
                    <li class="list-group-item">Payoff time: ${item.payoffTimeMonths}
                        months
                    </li>
                </ul>

                    <form:form>
                        <input hidden name="loanId" value="${item.id}"/>
                        <button type="submit" class="btn btn-success">Apply</button>
                    </form:form>

            </div>
        </c:forEach>


        <div class="panel panel-default col-md-4">
            <div class="panel-header">
                <h4>Apply for a custom loan</h4>
            </div>
            <form:form action="./loan/custom" method="post" modelAttribute="loan">
                <div class="form-group">
                    <label for="amount">Amount:</label>
                    <input class="form-control" min="0" max="100000000" placeholder="Amount" id="amount" name="amount"
                           type="number">
                </div>
                <div class="form-group">
                    <label for="type">Type:</label>
                    <select name="type" title="type" id="type">
                        <c:forEach items="${loanTypes}" var="item">
                            <option value="${item}">${item.toString()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="payoff">Payoff time (months):</label>
                    <input class="form-control" min="0" placeholder="Payoff time" id="payoff" name="payoffTimeMonths"
                           type="number">
                </div>
                <div class="form-group">
                    <label for="rent">Rent</label>
                    <input class="form-control" value="15.5%" id="rent" readonly>
                </div>
                <button type="submit" class="btn btn-success">Apply</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
