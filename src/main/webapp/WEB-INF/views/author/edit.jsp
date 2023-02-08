<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: przemek
  Date: 07/02/2023
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit author</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
</head>
<body>
<form:form method="post" action="/author/edit/save/${authorToEdit.id}" modelAttribute="authorToEdit">
    <h3>Edit author</h3>
    <p>
        <form:label path="firstName">Firstname</form:label>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Lastname</form:label>
        <form:input path="lastName"/>
    </p>
    <p>

        <form:hidden path="id"/>
        <input id="id" name="id" type="hidden" value="${authorToEdit.id}"/>
        <button type="submit" class="btn">confirm</button>
    </p>
</form:form>
<p>
    <a href="/author/list" class="btn" >cancel</a>
</p>

</body>
</html>
