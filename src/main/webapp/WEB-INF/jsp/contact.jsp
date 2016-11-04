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
							<li><a href="blog.html">Новини</a></li>
							<li class="active"><a href="contact.html">Контакти</a></li>
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
					<h1>Контакти</h1>
				</div>

				<div class="content-bg">
					<div class="col-lg-6 col-sm-12">
						<span class="fa"></span> <span id="address">Україна, Черкаська область, місто Черкаси, вулиця Хрещатик, 135</span><br /><!-- input your address on this line -->
						<span class="fa"></span> 37-65-77 <br />
						<span class="fa"></span> email: 	dns1@ukr.net<br />
					</div>
					<div class="col-lg-6 col-sm-12">
						<div class="fa social-media">
							<a href="#">&#xf0d4;</a>
							<a href="#">&#xf082;</a>
							<a href="#">&#xf099;</a>
							<a href="#">&#xf16d;</a>
							<a href="#">&#xf08c;</a>
							<a href="#">&#xf0d2;</a>
							<a href="#">&#xf166;</a>
						</div>
					</div>
					<div class="clearfix"></div>
					<div id="map">

					</div><!-- end #map -->
					<div class="clearfix"></div>

					<div class="separator"></div>

					<div id="note"></div>
					<form class="w-clearfix" id="ajax-contact-form" action="http://ithemewordpress.com/">
						<div class="feedback">
							<h1> Зворотній звʼязок </h1>
						</div>
						<div class="col-12">
							<textarea name="message" id="message" placeholder="Напишіть ваше повідомлення"></textarea>
						</div>
						<div class="col-6">
							<input type="text" name="name" placeholder="Ваше Імʼя" />
						</div>
						<div class="col-6">
							<input type="text" name="email" placeholder="Ваша Електронна Пошта" />
						</div>
						<div class="col-12">
							<input class="button red" type="submit" value=" НАДІСЛАТИ" />
						</div>
					</form>
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
		<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
		<script src="../../resources/js/gmaps.js"></script>
		<script>

			GMaps.geocode({
				address: $('#address').html(),
				callback: function(results, status) {
					if (status == 'OK') {
						map = new GMaps({
							div: '#map',
							lat: 49.452458,
							lng: 32.051317,
							zoom: 16	
						});
						var latlng = results[0].geometry.location;
						map.setCenter(latlng.lat(), latlng.lng());
						map.addMarker({
							lat: latlng.lat(),
							lng: latlng.lng()
						});
					}
				}
			});
		</script>
	</body>
</html>