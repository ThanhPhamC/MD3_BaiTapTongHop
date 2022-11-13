<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamthanh
  Date: 11/11/2022
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ProductServlet" method="post">
<table border="1" style="border-collapse: collapse" >

  <tr>
    <td>Name</td>
    <td><input type="text" name="Name"></td>
  </tr>
  <tr>
    <td>Price</td>
    <td><input type="text" name="Price"></td>
  </tr>
  <tr>
    <td>Creat Date</td>
    <td><input type="date" name="Creat Date"></td>
  </tr>
  <tr>
    <td>Descriptions</td>
    <td><input type="text" name="Descriptions"></td>
  </tr>
  <tr>
    <td>Status</td>
    <td><input type="radio" value="true" id="active" name="status"/><label for="active">Active</label>
      <input type="radio" value="false" id="inactive" name="status"/><label for="inactive">In Active</label>
    </td>
  </tr>
  <tr>
   <td><input type="submit" value="Creat" name="action"></td>
  </tr>
</table>
</form>
</body>
</html>
