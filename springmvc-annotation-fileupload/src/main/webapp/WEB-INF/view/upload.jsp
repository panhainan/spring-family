<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SpringMVC4.x web项目 文件上传实例 （Annotation配置方式） </title>
    <link rel="stylesheet" href="<c:url value="/"/>/css/base.css">
</head>
<body>
<div class="header">
    <div class="logo"><img src="<c:url value="/"/>/images/logo.jpg" alt=""></div>
    <div class="title"><h1>SpringMVC4.x 文件上传实例（Annotation配置）</h1></div>
</div>
<hr>
<div class="body">
    <div>
        <h3>单文件实例演示</h3>
        <form action="<c:url value="/upload"/>" method="post" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="submit" value="点击上传">
        </form>
        <c:if test="${message!=null}">
            上传结果：<c:out value="${message}"/>
        </c:if>
    </div>
    <hr>
    <div>
        <h3>多文件实例演示</h3>
        <form action="<c:url value="/uploadMulti"/>" method="post" enctype="multipart/form-data">
            <input type="file" name="files"/>
            <c:if test="${messages1!=null}">
                上传结果：<c:out value="${messages1}"/>
            </c:if>
            <br/><br/>
            <input type="file" name="files"/>
            <c:if test="${messages2!=null}">
                上传结果：<c:out value="${messages2}"/>
            </c:if>
            <br/><br/>
            <input type="file" name="files"/>
            <c:if test="${messages3!=null}">
                上传结果：<c:out value="${messages3}"/>
            </c:if>
            <br/><br/>
            <input type="submit" value="点击上传多文件"/>
        </form>

    </div>
    <hr>
    <div>
        <h3>使用技术</h3>
        <p>采用StandardServletMultipartResolver – Servlet 3.0 multipart request parsing.方式实现</p>
        <ul>
            <li>IDEA 2017</li>
            <li>Maven 3.x</li>
            <li>Spring 4.3.6.RELEASE</li>
            <li>JDK 1.8</li>
            <li>logback 1.1.2</li>
            <li>Junit 4.12</li>
        </ul>
        <h3>项目结构</h3>
        <p>查看源码，前往GitHub，查看 <a href="https://github.com/panhainan/spring-family">github.com/panhainan/spring-family</a>下的
            <b>springmvc-annotation-fileupload</b>文件夹</p>
    </div>
    <hr>
    <div class="footer">
        <p>© <a href="http://sixteen.site" target="_blank">sixteen.site</a> 2018</p>
    </div>
</div>
</body>
</html>
