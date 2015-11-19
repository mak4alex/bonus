<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container">
    <div class="panel panel-default">    
        <div class="panel-heading">
            <h3 class="panel-title">Souvenirs</h3>
        </div>
        <div class="panel-body">
            <form method="get" action="${pageContext.request.contextPath}/souvenir/search" >

                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="souvenir-name">Name:</label>
                            <input type="text" class="form-control" name="souvenir-name" id="souvenir-name">
                        </div>
                        <div class="form-group">
                            <label for="souvenir-price">Price:</label>
                            <input type="number" min="0.00" step="0.01" class="form-control" name="souvenir-price" id="souvenir-price">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="souvenir-made-country">Made country:</label>
                            <input type="text" class="form-control" name="souvenir-made-country" id="souvenir-made-country">
                        </div>
                        <div class="form-group">
                            <label for="souvenir-producer-name">Producer name:</label>
                            <input type="text" class="form-control" name="souvenir-producer-name" id="souvenir-producer-name">
                        </div>
                    </div>
                </div>


                <button type="submit" class="btn btn-info">Search</button>
            </form>           
        </div>        
        <c:choose>
            <c:when test="${ fn:length(souvenirs) == 0}">
                <ul class="list-group">
                    <li class="list-group-item">There are no souvenirs on your request!</li>
                </ul>        
            </c:when>
            <c:otherwise>
                <table class="table">
                    <tr>
                        <th>#id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Made date</th>
                        <th>Producer</th>
                        <th>Edit</th>
                        <th>Remove</th>                        
                    </tr>
                    <c:forEach var="souvenir" items="${souvenirs}">
                        <tr>
                            <td>${souvenir.id}</td>                                
                            <td><a href="${pageContext.request.contextPath}/souvenir?id=${souvenir.id}">${souvenir.name}</a></td>
                            <td>${souvenir.price}$</td>
                            <td><fmt:formatDate pattern="dd.MM.yyyy" value="${souvenir.madeDate}"/></td>  
                            <td><a href="${pageContext.request.contextPath}/producer?id=${souvenir.producerId}" class="btn btn-link text-warning">${souvenir.producer.name}</a></td>
                            <td><a href="${pageContext.request.contextPath}/souvenir/create?id=${souvenir.id}" class="btn btn-link text-warning">Edit</a></td>
                            <td class="text-danger"><a href="${pageContext.request.contextPath}/souvenir/remove?id=${souvenir.id}" class="btn btn-link text-danger">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>  
        <div class="panel-footer text-right">
            </p>
        </div>  
    </div>    
</div>