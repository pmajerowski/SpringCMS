<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: przemek
  Date: 09/02/2023
  Time: 07:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${article.title}</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
  <h2>${article.title}</h2>
    <c:forEach var="cat" items="${article.categories}">
       <span>${cat.name}</span>
    </c:forEach>

    <c:out value="${article.content}"/>
    <br><br><br>
    <c:out value="${article.author}" />
      <br><br>
    <p>
      <a href="/" class="btn">home page</a>
      <a href="/author/${article.author.id}" class="btn">about author</a>
    </p>
</body>
</html>
