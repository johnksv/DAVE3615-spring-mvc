<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
</head>
<body>

<jsp:include page="menu.jsp"/>
<div class="container-fluid">
    <h2>Welcome</h2>
    <p>This is assignment 2 in DAVE3615 Software Architecture and Frameworks</p>

    <p>User information for login:</p>
    <p>
        Username: olanor
        <br>
        Password: hello
    </p>
    <p>
        Username: kari
        <br>
        Password: mySecretPassword1
    </p>
    <br>

    <hr>
    <p>toString of all users (for debug purposes):</p>

    <c:forEach items="${user}" var="item">
        <p>${item}</p>
    </c:forEach>

</div>
<script>
    document.getElementsByClassName("navbar-nav")[0].children[0].className = "active";
</script>
</body>
</html>
