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
    <title>BookCook-添加书单</title>
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
                <div class="carousel slide" id="carousel-217363">
                    <ol class="carousel-indicators">
                        <li class="active" data-slide-to="0" data-target="#carousel-217363">
                        </li>
                        <li data-slide-to="1" data-target="#carousel-217363">
                        </li>
                        <li data-slide-to="2" data-target="#carousel-217363">
                        </li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img alt="Carousel Bootstrap First" src="img/1.jpg" />
                            <div class="carousel-caption">
                                <h4>
                                First Thumbnail label
                            </h4>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <img alt="Carousel Bootstrap Second" src="img/7.jpg" />
                            <div class="carousel-caption">
                                <h4>
                                Second Thumbnail label
                            </h4>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <img alt="Carousel Bootstrap Third" src="img/44.jpg" />
                            <div class="carousel-caption">
                                <h4>
                                Third Thumbnail label
                            </h4>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                            </div>
                        </div>
                    </div> <a class="left carousel-control" href="#carousel-217363" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-217363" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                </div>
                <form class="form-horizontal jumbotron" action="AddPlan" method="post" role="form">
                    <h2 class="centerText"><b>添加新的读书计划</b></h2>
                    <div class="blank-50"></div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" placeholder="书名" name="bookName" id="inputEmail3">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" placeholder="开始时间" name="startTime" id="inputPassword3">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" placeholder="进度" name="status" id="inputPassword3">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <textarea type="text" class="form-control" placeholder="感想" name="thoughts" id="inputPassword3"></textarea>
                        </div>
                    </div>
                    <div class="blank-20"></div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <a href="plan.jsp" class="btn btn-primary btn-full">
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
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>

</html>