<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">


    <div class="row">
        <form:form cssClass="col-md-6">
            <div class="form-group">
                <label for="amount">Amount</label>
                <input class="form-control" min="0" placeholder="Amount" id="amount" name="amount" type="number">
            </div>
            <div class="form-group">
                <label for="cent">Cent</label>
                <input class="form-control cent" value="0" min="0" max="99" id="cent" name="amountCent" type="number">
            </div>
            <button type="submit" class="btn btn-success">Deposit</button>
        </form:form>
    </div>
</div>
</body>
</html>
