<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/insert" method="post" class="form-horizontal">
    工资：<input type="text" name="salary"><br>
    入职日期：<input type="date" name="hiredate"><br>
    性别：<input type="text" name="gender"><br>
    名字：<input type="text" name="username"><br>
    部门编号：<input type="text" name="deptid"><br>
    <input type="submit" name="提交">
</form>
</body>
</html>
