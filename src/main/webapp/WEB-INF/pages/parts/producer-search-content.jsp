<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container">
    <div class="panel panel-default">    
        <div class="panel-heading">
            <h3 class="panel-title">Producers</h3>
        </div>
        <div class="panel-body">
            <form method="get" action="${pageContext.request.contextPath}/producer/search" >
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="producer-name">Producer name:</label>
                            <input type="text" class="form-control" name="producer-name" id="producer-name">
                        </div>
                        <div class="form-group">
                            <label for="producer-country">Producer country:</label>
                            <input type="text" class="form-control" name="producer-country" id="producer-country">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="souvenir-max-price">Souvenir max price:</label>
                            <input type="number" min="0.00" step="0.01" class="form-control" name="souvenir-max-price" id="souvenir-max-price">
                        </div>
                        <div class="form-group">
                            <label for="souvenir-made-year">Souvenir made in year:</label>
                            <input type="number" min="0" step="1" class="form-control" name="souvenir-made-year" id="souvenir-made-year">
                        </div>
                    </div>
                </div>

                <button type="submit" class="btn btn-info">                    
                    Search
                </button>
            </form>           
        </div>        
        <c:choose>
            <c:when test="${ fn:length(producers) == 0}">
                <ul class="list-group">
                    <li class="list-group-item">There are no producers on your request.</li>
                </ul>        
            </c:when>
            <c:otherwise>
                <table class="table">
                    <tr>
                        <th>#id</th>
                        <th>Name</th>
                        <th>Country</th>
                        <th>Edit</th>
                        <th>Remove</th>
                    </tr>
                    <c:forEach var="producer" items="${producers}">
                        <tr>
                            <td>${producer.id}</td>                                
                            <td><a href="${pageContext.request.contextPath}/producer?id=${producer.id}">${producer.name}</a></td>
                            <td>${producer.country}</td>  
                            <td><a href="${pageContext.request.contextPath}/producer/create?id=${producer.id}" class="btn btn-link text-warning">Edit</a></td>
                            <td class="text-danger"><a href="${pageContext.request.contextPath}/producer/remove?id=${producer.id}" class="btn btn-link text-danger">Delete</a></td>
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
