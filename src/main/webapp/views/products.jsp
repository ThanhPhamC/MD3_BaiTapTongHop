<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: phamthanh
  Date: 11/11/2022
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ProductServlet" method="post">
    <button style="margin-bottom: 10px"><a style="text-decoration: none" href="views/newProduct.jsp">Add Product</a></button>
    <input style="width: 250px" type="text" name="searchProduct" placeholder="ten hoac gia(x.xxx.xxx~x.xxx.xxx)" >
    <input type="submit" value="Search" name="action">
    <input type="submit" value="SortByPrice" name="action">
</form>
<table border="1" style="border-collapse: collapse" >
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Creat Date</td>
        <td>Descriptions</td>
        <td>Status</td>
        <td>Actions</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="pr">
        <tr>
        <td>${pr.productId}</td>
        <td>${pr.productName}</td>
        <td>${pr.productPrice}</td>
        <td><ftm:formatDate value="${pr.dateCreated}" pattern="dd-MM-YYYY"/></td>
        <td>${pr.descriptions}</td>
        <td>${pr.productStatus? "Active":"Inactive"}</td>
            <td>
                <button><a href="<%=request.getContextPath()%>/ProductServlet?productId=${pr.productId}&&action=Update">Update</a></button>
                <button><a href="<%=request.getContextPath()%>/ProductServlet?productId=${pr.productId}&&action=Delete">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
