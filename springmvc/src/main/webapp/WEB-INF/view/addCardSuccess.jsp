<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>添加成功</title>
    <link rel="stylesheet" href="<c:url value="/"/>/css/bootstrap.min.css">
</head>
<body>
<div style="width: 600px;margin: 0 auto">
    <h3>添加成功！</h3>
    姓　　名：<c:out value="${card.name}"/> <br>
    身份证号：<c:out value="${card.number}"/> <br>
    失效日期：<fmt:formatDate value="${card.expiringDate}" pattern="yyyy/MM/dd"/> <br>
</div>
</body>
</html>
