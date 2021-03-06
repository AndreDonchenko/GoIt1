<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 07.08.2016
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="../header.jsp"/>
<body>
<script>

    function delCategory(categoryName) {
        if (confirm("Delete category?") == true) {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "/admin/dish/categories/delete/" + categoryName, false);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("");
            if (xhttp.status == 400) {
                window.alert("Category could not be deleted!!!");
            } else {
                location.reload();
            }
            location.reload();
        }
    }
</script>

<h3>Add Category</h3>
<form action="categories" method="post">
    <input type="text" name="categoryName" id="categoryName" required value=${categoryName}>
    <input type="submit" value="Add Category">
</form>
<hr>
<table class="table table-striped">
    <tr>
        <th>Dish categories</th>
        <th></th>
    </tr>
    <c:forEach var="category" items="${dishCategories}">
        <tr>
            <td>${category.categoryName}</td>
            <td>
                <button class="btn btn-danger" onclick="delCategory('${category.categoryName}')">Delete</button>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
