<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<!--[if IE 8 ]> <html class="ie8 no-js"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html class="not-ie no-js">  <!--<![endif]-->
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Дитячий Садок №1</title>
		<link rel="shortcut icon" href="../../resources/favicon.ico">

		<!-- Bootstrap core CSS -->
		<link href="../../resources/css/bootstrap.min.css" type="text/css" rel="stylesheet" media="screen">

		<link href="../../resources/css/style.css" type="text/css" rel="stylesheet" media="screen">
		<link href="../../resources/css/font-awesome.css" type="text/css" rel="stylesheet" media="screen">

		<script src="../../resources/js/modernizr.js"></script>
		<script src="../../resources/js/respond.js"></script>
		<script src="../../resources/js/jquery.min.js"></script>
		<script src="../../resources/js/main.js"></script>
	</head>
	<body>
	<script type="text/javascript">


		$(document).ready(function () {

			setJson('${posts}')
			getPost()

		})
	</script>
		<div class="container" id="wrapper">

			<!-- header -->
			<header>
				<a href="index.html" class="logo">
					<img src="../../resources/images/logo-text.png" alt="" />
				</a>
				<nav role="navigation">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
							<span class="sr-only">Навігація	</span>
							<span class="fa">&#xf0c9;</span>
						</button>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse navbar-ex1-collapse">
						<ul>
							<li><a href="index.html">Головна</a></li>
							<li><a href="about.html">Про Нас</a></li>
							<li><a href="gallery.html">Галерея</a></li>
							<li class="active"><a href="blog.html">Новини</a></li>
							<li><a href="contact.html">Контакти</a></li>
						</ul>
					</div><!-- /.navbar-collapse -->
					<div id="sun"></div>

				</nav>
				<div class="clearfix"></div>
			</header>
			<!-- end header -->

			<!-- page content area -->


			<section id="content" class="col-lg-7 col-md-8 col-sm-12">

				<div class="cloud">
					<h1>Новина</h1>
				</div>

				<div class="content-bg">
					<div  class="content-bg" id="div_post_context"> </div>

					<div class="clearfix"><br /></div>
					<div class="post-meta">

					</div>
					<div class="post-data">
					</div>

					<div class="clearfix"><br /></div>
					<div class="col-12">

						<a  id="showButton" class="button green"><span>&#xf138;</span>Наступна новина</a>
					</div>
					<div class="clearfix"></div>
				</div>

			</section>
			<!-- end page content area -->

			<div class="clearfix"></div>
		</div>
		<!-- end #wrapper -->

		<footer>
			<div class="footer-menu">
				<div class="container">
					<div class="col-lg-6 col-md-6 col-sm-12 fa social-media">
						<a href="#">&#xf0d4;</a>
						<a href="#">&#xf082;</a>
						<a href="#">&#xf099;</a>
						<a href="#">&#xf16d;</a>
						<a href="#">&#xf08c;</a>
						<a href="#">&#xf0d2;</a>
						<a href="#">&#xf166;</a>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12 footer-links">
						<a href="index.html">Головна</a> /
						<a href="about.html">Про Нас</a> /
						<a href="gallery.html">Галерея</a> /
						<a href="blog.html">Новини</a> /
						<a href="contact.html">Контакти</a>
					</div>
				</div>
			</div>
			<div class="footer-bottom">
				<div class="container">
					<div class="col-lg-12 col-md-12">&copy; 2016 Team Z</div>
				</div>
			</div>
		</footer>

		<script src="../../resources/js/jquery-1.10.1.min.js"></script>
		<script src="../../resources/js/bootstrap.min.js"></script>
		<script src="../../resources/js/custom.js"></script>
		<script src="../../resources/js/jquery.prettyPhoto.js"></script>

	</body>
</html>