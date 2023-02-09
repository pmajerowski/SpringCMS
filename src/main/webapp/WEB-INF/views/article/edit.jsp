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
    <title>Edit article</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
</head>
<body>
<form:form method="post" action="/article/edit/save/${articleToEdit.id}" modelAttribute="articleToEdit">
    <h3>Edit article</h3>
    <p>
        <form:label path="title">Title</form:label>
        <form:input path="title"/><br>
        <form:errors path="title" cssClass="error"/>
    </p>
    <p>
        <form:label path="">Category</form:label>
        <form:select itemValue="id" itemLabel="name" path="categories" items="${categories}" multiple="true"/>
        <form:errors path="categories" cssClass="error"/><br>
        <form:errors path="categories" cssClass="error"/>
    </p>
    <p>
        <form:label path="author">Author</form:label>
        <form:select itemValue="id" itemLabel="name" path="author" items="${authors}" /><br>
        <form:errors path="author" cssClass="error"/>
    </p>
    <p>
        <form:label path="content">Content</form:label><br>
        <form:textarea path="content"/><br>
        <form:errors path="content" cssClass="error"/>
    </p>
    <p>

        <form:hidden path="id"/>
        <form:hidden path="createdOn" />

        <input type="submit" class="btn" />
    </p>
</form:form>
<p>
    <a href="/author/list" class="btn">CANCEL</a>
</p>

</body>
</html>
