<%--
  Created by IntelliJ IDEA.
  User: przemek
  Date: 07/02/2023
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
  <div style="margin-block-end: fill; size: auto; border: darkgreen">
    <h3>Are you sure you want to delete this article?</h3>
    <h4>This is irreversible.</h4>
    <a href="/article/delete/${id}" class="btn">DELETE</a>
    <a href="/article/list" class="btn">CANCEL</a>

  </div>

</body>
</html>
