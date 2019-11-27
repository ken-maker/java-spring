<%--
  Created by IntelliJ IDEA.
  User: 匿名情书
  Date: 2019/11/21
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/insert">
    <input type="text" name="name"/>
    <input type="submit" value="提交">
</form>

</body>
</html>
