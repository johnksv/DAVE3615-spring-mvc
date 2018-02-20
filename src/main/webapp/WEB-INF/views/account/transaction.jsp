<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../menu.jsp" />
<div class="container-fluid">

    <h3>${title}</h3>
    <div class="row">
        <form:form cssClass="col-md-6">
            <div class="form-group">
                <label for="amount">Amount</label>
                <input class="form-control" value="0" min="0" placeholder="Amount" id="amount" name="amount"  pattern="[0-9]+([\.,][0-9]+)?" step="0.01" type="number">
            </div>
            <input hidden name="accountId" value="${accountID}"/>
            <button type="submit" class="btn btn-success">${title}</button>
        </form:form>
    </div>
</div>
<script>
    document.getElementsByClassName("navbar-nav")[0].children[1].className = "active";
</script>
</body>
</html>
