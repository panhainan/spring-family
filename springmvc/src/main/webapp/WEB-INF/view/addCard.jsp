<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加身份证信息</title>
    <link rel="stylesheet" href="<c:url value="/"/>/css/bootstrap.min.css">
    <style>
        .has-error {
            color: red;
        }
    </style>
</head>
<body>
<sf:form commandName="card" cssClass="form-horizontal" cssStyle="width: 600px;margin: 0 auto" method="post">
    <h1 class="col-sm-offset-2">添加身份证信息</h1>
    <div class="form-group">
        <label class="col-sm-2 control-label">姓　　名：</label>
        <div class="col-sm-6"><sf:input path="name" cssClass="form-control"/></div>
        <div class="col-sm-4 has-error"><sf:errors path="name"/></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">身份证号：</label>
        <div class="col-sm-6"><sf:input path="number" class="form-control"/></div>
        <div class="col-sm-4 has-error"><sf:errors path="number"/></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">失效日期：</label>
        <div class="col-sm-6"><sf:input path="expiringDate" class="form-control" type="date"/></div>
        <div class="col-sm-4 has-error"><sf:errors path="expiringDate"/></div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-5">
            <input type="submit" class="btn btn-success btn-block" value="点击添加">
        </div>
    </div>
</sf:form>
</body>
</html>
