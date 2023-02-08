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
    <title>Edit category</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
<form:form method="post" action="/category/edit/save/${categoryToEdit.id}" modelAttribute="categoryToEdit">
    <h3>Edit category</h3>
    <p>
        <form:label path="name">Name</form:label><br>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="description" >Description</form:label><br>
        <form:textarea path="description"/>
    </p>
    <p>

        <form:hidden path="id"/>
        <input id="id" name="id" type="hidden" value="${categoryToEdit.id}"/>
        <button type="submit" class="btn">confirm</button>
    </p>
</form:form>
<p>
    <a href="/category/list" class="btn">cancel</a>
</p>

</body>
</html>
