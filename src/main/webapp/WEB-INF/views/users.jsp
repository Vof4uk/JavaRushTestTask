<%--
  Created by IntelliJ IDEA.
  User: Микитенко
  Date: 12.08.2016
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/users.css" />">
</head>
<body bgcolor="#dcdcdc">
<h3 style="alignment: center">${title}(page ${page})</h3>
<h3 style="alignment: center">
    <a href="<c:url value="/${request}?page=${page - 1}&sort_by=${sort_by}&order=${order}${request == 'search_results' ? '&username=' : ''}${request == 'search_results' ? username : ''}"/>">
        <img src="<c:url value="/resources/img/arrow_prev.png"/>" width="40px" height="20px" border="0"
             alt="Logo">
    </a>

    <a href="<c:url value="/${request}?page=${page + 1}&sort_by=${sort_by}&order=${order}${request == 'search_results' ? '&username=' : ''}${request == 'search_results' ? username : ''}"/>">
        <img src="<c:url value="/resources/img/arrow_next.png"/>" width="40px" height="20px" border="0"
             alt="Logo">
    </a>
</h3>
<form method="get" action="search_results">
    <input type="search" value="type username to search" name="username" width="300">
    <input type="submit" value="search">

</form>

<table border="1" bgcolor="white">
    <tr>
        <th>
            <a href="<c:url value="/${request}?page=1&sort_by=id&order=${order == 'asc' ? 'desc':'asc'}${request == 'search_results' ? '&username=' : ''}${request == 'search_results' ? username : ''}"/>">ID</a>
        </th>
        <th>
            <a href="<c:url value="/${request}?page=1&sort_by=username&order=${order == 'asc' ? 'desc':'asc'}${request == 'search_results' ? '&username=' : ''}${request == 'search_results' ? username : ''}"/>">Username</a>
        </th>
        <th>
            <a href="<c:url value="/${request}?page=1&sort_by=age&order=${order == 'asc' ? 'desc':'asc'}${request == 'search_results' ? '&username=' : ''}${request == 'search_results' ? username : ''}"/>">Age</a>
        </th>
        <th>
            <a href="<c:url value="/${request}?page=1&sort_by=date&order=${order == 'asc' ? 'desc':'asc'}${request == 'search_results' ? '&username=' : ''}${request == 'search_results' ? username : ''}"/>">Date
                created</a></th>
        <th>
            <a href="<c:url value="/${request}?page=1&sort_by=admin&order=${order == 'asc' ? 'desc':'asc'}${request == 'search_results' ? '&username=' : ''}${request == 'search_results' ? username : ''}"/>">Admin</a>
        </th>
        <th></th>
        <th><a href="<c:url value="/"/>" target="_self">
            <img src="<c:url value="/resources/img/home.png"/>" width="40px" height="20px" border="0"
                 alt="Logo"></a></th>
    </tr>
    <c:forEach items="${user_list}" var="user">
        <tr>
            <td width="5%">${user.userID}</td>
            <td width="30%">${user.username}</td>
            <td width="5%">${user.age}</td>
            <td width="30%">${user.creationDate}</td>
            <td width="5%"><c:if test="${user.admin=='true'}">yes</c:if></td>
            <td width="10%">
                <a href="<c:url value="/update?user_ID=${user.userID}"/>" target="_self">
                    <img src="<c:url value="/resources/img/update.jpg"/>" width="50px" height="30px" border="0"
                         alt="Logo"></a>
            </td>
            <td width="10%">
                <a href="<c:url value="/delete?user_ID=${user.userID}"/>" target="_self">
                    <img src="<c:url value="/resources/img/delete.png"/>" width="50px" height="30px" border="0"
                         alt="Logo"></a>
            </td>
        </tr>

    </c:forEach>
    <tr>
        <td><a href="<c:url value="/new"/>" target="_self">
            <img src="<c:url value="/resources/img/plus.png"/>" width="20px" height="20px" border="0"
                 alt="Logo"></a>
        </td>
    </tr>

</table>


</body>
</html>
