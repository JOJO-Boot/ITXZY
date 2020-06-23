<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false" %>
<!--设置编写语音为java，编写内容为txt或者html设置编码格式为UTF-8-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>无标题文档</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="css/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>
<!--第三部分开始-->
<div class="main-c row">
    <h3 class="text-center main-tab">优秀学员展示</h3>
    <ul class="list-unstyled text-center">
        <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div>
                <img src="images/242424.png">
                <span>${studentList.get(0).position}:${studentList.get(0).name}</span>
                <p class="text-left">${studentList.get(0).description}</p>
            </div>
        </li>
        <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div>
                <img src="images/242424.png">
                <span>技术顾问:罗大佑</span>
                <p class="text-left">百度技术总监：互联网基础服务领域，从事虚拟主机，云主机，域名。
                    曾任新网高级技术经理，负责技术研发，团队管理与建设。</p>
            </div>
        </li>
        <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div>
                <img src="images/242424.png">
                <span>技术顾问:罗大佑</span>
                <p class="text-left">百度技术总监：互联网基础服务领域，从事虚拟主机，云主机，域名。
                    曾任新网高级技术经理，负责技术研发，团队管理与建设。</p>
            </div>
        </li>
        <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div>
                <img src="images/242424.png">
                <span>技术顾问:罗大佑</span>
                <p class="text-left">百度技术总监：互联网基础服务领域，从事虚拟主机，云主机，域名。
                    曾任新网高级技术经理，负责技术研发，团队管理与建设。</p>
            </div>
        </li>
    </ul>
</div>
</body>
<script src="js/jquery.min.js"></script>
<script  src="js/bootstrap.min.js"></script>
</html>