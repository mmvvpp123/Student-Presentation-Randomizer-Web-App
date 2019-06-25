<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%--
  Created by IntelliJ IDEA.
  User: mmvvpp123
  Date: 6/25/19
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>

    <c:forEach begin="0" end="${numberOfStudents}" var="i">
        <c:out value="${timeSlots[i]} ${students[i]}"/> <br>
    </c:forEach>
<%--    <c:forEach items="${students}" var="element">--%>
<%--        ${element} <br/>--%>
<%--    </c:forEach>--%>
</body>
</html>
