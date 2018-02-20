<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New account</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../menu.jsp" />
<div class="container-fluid">
    <h1>New account</h1>
    <form:form>
        <div class="form-group">
            <label for="name">Account name</label>
            <input class="form-control" id="name" type="text" name="name" pattern="[a-zA-ZæøåÆØÅ]+\s*[a-zA-ZæøåÆØÅ]*"/>
        </div>
        <c:if test="${not empty formInfo}">
            ${formInfo}
            <br>
        </c:if>
        <button type="submit" class="btn btn-success">Make account</button>
    </form:form>
</div>
<script>
    document.getElementsByClassName("navbar-nav")[0].children[1].className = "active";
</script>
</body>
</html>
