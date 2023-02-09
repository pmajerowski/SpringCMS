<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: przemek
  Date: 09/02/2023
  Time: 07:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${author.name}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
    <h2>${author.name}</h2>
    <table style=" border-spacing: 8px">
        <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Categories</th>
            <%--    <th>Content</th>--%>
        </tr>
        </thead>
        <c:forEach items="${author.articles}" var="article">
            <tr>
                <td>${article.id}</td>
                <td><c:out value="${article.title}" /></td>
                <td><c:forEach var="cat" items="${article.categories}">
                    ${cat.name}<br>
                </c:forEach></td>
                    <%--      <td><c:out value="${article.content}"/></td>--%>

                <td><a href="/article/${article.id}" class="btn">read</a></td>
                <td><a href="/article/edit/${article.id}" class="btn">edit</a></td>
                <td><a href="/article/confirm/${article.id}" class="btn">delete</a></td>
            </tr>
        </c:forEach>

    </table>
    <p><a href="/" class="btn">home page</a></p>
</body>
</html>
