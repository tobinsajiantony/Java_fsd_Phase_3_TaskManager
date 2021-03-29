
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

<form action="updateTask" method="post">
 <input type="hidden" id="id" value="${ task.id }" name="taskId"><br>
 <input type="hidden" id="id" value="${ userId }" name="userId">
 <label for="name">Name:</label><br>
  <input type="text" id="name" value="${ task.name }" name="name"><br><br>
  <label for="sdate">Start Date:</label><br>
 <fmt:formatDate var="fmtsDate" value="${task.startDate}" pattern="yyyy-MM-dd"/>
<input type="date" name="sdate" value="${fmtsDate}"/><br><br>
  <label for="edate">End Date:</label><br>
   <fmt:formatDate var="fmteDate" value="${task.endDate}" pattern="yyyy-MM-dd"/>
<input type="date" name="edate" value="${fmteDate}"/><br><br>
  <label for="desc">Description:</label><br>
  <textarea id="desc" name="desc" ${ task.description } rows=10 cols=30>${ task.description }</textarea><br><br>
  <label for="sev">Severity</label><br>
  <select id="sev" name="sev">
  	<option value="high" ${task.severity == "high" ? 'selected="selected"' : ''}>High</option>
  	<option value="medium" ${task.severity == "medium" ? 'selected="selected"' : ''}>Medium</option>
  	<option value="low" ${task.severity == "low" ? 'selected="selected"' : ''}>Low</option>
  </select><br><br>
 <input type="submit" value="Update">

</form>
</body>
</html>