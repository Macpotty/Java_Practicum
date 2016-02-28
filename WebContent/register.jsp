<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/my_jquery_style.js"></script>
    <title>注册</title>
</head>

<body id="register">
    <script>
    function check() {
        with(document.all) {
            if (input1.value != input2.value) {
                alert("两次输入密码不同")
                input1.value = "";
                input2.value = "";
            } else document.forms[0].submit();
       }
    }
    </script>
    <div class="header">
        <h1>注册</h1>
    </div>
    <form name="register" action="RegisterServlet" method="post">
        <ul class="typ">
            <li>
                <input type="text" name="userName" placeholder="账号" required />
            </li>
            <li>
                <input type="Email" name="E-mail" placeholder="邮箱" />
            </li>
            <li>
                <input type="password" name="Password" placeholder="密码" required id="input1" />
            </li>
            <li>
                <input type="password" placeholder="确认密码" required id="input2" />
                <span id="tishi"></span></li>
            <input type="submit" onClick="check();" value="创建账户">
            <div class="clear"> </div>
        </ul>
    </form>
</body>