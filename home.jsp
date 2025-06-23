<%@page import="com.Entity.Note"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Dao.NoteInfoDao"%>
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
	
<style type="text/css">

#box{
display: none;
}


#date{
position: absolute;
right: 1.5rem;
bottom: 2rem;
}


#deleteb{
position: absolute;
right: 1.5rem;
top: 1rem;
}


</style>
</head>
<body class="bg-white">


<%
String token  = (String)session.getAttribute("token");
if(token != null)
{
%>
<!-- navbar starts -->
<nav class="navbar navbar-expand-lg bg-body-tertiary shadow-sm">
  <div class="container-fluid">
    <h1 class="navbar-brand">Hello, <%=token %></h1>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="btn btn-outline-danger" aria-current="page" href="logout">Logout</a>
        </li>
      </ul>

    </div>
  </div>
</nav>	

<!-- navbar ends -->






<!-- add note form starts -->



<button class="btn btn-primary m-5 " onclick="openbox()">Add Note</button>


<section id="box" class="mb-5">
	<div class="container w-50 bg-light border rounded-5 p-5">
		<h1 class="display-6">Write Note</h1>
		<form action="addnote" method="post">
			<input type="hidden" name="username" value="<%=token%>">
			<div class="row g-4">
				<div class="col-md-12 mt-5">
					<div>
						<textarea required class="form-control" rows="5" cols="15" name="note"></textarea>
					</div>
				</div>
				<div class="col-md-6 offset-md-5">
					<div>
						<button class="btn btn-success">Submit</button>
					</div>
				</div>
			</div>
		</form>
	<button onclick="closebox()" class="btn btn-sm btn-outline-danger">close</button>
	</div>
</section>



<!-- add note form ends -->





<!-- edit form starts -->
<%
Note n1=(Note)session.getAttribute("n");
if(n1 != null)
{
	%>
<section id="box1" class="mb-5">
	<div class="container w-50 bg-light border rounded-5 p-5">
		<h1 class="display-6">Edit Note</h1>
		<form action="editnote" method="post">
			<input type="hidden" name="noteid" value="<%=n1.getNoteid()%>">
			<div class="row g-4">
				<div class="col-md-12 mt-5">
					<div>
						<textarea required class="form-control" rows="5" cols="15" name="note"><%=n1.getNote() %></textarea>
					</div>
				</div>
				<div class="col-md-6 offset-md-5">
					<div>
						<button class="btn btn-success">Submit</button>
					</div>
				</div>
			</div>
		</form>
	<button onclick="closebox1()" class="btn btn-sm btn-outline-danger">close</button>
	</div>
</section>
	
	
	
	<%
session.removeAttribute("n");
}
%>

<!-- edit form ends -->










<!-- display notes starts -->


<%
NoteInfoDao nDao = new NoteInfoDao();
ArrayList<Note> al= nDao.readAllNotes(token);
%>

<section>
	<div class="container border w-75 rounded-3 p-5">
		<%
		for(Note n:al)
		{
			%>
			<div class="p-5 container border rounded-3 border-3 mb-3 w-75 bg-light" style="position: relative;">
				
				<form action="readnote" method="post">
					<input type="hidden" name="noteid" value="<%=n.getNoteid()%>">
					<button class="btn btn-sm btn-info">Edit</button>
				</form>
				
				<p class="lead"><%=n.getNote() %></p>
				<p style="font-size: 0.8rem;">Add Date & Time :<br> <%=n.getAdd_date() %></p>
				<p id="date" style="font-size: 0.8rem;">Edit Date & Time :<br> <%=n.getEdit_date() %></p>
			
				<form action="deletenote" method="post" id="deleteb">
					<input type="hidden" name="noteid" value="<%=n.getNoteid()%>">
					<button class="btn btn-close p-2"></button>
				</form>
			</div>
			<%
		}
		
		if(al.size() == 0)
		{
			%>
			<h1 class="text-danger text-center display-6">No Notes Added...</h1>
			<%
		}
		%>
		
		
	</div>
</section>


<!-- display notes ends -->




















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
<script type="text/javascript">
function openbox()
{
	document.getElementById("box").style.display="block";
}
function closebox()
{
	document.getElementById("box").style.display="none";
}

function closebox1()
{
	document.getElementById("box1").style.display="none";
}
</script>
	
	
	
	
	
	 
<%
}
else
{
	response.sendRedirect("login.jsp");
}
%>


</body>
</html>