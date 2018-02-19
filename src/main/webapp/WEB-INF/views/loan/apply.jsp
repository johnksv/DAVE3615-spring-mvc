<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loan</title>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"/>
</head>
<body>
    <h1>Apply for a loan</h1>
    <p>We offer 2 different loans. It is also possible to apply for a custom loan.</p>

    <form:form>
        <input hidden name="loan" value="mortgage"/>
        <button type="submit" class="btn btn-success">Apply</button>
    </form:form>

    <form:form>
        <input hidden name="loan" value="student"/>
        <button type="submit" class="btn btn-success">Apply</button>
    </form:form>

    <form:form method="post"  modelAttribute="loan">
        <input class="form-control" min="0" max="100000000" placeholder="Amount" name="amount" type="number">
        <select name="type" title="type">
            <c:forEach items="${loanTypes}" var="item">
                <option value="${item}">${item.toString()}</option>
            </c:forEach>
        </select>
        <input class="form-control" min="0" placeholder="Payoff time" name="payoffTimeMonths" type="number">
        <button type="submit" class="btn btn-success">Apply</button>
    </form:form>

</body>
</html>
