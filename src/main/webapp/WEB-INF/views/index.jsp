<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <h2>Welcome</h2>
    <p>This is assignment 2 in DAVE3615 Software Architecture and Frameworks</p>

    <p>User information for login:</p>
    <p>
        Username: user
        <br>
        Password: hello
    </p>

    <a class="btn btn-primary" href="./login">Log in</a>

    <p>toString of all users (for debug purposes):</p>
    <p>${user}</p>

</div>
</body>
</html>
