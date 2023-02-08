<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>New category</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
<form:form method="post" action="/category/save" modelAttribute="category">
  <%--        <p>--%>
  <%--            <form:errors path="*"/>--%>
  <%--        </p>--%>
  <h3>Add a new category</h3>
  <p>
    <form:label path="name">Name</form:label><br>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
  </p>
  <p>
    <form:label path="description">Description</form:label><br>
    <form:textarea path="description"/>
    <form:errors path="description" cssClass="error"/>
  </p>
  <p>
    <button type="submit" class="btn">confirm</button>
  </p>
</form:form>
</body>
</html>