<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Article list</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
<h3>Articles</h3>
<table style=" border-spacing: 8px">
  <thead>
  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Author</th>
    <th>Categories</th>
    <th>Content</th>

  </tr>
  </thead>
  <c:forEach items="${articles}" var="article">
    <tr>
      <td>${article.id}</td>
      <td><c:out value="${article.title}"/></td>
      <td><c:out value="${article.author}"/></td>
      <td><c:forEach var="cat" items="${article.categories}">
        ${cat.name}<br>
      </c:forEach></td>
      <td><c:out value="${article.content}"/></td>

      <td><a href="/article/edit/${article.id}" class="btn">edit</a></td>
      <td><a href="/article/confirm/${article.id}" class="btn">delete</a></td>
    </tr>
  </c:forEach>

</table>
  <p>
    <a href="/article/new" class="btn">add new article</a>
    <a href="/" class="btn">home page</a>

  </p>
</body>
</html>