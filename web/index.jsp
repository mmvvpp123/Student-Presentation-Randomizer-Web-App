<%--
  Created by IntelliJ IDEA.
  User: mmvvpp123
  Date: 6/25/19
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Student Presentation Randomizer</title>
  </head>
  <body>
  <form action="/studentresults" method="post">
    <label for="startTimeInput">Start Time: </label>
    <input type="text" required="true" name="startTime" id="startTimeInput"><br>
    <label for="numberOfStudentsInput">Number of Students:</label>
    <input type="number" required="true" name="numberOfStudents" id="numberOfStudentsInput"><br>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
