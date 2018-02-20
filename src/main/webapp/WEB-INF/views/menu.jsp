<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sec:authorize url="${pageContext.request.contextPath}/account" var="isLoggedIn"/>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Bank-Asgmt2</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/">Welcome</a></li>
    <c:choose>
        <c:when test="${isLoggedIn}">
            <li><a href="${pageContext.request.contextPath}/account">Account</a></li>
            <li><a href="${pageContext.request.contextPath}/loan">Loan</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </c:when>
        <c:otherwise>
            <li>
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </li>
        </c:otherwise>
    </c:choose>
        </ul>
    </div>
</nav>