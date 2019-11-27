<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<a href="${pageContext.request.contextPath}/add">添加</a>
<br>
<table class="table">
    <tr>
        <td>编号</td>
        <td>名称</td>
    </tr>
    <c:forEach var="dept" items="${DeptAll.list}">
        <tr>
            <td>${dept.id}</td>
            <td>${dept.name}</td>
            <td><a href="${pageContext.request.contextPath}/delete?deptId=${dept.id}">事务删除，删掉部门同时也删掉员工</a></td>
        </tr>
    </c:forEach>
</table>

<ul class="pagination">
    <li><a href="${pageContext.request.contextPath}/list?pageNum=1">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/list?pageNum=${DeptAll.prePage}">上一页</a></li>
    <c:forEach var="i" items="${DeptAll.navigatepageNums}">
        <li><a href="${pageContext.request.contextPath}/list?pageNum=${i}">${i}</a></li>
    </c:forEach>
    <li><a href="${pageContext.request.contextPath}/list?pageNum=${DeptAll.nextPage}">下一页</a></li>
    <li><a href="${pageContext.request.contextPath}/list?pageNum=${DeptAll.pages}">尾页</a></li>
</ul>

</body>
</html>
