<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>New author</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
<form:form method="post" action="/author/save" modelAttribute="author">
  <%--        <p>--%>
  <%--            <form:errors path="*"/>--%>
  <%--        </p>--%>
  <h3>Add a new author</h3>
  <p>
    <form:label path="firstName">Firstname</form:label><br>
    <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
  </p>
  <p>
    <form:label path="lastName">Lastname</form:label><br>
    <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
  </p>
  <p>
    <input type="submit" class="btn">
  </p>
</form:form>
</body>
</html>