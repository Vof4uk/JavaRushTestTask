<%--
  Created by IntelliJ IDEA.
  User: Микитенко
  Date: 14.08.2016
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="false"%>
<html>
<head>
    <title>Search user by name</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/adduser.css" />">
</head>
<!DOCTYPE html>
<body bgcolor="#dcdcdc">

<div class="div">
    <form:form method="get" commandName="user"
               action="search_results">
    <a href="<c:url value="/"/>" target="_self">
        <img src="<c:url value="/resources/img/home.png"/>" width="40px" height="20px" border="0" alt="Logo"></a>
    <fieldset>
        <label>Search users by name:</label>
        <input type="search" name="username" value="...">
    </fieldset>

    <footer>
        <input type="submit" value="Search">
    </footer>
</div>
</form:form>

</body>
</html>
