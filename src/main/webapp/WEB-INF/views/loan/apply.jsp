<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loan</title>
</head>
<body>
    <h1>Apply for a loan</h1>

    <form method="post" action="./">
        <input class="form-control" min="0" max="100000000" placeholder="Amount" name="amount" type="number">
        <select>
            <c:forEach items="${loanTypes}" var="item">
                <option value="${item}">${item.toString()}</option>
            </c:forEach>
        </select>
        <input class="form-control" min="0" placeholder="Start date" name="start_date" type="date">
        <input class="form-control" min="0" placeholder="Payoff time" name="payoff_time" type="number">
        <button type="submit" class="btn btn-success">Apply</button>
    </form>

</body>
</html>