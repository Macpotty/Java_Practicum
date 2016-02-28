<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="user" class="bean.Userbean" scope="session">
    <jsp:setProperty name="user" property="showInfo" value="" />
</jsp:useBean>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/my_script_style.js"></script>
    <title>添加书单</title>
</head>

<body id="main">
    <div>
        <header class="header">
            <h1 class="header-logo">
                过去一切时代的精华尽在书中。
            </h1>
            <h2></h2>
            <ul class="header-menu">
                <li><a class="a-menu" href="main.jsp" onclick="toggle('plan')">我的读书计划</a></li>
                <li><a class="a-menu" href="main.jsp" onclick="toggle('list')">我的书单</a></li>
                <li><a class="a-menu" href="main.jsp">首页</a></li>
            </ul>
        </header>
        <div id="addItem">
            <div class="lead">
                <h2>添加新的读书计划</h2></br>
            </div>
            <form name="addItem" action="ModifyPlanServlet" method="post">
                <ul class="typ">
                    <li>
                        <p>书名:</p>
                        <input type="text" name="bookName" placeholder="我想看哪本书呢..." required>
                    </li>
                    <li>
                        <p>开始时间:</p>
                        <input type="text" name="startTime" placeholder="今夕何夕？" >
                    </li>
                    <li>
                        <p>进度:</p>
                        <input type="text" name="status" placeholder="看到哪里了呀？" required>
                    </li>
                    <input type="submit" onClick="myFunction()" value="提交">
                </ul>
            </form>
        </div>
    </div>
</body>
</html>