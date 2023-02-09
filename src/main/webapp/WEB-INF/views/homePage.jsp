<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: przemek
  Date: 08/02/2023
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
<h2>HomePage</h2>


<a href="/author/list" class="btn">authors</a>
<a href="/article/list" class="btn">articles</a>
<a href="/category/list" class="btn">categories</a>

<h3>Last added articles</h3>
<table style=" border-spacing: 8px">
  <thead>
  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Author</th>
<%--    <th>Content</th>--%>
    <th>Categories</th>
  </tr>
  </thead>
  <c:forEach items="${articles}" var="article">
    <tr>
      <td>${article.id}</td>
      <td><c:out value="${article.title}"/></td>
      <td><c:out value="${article.author}"/></td>
<%--      <td><c:out value="${article.content}"/></td>--%>
      <td><c:forEach var="cat" items="${article.categories}">
        ${cat.name}<br>
      </c:forEach></td>
      <td>
         <td><a href="/article/${article.id}" class="btn">read</a></td>
      </td>

    </tr>
  </c:forEach>

</table>

</body>
</html>
