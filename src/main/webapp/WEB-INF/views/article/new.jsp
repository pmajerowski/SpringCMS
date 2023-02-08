<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>New article</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
<form:form method="post" action="/article/save" modelAttribute="article">
  <%--        <p>--%>
  <%--            <form:errors path="*"/>--%>
  <%--        </p>--%>
  <h3>Add a new article</h3>
  <p>
    <form:label path="title">Title</form:label><br>
    <form:input path="title"/><br>
    <form:errors path="title" cssClass="error"/>
  </p>
  <p>
    <form:label path="">Category</form:label><br>
    <form:select itemValue="id" itemLabel="name" path="categories" items="${categories}" multiple="true"/><br>
    <form:errors path="categories" cssClass="error"/>
  </p>
  <p>
    <form:label path="author">Author</form:label><br>
    <form:select itemValue="id" itemLabel="name" path="author" items="${authors}" /><br>
    <form:errors path="author" cssClass="error"/>
  </p>
  <p>
    <form:label path="content">Content</form:label><br>
    <form:textarea path="content"/><br>
    <form:errors path="content" cssClass="error"/>
  </p>
  <p>
    <input type="submit" class="btn">
  </p>
</form:form>
</body>
</html>