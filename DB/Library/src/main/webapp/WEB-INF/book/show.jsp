<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Book</title>
<jsp:include page="../bootstrapHead.jsp"></jsp:include>
</head>
<body>
<fieldset>
<div>

<legend>  <h5>${book.title} (${film.publishedDate})</h5> </legend>
  <p>${book.description}</p>
</div>
</fieldset>

<div>
	<fieldset>
	<form action="remove.do" method="GET">
	<legend><h3>Delete This Book:</h3></legend>
		<label>Book ID: <input type="text" name="id" value="${findById.id}" /></label><br />
		<input class="btn btn-primary" type="submit" value="Delete This Book" />
   
		</div>
	</form>
		</fieldset>
	<br>
	<div>
	<form action="edit.do" method="GET">
	<fieldset>
	<legend><h3>Edit This Book:</h3></legend>
	<!--TODO: fix input values  -->
		<label>Book ID: <input type="text" name="id" value="${findById.id}" /></label></br>
		<label>Book Title:  <input type="text" name="title" value="${findById.title}" /></label><br />
		<label>Author: <input type="text" name="author" value="${findById.author}" /></label><br />
		<label>Description: <input type="text" name="description" value="${findById.description}" /></label><br />
		<label>Published Date: <input type="text" name="publishedDate" value="${findById.publishedDate}" /></label><br />
		<label>Total Pages: <input type="text" name="totalPages" value="${findById.totalPages}" /></label><br />
		<label>Genre: <input type="text" name="genre" value="${findById.genre}" /></label><br />
		<label>ISBN: <input type="text" name="isbn" value="${findById.isbn}" /></label><br />
		<input class="btn btn-primary" type="submit" value="Edit This Book" />
		</div>
	</fieldset>
	</form>
	<br>
	<div class="footer">
	<p>
		<a href="home.do"><strong>Return to Library Menu</strong></a>
	</p>
	</div>
<jsp:include page="../bootstrapFoot.jsp"></jsp:include>
</body>
</html>