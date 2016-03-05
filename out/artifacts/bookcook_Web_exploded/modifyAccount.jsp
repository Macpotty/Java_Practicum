<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="user" class="bean.Userbean" scope="session">
</jsp:useBean>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BookCook-编辑个人信息</title>
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
                    <li class="active">
                        <a href="index-after.jsp">主页</a>
                    </li>
                    <li>
                        <a href="MyList">书单</a>
                    </li>
                    <li>
                        <a href="MyPlan">读书计划</a>
                    </li>
                    <li class="dropdown pull-right">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">你的私人定制<strong class="caret"></strong></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="modifyAccount.jsp">账户设置</a>
                            </li>
                            <li class="divider">
                            </li>
                            <li>
                                <a href="Logout">退出</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <form class="form-horizontal jumbotron" action="ModifyAccount" method="post" role="form">
                    <h2 class="centerText"><b>用户信息</b></h2>
                    <a class="btn btn-primary" href="modifyPasswd.jsp">修改密码</a>
                    <h3 class="btn-right"><jsp:getProperty name="user" property="showInfo" /></h3>
                    <div class="blank-50"></div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="email" class="form-control" placeholder="E-mail" name="E-mail" value="<%= user.getUserEmail() %>" id="inputEmail3">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" placeholder="真实姓名" name="realName" value="<%= user.getRealName() %>" id="inputPassword3">
                        </div>
                    </div>
                    <div class="blank-20"></div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <a href="index-after.jsp" class="btn btn-primary btn-full">
                                返回
                            </a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button type="submit" class="btn btn-sccess btn-full">
                                提交
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
</body>