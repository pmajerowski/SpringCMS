<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Category list</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
<h3>Categories</h3>
<table style=" border-spacing: 8px">
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Description</th>
  </tr>
  </thead>
  <c:forEach items="${categories}" var="category">
    <tr>
      <td>${category.id}</td>
      <td><c:out value="${category.name}"/></td>
      <td><c:out value="${category.description}"/></td>

      <td><a href="/category/edit/${category.id}" class="btn">edit</a></td>
      <td><a href="/category/confirm/${category.id}" class="btn">delete</a></td>
    </tr>
  </c:forEach>

</table>
  <p>
    <a href="/category/new" class="btn">add new category</a>
    <a href="/" class="btn">home page</a>

  </p>
</body>
</html>