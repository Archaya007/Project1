<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
    <center>
        <h1>Products Management</h1>
        <h2>
            <a href="/new">Add New Product</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Produts</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${products != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${products == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${products != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${products == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
                <c:if test="${products != null}">
                    <input type="hidden" name="id" value="<c:out value='${Product.Product_id}' />" />
                </c:if>           
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${Product.Product_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Author: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${Product.Product_price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${Product.Product_weight}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>