<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	</head>
	<body>
		<div class="container" id="wrapper">

			<!-- header -->
			<header>
				<a href="index.html" class="logo">
					<img src="../../resources/images/logo-text.png" alt="" />
				</a>
				<nav role="navigation">
					<!-- Навигація для мобільних девайсів -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
							<span class="sr-only">Навігація	</span>
							<span class="fa">&#xf0c9;</span>
						</button>
					</div>

					<!-- Навігаційні посилання -->
					<div class="collapse navbar-collapse navbar-ex1-collapse">
						<ul>
							<li class="active"><a href="index.html">Головна</a></li>
							<li><a href="about.html">Про Нас</a></li>
							<li><a href="gallery.html">Галерея</a></li>
							<li><a href="blog.html">Новини</a></li>
							<li><a href="contact.html">Контакти</a></li>
						</ul>
					</div><!-- Кінець навігаційних посилань -->
					<div id="sun"></div>

				</nav>
				<div class="clearfix"></div>
			</header>
			<!-- end header -->

			<!-- front page header featured area -->
			<section id="featured">

				<!-- WOWSlider -->
				<div id="wowslider-container1">
					<div class="ws_images">
						<ul>
							<li><img src="../../resources/images/wowslider/01.png" alt="Заголовок 1" title="Заголовок 1" id="wows1_0"/>Опис 1</li>
							<li><img src="../../resources/images/wowslider/02.png" alt="Заголовок 2" title="Заголовок 2" id="wows1_1"/>Опис 2</li>
							<li><img src="../../resources/images/wowslider/03.png" alt="Заголовок 3" title="Заголовок 3" id="wows1_2"/>Опис 3</li>
						</ul>
					</div>
					<div class="ws_bullets">
						<div>
							<a href="#" title="Заголовок 1">1</a>
							<a href="#" title="Заголовок 2">2</a>
							<a href="#" title="Заголовок 3">3</a>
						</div>
					</div>
				</div>
				<!--  end WOWSlider -->

			</section>
			<!-- end front page header featured area -->

			<!-- Область контенту-->
			<section id="content-homepage">

				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<div id="col-yellow">
						<div id="ladybug"></div>
						<h2>Про нас</h2>
						<p>Дошкільний навчальний заклад (Ясла-Садок) комбінованого типу №1 "Дюймовочка"</p>
						<a href="about.html" class="button blue"><span>&#xf138;</span>Читати</a>
						<div class="clearfix"><br /></div>
						<h2>Години роботи</h2>
						<p>Пн-Пт З 08:30 до 18:00</p>
						<a href="about.html" class="button blue"><span>&#xf138;</span>Читати</a>
					</div>
				</div>
				<div class="col-lg-3 col-sm-4 col-xs-12">
					<div id="col-green">
						<div id="butterfly"></div>
						<h2>Останні новини</h2>
						<img src="../../resources/images/placeholders/orange-mid.png" alt="" class="img-margin" />
						<p>Тут ви можете прочитати, які події проходять у нашому садку</p>
						<a href="#" class="button red"><span>&#xf138;</span>Читати</a>
					</div>
				</div>
				<div class="col-lg-3 col-sm-4 col-xs-12">
					<div id="col-orange">
						<h2>Галерея</h2>
						<p>Тут ви можете побачити життя нашого садочка</p>
						<img src="../../resources/images/placeholders/yellow-mid.png" alt="" class="img-margin" /><br />
						<a href="gallery.html" class="button green"><span>&#xf138;</span>Галерея</a>
					</div>
				</div>

			</section>
			<!-- Кінець області з контентом -->

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
		<script src="../../resources/js/wowslider.js"></script>
		<script src="../../resources/js/wowtransition.js"></script>
		<script src="../../resources/js/jquery.prettyPhoto.js"></script>

	</body>
</html>