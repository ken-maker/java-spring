<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">
    <tr>
        <td>编号</td>
        <td>工资</td>
        <td>入职日期</td>
        <td>性别</td>
        <td>名字</td>
        <td>部门编号</td>
    </tr>
    <c:forEach var="emp" items="${employees.list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.salary}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.gender}</td>
            <td>${emp.username}</td>
            <td>${emp.deptid}</td>
        </tr>
    </c:forEach>
</table>

<ul class="pagination">
    <li><a href="${pageContext.request.contextPath}/list?pageNum=1">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/list?pageNum=${employees.prePage}">上一页</a></li>
    <c:forEach var="i" items="${employees.navigatepageNums}">
        <li><a href="${pageContext.request.contextPath}/list?pageNum=${i}">${i}</a></li>
    </c:forEach>
    <li><a href="${pageContext.request.contextPath}/list?pageNum=${employees.nextPage}">下一页</a></li>
    <li><a href="${pageContext.request.contextPath}/list?pageNum=${employees.pages}">尾页</a></li>
</ul>
</body>
</html>
