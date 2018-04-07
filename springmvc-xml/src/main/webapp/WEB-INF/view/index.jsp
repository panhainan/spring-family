<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SpringMVC4.x web项目 XML配置方式</title>
    <link rel="stylesheet" href="<c:url value="/"/>/css/base.css">
</head>
<body>
<div class="header">
    <div class="logo"><img src="<c:url value="/"/>/images/logo.jpg" alt=""></div>
    <div class="title"><h1>SpringMVC4.x web项目 XML配置方式</h1></div>
</div>
<hr>
<div class="body">
    <h3>使用技术：</h3>
    <ul>
        <li>IDEA 2017</li>
        <li>Maven 3.x</li>
        <li>Spring 4.3.6.RELEASE</li>
        <li>JDK 1.8</li>
        <li>logback 1.1.2</li>
        <li>Junit 4.11</li>
    </ul>
    <h3>项目结构</h3>
    <p>查看源码，前往GitHub，查看 <a href="https://github.com/panhainan/spring-family">github.com/panhainan/spring-family</a>下的 <b>springmvc-xml</b>文件夹</p>
    <h3>搭建步骤</h3>
    <ul>
        <li>
            <p style="font-weight: bolder">配置pom.xml</p>
            <ul>
                <li>SpringMVC,SpringTest支持jar包</li>
                <li>LogBack支持jar包</li>
                <li>JSTL标签支持jar包</li>
                <li>Servlet支持jar包</li>
                <li>Junit支持jar包</li>
                <li>...</li>
            </ul>
        </li>
        <li><p style="font-weight: bolder">配置web.xml</p>
            <ul>
                <li>修改web.xml版本</li>
                <li>配置context-param</li>
                <li>配置前端控制器DispatcherServlet</li>
                <li>配置上下文监听器ContextLoaderListener</li>
                <li>配置数据传输编码过滤器CharacterEncodingFilter</li>
                <li>配置静态资源默认处理方式</li>
                <li>...</li>
            </ul>

        </li>
        <li><p style="font-weight: bolder">配置spring-mvc.xml</p>
        <ul>
            <li>开启SpringMVC注解模式<mvc:annotation-driven/></li>
            <li>配置静态资源默认处理方式<mvc:default-servlet-handler/></li>
            <li>配置Jsp视图解析器ViewResolver</li>
            <li>配置web相关Bean的扫描路径<context:component-scan base-package=""/></li>
            <li>根据需要配置拦截器</li>
            <li>...</li>
        </ul>
        </li>
        <li>配置spring-service.xml ...</li>
        <li>配置spring-dao.xml ...</li>
        <li>配置logback.xml ...</li>
        <li>编写controller，service，dao层代码 ...</li>
    </ul>
</div>
<hr>
<div class="footer">
    <p>© <a href="http://sixteen.site" target="_blank">sixteen.site</a> 2018</p>
</div>
</body>
</html>
