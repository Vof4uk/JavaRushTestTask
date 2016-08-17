<%--
  Created by IntelliJ IDEA.
  User: Микитенко
  Date: 14.08.2016
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/adduser.css" />">
</head>
<body bgcolor="#32cd32">

<form:form>
    <fieldset>
        <h3>
            Error.
        </h3>
        If you see this message you must have submitted incorrect information. <br>
        - Username must be unique and consist of 4 - 25 symbol.
    </fieldset>
</form:form>

<a href="<c:url value="/"/>" target="_self">
    <img src="<c:url value="/resources/img/home.png"/>" width="40px" height="20px" border="0" alt="Logo"></a>
</body>
</html>
