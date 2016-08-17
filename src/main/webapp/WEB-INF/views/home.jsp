<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>CrUD</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/adduser.css" />">
</head>
<body bgcolor="#dcdcdc">
<div>
    <h1>Welcome to
        <br>Users-CrUD</h1>
    <a href="<c:url value="/users" />">All Users</a> |
    <a href="<c:url value="/new" />">Add a new user</a> |
    <a href="<c:url value="/search" />">Search</a>
</div>
</body>
</html>