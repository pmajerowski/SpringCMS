<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Category list</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
<h3>Authors</h3>
<table style=" border-spacing: 8px">
  <thead>
  <tr>
    <th>Id</th>
    <th>Firstname</th>
    <th>Lastname</th>
  </tr>
  </thead>
  <c:forEach items="${authors}" var="author">
    <tr>
      <td>${author.id}</td>
      <td><c:out value="${author.firstName}"/></td>
      <td><c:out value="${author.lastName}"/></td>

      <td><a href="/author/${author.id}" class="btn">about author</a></td>
      <td><a href="/author/edit/${author.id}" class="btn">edit</a></td>
      <td><a href="/author/confirm/${author.id}" class="btn">delete</a></td>

    </tr>
  </c:forEach>

</table>
  <p>
    <a href="/author/new" class="btn">add new author</a>
    <a href="/" class="btn">home page</a>

  </p>
</body>
</html>