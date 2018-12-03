<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@include file="header.jsp" %>

<h1>Product list</h1>
<c:if test="${!empty products}">

    <table class="table table-striped">
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Category</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody> 
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.category}</td>
                    <td><a href="<c:url value='/editProduct/${product.id}' />">edit</a></td>
                    <td><a href="<c:url value='/deleteproduct/${product.id}' />">delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<%@include file="footer.jsp" %>