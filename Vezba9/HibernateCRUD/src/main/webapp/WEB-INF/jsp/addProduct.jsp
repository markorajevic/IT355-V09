<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@include file="header.jsp" %>

<h1>Add product</h1>
<c:url var="addProduct" value="/addProduct" ></c:url>
    <div class="container">
        <div class="col-md-6 col-md-offset-3">

        <c:url var="post_url"  value="/addProduct/" />
        <form:form method="POST" action="${post_url}" modelAttribute="product">
            <% String success = (String) request.getAttribute("successMsg"); %>
            <%= (success != null) ? "<div class=\"alert alert-success\">"+success+"</div>" : "" %>
            <div class="form-group">
                <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
                <form:label path="name">Name</form:label>
                <form:input type="name" id="name" class="form-control" placeholder="name" path="name" />
            </div>
            <div class="form-group">
                <form:label path="description">Description</form:label>
                <form:input type="description" id="description" class="form-control" placeholder="description" path="description" />
            </div>
            <div class="form-group">
                <form:label path="price">Price</form:label>
                <form:input type="price" id="price" class="form-control" placeholder="price" path="price" />
            </div>
            <div class="form-group">
                <form:label for="category" path="category">Categories</form:label>
                <form:select id="slcRole" class="form-control" path="category">
                    <form:option value="">SELECT</form:option>
                    <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>
            </div>
            <button type="submit" class="btn btn-primary">Add Product</button>
        </form:form>
    </div>
</div>
        
<%@include file="footer.jsp" %>