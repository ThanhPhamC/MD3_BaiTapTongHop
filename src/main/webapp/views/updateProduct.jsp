<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamthanh
  Date: 12/11/2022
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/ProductServlet" method="post">
    <table border="1">
        <tr>
            <td>Id</td>
            <td><input type="text" value="${product.productId}" name="Id" readonly></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" value="${product.productName}" name="Name" ></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" value="${product.productPrice}" name="Price" ></td>
        </tr>
        <tr>
            <td>Creat Date</td>
            <td><input type="date" value="${pr.dateCreated}" name="Creat Date"></td>
        </tr>
        <tr>
            <td>Descriptions</td>
            <td><input type="text" value="${product.descriptions}" name="Descriptions"></td>
        </tr>
        <tr>
            <td>Status</td>
            <td>
            <c:choose>
                <c:when test="${product.productStatus}">
                    <input type="radio" value="true" id="active" checked name="status"><label for="active">Active</label>
                    <input type="radio" value="false" id="inActive" name="status"><label for="inActive">In Active</label>
                </c:when>
                <c:otherwise>
                    <input type="radio" value="true" id="active"  name="status"><label for="active">Active</label>
                    <input type="radio" value="false" id="inActive" checked name="status"><label for="inActive">In Active</label>
                </c:otherwise>
            </c:choose>
            </td>
        </tr>
<tr><td colspan="2">
    <input type="submit" value="Update" name="action">
</td></tr>
    </table>
</form>
</body>
</html>
