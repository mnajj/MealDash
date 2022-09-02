<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
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
								<a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="fruit.html"> Fruits</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="service.html"> Services </a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="contact.html">Contact us</a>
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
<section class="fruit_section layout_padding-top">
	<div class="container">
		<h2 class="custom_heading">All Restaurants</h2>
		<p class="custom_heading-text">
			There are many variations of passages of Lorem Ipsum available, but
			the majority have
		</p>
		<c:if test="${param.invalid != null}">
			<div class="alert alert-danger" role="alert">
				Invalid quantity number!
			</div>
		</c:if>
		<div class="row layout_padding2">
			<div class="col-md-8">
				<div class="fruit_detail-box">
					<h3>
						${item.name}
					</h3>
					<p class="mt-4 mb-5">
						The combination of the meaty, briny, vegetal flavors in this pizza hits so many satisfying notes that it
						is sure to be a hit at your table.
						<br><span class="item-sub-title">Price: ${item.unitPrice}</span>
						<br><span class="item-sub-title">Available quantity: ${item.quantity}</span>
						<br><span class="item-sub-title">Size: ${item.size}</span>
					</p>
					<div class="contact_form-container">
						<div>
							<c:url var="addItemLink" value="/cart/add-item">
								<c:param name="itemId" value="${item.id}"/>
								<c:param name="menuId" value="${item.menuId}"/>
							</c:url>
							<form:form action="${addItemLink}" modelAttribute="item" method="post">
								<form:hidden path="quantity"/>
								<p>
									Quantity: <form:input path="quantityInput"/>
								</p>
								<div class="mt-5">
									<input type="submit" value="Add" class="custom_dark-btn"/>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 d-flex justify-content-center align-items-center">
				<div class="fruit_img-box d-flex justify-content-center align-items-center">
					<img src="${item.imagePath}" alt="" class="" width="250px"/>
				</div>
			</div>
		</div>
	</div>
</section>


</body>
</html>
