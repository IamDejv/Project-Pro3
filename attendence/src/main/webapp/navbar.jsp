<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vystoupení</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
</head>
<body>
<div class="vertical-nav bg-white" userid="sidebar">
    <div class="py-4 px-3 mb-4 bg-light">
        <img src="${pageContext.request.contextPath}/logo.png" alt="Logo" class="logo">
    </div>

    <p class="text-gray font-weight-bold text-uppercase px-3 small pb-4 mb-0">Main</p>

    <ul class="nav flex-column bg-white mb-0">
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/" class="nav-link text-dark bg-light">
                Home
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/dochazka" class="nav-link text-dark">
                Docházka
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/vystoupeni" class="nav-link text-dark">
                Vystoupení
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/registrace" class="nav-link text-dark">
                Registrace
            </a>
        </li>
    </ul>
</div>

</body>
</html>

