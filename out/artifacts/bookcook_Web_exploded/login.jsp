<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="user" class="bean.Userbean" scope="session">
    <jsp:setProperty name="user" property="showInfo" value="" />
</jsp:useBean>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BookCook-登录</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
            </div>
            <div class="col-md-8">
                <ul class="nav nav-tabs">
                    <li>
                        <a href="index-before.jsp">主页</a>
                    </li>
                    <li class="disabled">
                        <a href="#">书单</a>
                    </li>
                    <li class="disabled">
                        <a href="#">读书计划</a>
                    </li>
                    <li class="dropdown pull-right">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">你的私人定制<strong class="caret"></strong></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="login.jsp">登录</a>
                            </li>
                            <li class="divider">
                            </li>
                            <li>
                                <a href="login.jsp">账户设置</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <form class="form-horizontal jumbotron" action="LoginServlet" method="post" role="form">
                    <h2 class="centerText"><b>用户登录</b></h2>
                    <h3 class="btn-right"><jsp:getProperty name="user" property="showInfo" /></h3>
                    <div class="blank-50"></div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" placeholder="用户名" name="userName" id="inputEmail3">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="password" class="form-control" placeholder="密码" name="Password" id="inputPassword3">
                        </div>
                    </div>
                    <div class="blank-20"></div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <a href="register.jsp" class="btn btn-success btn-full">
                                创建账户
                            </a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button type="submit" class="btn btn-primary btn-full">
                                登录
                            </button>
                        </div>
                    </div>
                    <div class="blank-50"></div>
                </form>
            </div>
            <div class="col-md-2">
            </div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>

</html>
