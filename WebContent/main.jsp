<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/my_script_style.js"></script>
    <title>读书信息管理系统</title>
</head>

<body id="main">
    <div>
        <header class="header">
            <h1 class="header-logo">
                过去一切时代的精华尽在书中。
            </h1>
            <ul class="header-menu">
                <li><a class="a-menu" onclick="toggle('plan')">我的读书计划</a></li>
                <li><a class="a-menu" onclick="toggle('list')">我的书单</a></li>
                <li><a class="a-menu" onclick="toggle('home')">首页</a></li>
            </ul>
        </header>
        <div id="home">
            <div class="lead">
                <h2>欢迎来到你的私人书籍管理系统</h2></br>
                <h2>书籍是人类进步的阶梯</h2>
                <h2>列出你的欲读清单，写下你的读书计划，从点滴开始</h2>
            </div>
            <div class="content">
                <h3>《小王子》选段</h3></br>
                <p>小王子还把剩下的最后几颗猴面包树苗全拔了。他有点忧伤。他以为他再也 不会回来了。这天，这些家常活使他感到特别亲切。当他最后一次浇花时，准备 把她好好珍藏起来。他发觉自己要哭出来。</p>
                </br>
                <p>“再见了。”他对花儿说道。</p>
                </br>
                <p>可是花儿没有回答他。</p>
                </br>
                <p>“再见了。”他又说了一遍。</p>
                </br>
                <p>花儿咳嗽了一阵。但并不是由于感冒。</p>
                </br>
                <p>她终于对他说道：“我方才真蠢。请你原谅我。希望你能幸福。” 花儿对他毫不抱怨，他感到很惊讶。他举着罩子，不知所措地伫立在那里。 他不明白她为什么会这样温柔恬静。</p>
                </br>
                <p>“的确，我爱你。”花儿对他说道：“但由于我的过错，你一点也没有理会。 这丝毫不重要。不过，你也和我一样的蠢。希望你今后能幸福。把罩子放在一边 吧，我用不着它了。”</p>
                </br>
                <p>“要是风来了怎么办？”</p>
                </br>
                <p>“我的感冒并不那么重……夜晚的凉风对我倒有好处。我是一朵花。”</p>
                </br>
                <p>“要是有虫子野兽呢？……”</p>
                </br>
                <p>“我要是想认识蝴蝶，经不起两三只尺蠖是不行的。据说这是很美的。不然 还有谁来看我呢？你就要到远处去了。至于说大动物，我并不怕，我有爪子。”</p>
                </br>
                <p>于是，她天真地显露出她那四根刺，随后又说道： “别这么磨蹭了。真烦人！你既然决定离开这儿，那么，快走吧！”</p>
                </br>
                <p>她是怕小王子看见她在哭。她是一朵非常骄傲的花……</p>
                </br>
            </div>
        </div>
        <div id="list">
            <div class="lead">
                <h2>我的书单</h2></br>
            </div>
            <div class="content">
                <table>
                    <tr>
                        <th>序号</th>
                        <th>书名</th>
                        <th>作者</th>
                        <th>类别</th>
                        <th>状态</th>
                    </tr>
                </table>
            </div>
        </div>
        <div id="plan">
            <div class="lead">
                <h2>我的书单</h2></br>
            </div>
            <div class="content">
                <table>
                    <tr>
                        <th>序号</th>
                        <th>书名</th>
                        <th>时间</th>
                        <th>进度</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>

</html>