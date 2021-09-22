<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Database</title>
<jsp:include page="bootstrapHead.jsp"></jsp:include>
</head>
<body>
<h1>Welcome to the Library Database</h1>
<br>
<div>
<form class="form" action="create.do" method="POST">
<fieldset>
<legend><h3>Add Book</h3></legend>
		<label>Book ID: <input type="text" name="id" placeholder="Enter Book ID"/></label><br >
		<label >Book Title: <input type="text" name="title" placeholder="Enter Book Title"/></label><br />
		<label >Book Author: <input type="text" name="author" placeholder="Enter Author" /></label><br />
		<label>Book Description: <input type="text" name="description" placeholder="Enter Description of Book" /></label><br />
		<label>Book Published: <input type="text" name="publishedDate" placeholder="Enter Published Date in 'YYYY-MM-DD'" /></label><br />
		<label>Book Length: <input type="text" name="totalPages" placeholder="Enter Lenght of Book"/></label><br />
		<label>Book Genre: <input type="text" name="genre" placeholder="Enter Genre" /></label><br />
		<label>Book ISNB: <input type="text" name="isbn" placeholder="Format example: 123.123"/></label><br />

<input class="btn btn-primary" type="submit" value="Add New Book"/>
</form>
</div>
</fieldset>
<br>

<div>
<form class ="form" action="getBook.do" method="GET">
<fieldset>
  Book ID: <input type="text" name="bid" />
  <input class="btn btn-primary" type="submit" value="Find Book By ID" />
</fieldset>
</form>
</div>


<fieldset>
<div class="container-fluid">
<table class="table thead-dark table-striped table-hover">
  <thead>
     <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Author</th>
     </tr>
   </thead>

<tbody>

<c:forEach var="b" items="${book}">
     <tr>
        <td>${b.id}</td>
        <td><a href="getBook.do?bid=${b.id}">${b.title}</a></td>
        <td>${b.author}</td>
    </tr>
    </c:forEach>
</tbody>
</table>

</div>
</fieldset>
<jsp:include page="bootstrapFoot.jsp"></jsp:include>
</body>
</html>