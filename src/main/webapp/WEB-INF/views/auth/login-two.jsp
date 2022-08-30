<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
	<meta name="keywords" content=""/>
	<meta name="description" content=""/>
	<meta name="author" content=""/>
	<title>MealDash</title>
	<link rel="stylesheet" type="text/css"
				href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css"/>
	<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css"/>
	<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet"/>
	<link href="/resources/css/style.css" rel="stylesheet"/>
	<link href="/resources/css/responsive.css" rel="stylesheet"/>
</head>

<body>
<div class="hero_area sub_pages">
	<header class="header_section">
		<div class="container">
			<nav class="navbar navbar-expand-lg custom_nav-container pt-3">
				<a class="navbar-brand" href="index.html">
					<img src="/resources/images/logo.png" alt=""/><span>
              MealDash
            </span>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
								aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<div class="d-flex ml-auto flex-column flex-lg-row align-items-center">
						<ul class="navbar-nav  ">
							<li class="nav-item active">
								<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#"> Fruits</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#"> Services </a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">Contact us</a>
							</li>
						</ul>
						<form class="form-inline my-2 my-lg-0 ml-0 ml-lg-4 mb-3 mb-lg-0">
							<button class="btn  my-2 my-sm-0 nav_search-btn" type="submit"></button>
						</form>
					</div>
					<div class="quote_btn-container ml-0 ml-lg-4 d-flex justify-content-center">
						<a href="">
							Get A quote
						</a>
					</div>
				</div>
			</nav>
		</div>
	</header>
</div>
<!-- end header section -->

<!-- contact section -->

<section class="contact_section layout_padding">
	<div class="container">
		<h2 class="font-weight-bold">
			Login
		</h2>
		<form:form action="/authuser" method="post">
			<div class="row">
				<div class="col-md-8 mr-auto">

					<div class="contact_form-container">
						<div>
							<div>
								<input type="text" placeholder="UserName" name="username">
							</div>
							<div>
								<input type="password" placeholder="Password" name="password">
							</div>
							<c:if test="${param.error != null}">
								<b>Invalid username or password!</b>
							</c:if>
							<c:if test="${param.logout != null}">
								<b>You have been logout!</b>
							</c:if>
							<div class="mt-5">
								<button type="submit">Login</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</section>
<!-- footer section -->
<section class="container-fluid footer_section">
	<p>
		Copyright &copy; 2019 All Rights Reserved By
		<a href="https://html.design/">Free Html Templates</a>
	</p>
</section>
</body>
</html>