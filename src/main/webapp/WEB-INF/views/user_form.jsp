<%--
  Created by IntelliJ IDEA.
  User: Микитенко
  Date: 12.08.2016
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Form ${form} User</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/adduser.css" />">
</head>
<body bgcolor="#dcdcdc">
<div class="div">
    <form:form method="post" commandName="user" action="${action}">
        You are about to ${form} user.<br>
        <a href="<c:url value="/"/>" target="_self">
            <img src="<c:url value="/resources/img/home.png"/>" width="40px" height="20px" border="0"
                 alt="Logo"></a>
        <fieldset>
            <form:label path="username">Username:</form:label>
            <form:input path="username"/>
        </fieldset>
        <fieldset>
            <form:label path="age">Age:</form:label>
            <form:input path="age"/>
        </fieldset>

        <footer>
            <form:label path="admin">Admin:</form:label>
            <form:checkbox path="admin" />
            <input type="submit" value="${action} user">
        </footer>

        <form:hidden path="userID"/>
    </form:form>
</div>
</body>
</html>
