<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body class="bg-white">

<%
String msg =(String)session.getAttribute("msg");
if(msg != null)
{
	%>
	<h1 class="text-danger text-center"><%=msg %></h1>
	<% 
session.removeAttribute("msg");
}
%>


	<section>
		<div class="container w-50 border rounded-3 p-3 bg-light"
			style="margin-top: 7rem;">
			<h1 class="text-danger display-6 text-center">User Registration</h1>
			<form action="signup" method="post">
				<div class="row g-3">
					<div class="col-md-12">
						<div>
							<label class="form-label" for="username">Enter UserName</label> <input
								class="form-control-sm form-control" type="text" name="username"
								id="username">
						</div>
					</div>
					<div class="col-md-12">
						<div>
							<label class="form-label" for="password">Enter Password</label> <input
								class="form-control-sm form-control" type="password"
								name="password" id="password">
						</div>
					</div>
					<div class="col-md-12">
						<div>
							<label class="form-label" for="email">Enter Emial</label> <input
								class="form-control-sm form-control" type="email" name="email"
								id="email">
						</div>
					</div>
					<div class="col-md-6 offset-md-5">
						<div>
							<button class="btn btn-sm btn-outline-success">SignUp</button>
						</div>
					</div>
			</form>
			<div class="col-md-6">
				<div>
					<p class="text-lead">Already SignUp?</p>
					<a href="login.jsp" class="btn btn-sm btn-outline-danger">Login</a>
				</div>
			</div>
		</div>
		</div>
	</section>


</body>
</html>