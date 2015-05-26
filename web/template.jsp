<%--
  Created by IntelliJ IDEA.
  User: arthurveys
  Date: 26/05/15
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="css/template.css" type="text/css"/>
    <title>The Magic Pan</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="img/magicPanLogoHeader.png"/></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="work.html">Work</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="blog.html">Blog</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> <span class="caret"></span></a>
                    <form class="form dropdown-menu" role="menu" id="formLogin">
                        <input name="username" id="username" type="text" placeholder="Username">
                        <input name="password" id="password" type="password" placeholder="Password"><br>
                        <button type="button" id="btnLogin" class="btn">Login</button>
                    </form>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div id="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <h4>The Magic Pan</h4>
            </div><!-- /col-lg-4 -->
            <div class="col-lg-4">
            </div><!-- /col-lg-4 -->
            <div class="col-lg-4">
                <h4>© The Magic Pan</h4>
                <p>For the love of good foods & great website.</p>
            </div><!-- /col-lg-4 -->
        </div>
    </div>
</div>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
