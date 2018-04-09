<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SpringMVC4.x web项目 Annotation配置方式</title>
    <link rel="stylesheet" href="<c:url value="/"/>/css/base.css">
</head>
<body>
<div class="header">
    <div class="logo"><img src="<c:url value="/"/>/images/logo.jpg" alt=""></div>
    <div class="title"><h1>SpringMVC4.x web项目 Annotation配置方式</h1></div>
</div>
<hr>
<div class="body">
    <h3>使用技术</h3>
    <ul>
        <li>IDEA 2017</li>
        <li>Maven 3.x</li>
        <li>Spring 4.3.6.RELEASE</li>
        <li>JDK 1.8</li>
        <li>logback 1.1.2</li>
        <li>Junit 4.11</li>
    </ul>
    <h3>项目结构</h3>
        <p>查看源码，前往GitHub，查看 <a href="https://github.com/panhainan/spring-family">github.com/panhainan/spring-family</a>下的 <b>springmvc-annotation-jdbc</b>文件夹</p>
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
        <li><p style="font-weight: bolder">新建WebAppInitializer类继承AbstractAnnotationConfigDispatcherServletInitializer</p>
            <ul>
                <li>重写getRootConfigClasses方法</li>
                <li>重写getServletConfigClasses方法</li>
                <li>重写getServletMappings方法</li>
                <li>重写getServletFilters方法</li>
                <li>...</li>
            </ul>

        </li>
        <li><p style="font-weight: bolder">新建WebConfig类继承WebMvcConfigurerAdapter</p>
        <ul>
            <li>开启@Configuration、@EnableWebMvc、@ComponentScan({"site.sixteen.web"})</li>
            <li>配置Jsp视图解析器ViewResolver Bean</li>
            <li>重写configureDefaultServletHandling方法配置静态资源默认处理方式</li>
            <li>...</li>
        </ul>
        </li>
        <li>新建RootConfig类 ...</li>
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
