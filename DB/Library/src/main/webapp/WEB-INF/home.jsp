<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Database</title>
</head>
<body>
<h1>Welcome to the Library Database</h1>
<div>
<form class ="form" action="getBook.do" method="GET">
  Book ID: <input type="text" name="bid" />
  <input class="btn btn-primary" type="submit" value="Find Book By ID" />
</form>
</div>

<div class="container-fluid">
<table class="table thead-dark table-striped table-hover">
  <thead>
     <tr>
        <th>Id</th>
        <th>Title</th>
     </tr>
   </thead>

<tbody>

<c:forEach var="b" items="${book}">
     <tr>
        <td>${b.id}</td>
        <td><a href="getBook.do?bid=${b.id}">${b.title}</a></td>
    </tr>
    </c:forEach>
</tbody>
</table>

</div>
</body>
</html>