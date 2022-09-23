<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>
            E-COMMERCE PRODUCT
        </title>
    </head>
    <body>
        <h1>
            Product Details
        </h1>
        <center>
            <h1>products Management</h1>
            <h2>
                <a href="/new">Add New product</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/list">List All products</a>
            </h2>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>List of products</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="product" items="${productlist}">
                    <tr>
                        <td><c:out value="${product.product_id}" /></td>
                        <td><c:out value="${product.product_name}" /></td>
                        <td><c:out value="${product.product_price}" /></td>
                        <td><c:out value="${product.product_weight}" /></td>
                        <td>
                            <a href="/edit?product_id=<c:out value='${product.product_id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/delete?product_id=<c:out value='${product.product_id}' />">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>