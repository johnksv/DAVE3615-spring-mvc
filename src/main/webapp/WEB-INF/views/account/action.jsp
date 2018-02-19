<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form>
    <div class="form-group">

        <label for="amount">Amount</label>
        <input class="form-control" min="0" placeholder="Amount" id="amount" name="amount" type="number">
        <label for="cent">Cent</label>
        <input class="form-control cent" value="0" min="0" max="99" id="cent" name="amountCent" type="number">
        <button type="submit" class="btn btn-success">Deposit</button>
    </div>
</form:form>

</body>
</html>
