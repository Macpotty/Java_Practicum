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
    <title>登录</title>
</head>

<body id="login">
    <div class="header">
        <h1 class="header-logo">登录</h1>
        <span class="warning">
            <jsp:getProperty name="user" property="showInfo" />
        </span>
    </div>
        <form name="login" action="LoginServlet" method="post">
            <ul class="typ">
                <li>
                    <input type="text" name="userName" placeholder="账号" required/>
                </li>
                <li>
                    <input type="password" name="Password" placeholder="密码" required/>
                </li>
                <input type="submit" onClick="myFunction()" value="登录">
            </ul>
        </form>
</body>