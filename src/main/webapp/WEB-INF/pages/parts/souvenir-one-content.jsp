<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">${souvenir.name}</h3>
        </div>
        <ul class="list-group">
            <li class="list-group-item">Price: ${souvenir.price}$</li>
            <li class="list-group-item">Made date: <fmt:formatDate pattern="dd.MM.yyyy" value="${souvenir.madeDate}"/></li>
            <li class="list-group-item">Producer: <a href="${pageContext.request.contextPath}/producer?id=${souvenir.producerId}" class="btn btn-link text-warning">${souvenir.producer.name}</a></li>
        </ul>
        <div class="panel-footer text-right">
            </p>
            <a href="${pageContext.request.contextPath}/souvenir/create?id=${souvenir.id}" class="btn btn-link text-warning">Edit</a>
            <a href="${pageContext.request.contextPath}/souvenir/remove?id=${souvenir.id}" class="btn btn-link text-danger">Delete</a>
        </div>
    </div>
</div>