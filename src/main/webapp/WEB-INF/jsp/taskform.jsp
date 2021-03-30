<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title>
</head>
<body>
<h2>Enter New Task Details</h2>
<form action="task" method="post">
<input type="hidden" id="id" value="${ userId }" name="userId"><br>
 <label for="name">Name:</label><br>
  <input type="text" id="name" name="name"><br>
  <jsp:useBean id="now" class="java.util.Date" />
  <fmt:formatDate var="fmtsDate" value="${now}" pattern="yyyy-MM-dd"/>
  <label for="sdate">Start Date:</label><br>
  <input type="date" id="sdate" name="sdate" value="${fmtsDate}"><br>
  <label for="edate">End Date:</label><br>
  <input type="date" id="edate" name="edate" value="${fmtsDate}"><br>
  <label for="desc">Description:</label><br>
  <textarea id="desc" name="desc" rows=10 cols=30></textarea><br>
   <label for="email">Email:</label><br>
  <input type="text" id="email" value="${ task.email }" name="email"><br>
  <label for="sev">Severity</label><br>
  <select id="sev" name="sev">
  	<option value="high">High</option>
  	<option value="medium">Medium</option>
  	<option value="low">Low</option>
  </select>
  
   
  <br>
  <input type="submit" value="Submit">

</form>
</body>
</html>