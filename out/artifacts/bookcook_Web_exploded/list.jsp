<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="list" class="bean.ShowListBean" scope="session" />
<jsp:useBean id="user" class="bean.Userbean" scope="session" />
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BookCook-书单</title>
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
                        <a href="index-after.jsp">主页</a>
                    </li>
                    <li class="active">
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
                <div class="jumbotron">
                    <h2><b>我的欲读书目</b>
                    <a class="btn btn-primary btn-right" href="modifyList.jsp">添加</a></h2>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>
                                    书名
                                </th>
                                <th>
                                    作者
                                </th>
                                <th>
                                    类别
                                </th>
                                <th>
                                    状态
                                </th>
                            </tr>
                        </thead>
                        <jsp:getProperty name="list" property="presentPageResult"/>
                    </table>
                    <ul class="pagination">
                        <li>
                            <form action="MyList" class="form-inline btn-left" method="post">
                                <input type="hidden" name="showPage" value="<%= list.getShowPage()-1 %>">
                                <input type="submit" value="Prev">
                            </form>
                        </li>
                        <%
                        for(int i = 1; i <= list.getPageAllCount(); i++){
                            out.println("<li><form action=\"MyList\" class=\"form-inline btn-left\" method=\"post\"><input type=\"hidden\" name=\"showPage\" value=\""+ i +"\"><input type=\"submit\" value=\""+ i +"\"></form></li>");
                        } 
                        %>
                        <li>
                            <form action="MyList" class="form-inline btn-left" method="post">
                                <input type="hidden" name="showPage" value="<%= list.getShowPage()+1 %>">
                                <input type="submit" value="Next">
                            </form>
                        </li>
                    </ul>
                </div>
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
