<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container">
    <div class="panel panel-default">    
        <div class="panel-heading">
            <h3 class="panel-title">Producers</h3>
        </div>
        <div class="panel-body">
          <p>Some description text here...</p>
        </div>
        
        <c:choose>
            <c:when test="${ fn:length(producers) == 0}">
                <ul class="list-group">
                    <li class="list-group-item">There are no producers yet. Add one!</li>
                </ul>        
            </c:when>
            <c:otherwise>
                <table id="sortable-table" class="table table-striped tablesorter">
                    <thead>
                        <tr>
                            <th>#id</th>
                            <th>Name</th>
                            <th>Country</th>
                            <th>Edit</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producer" items="${producers}">
                            <tr>
                                <td>${producer.id}</td>
                                <td><a href="${pageContext.request.contextPath}/producer?id=${producer.id}">${producer.name}</a></td>
                                <td>${producer.country}</td>
                                <td><a href="${pageContext.request.contextPath}/producer/create?id=${producer.id}" class="btn btn-link text-warning">Edit</a></td>
                                <td class="text-danger"><a href="${pageContext.request.contextPath}/producer/remove?id=${producer.id}" class="btn btn-link text-danger">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>       
        <div class="panel-footer text-right">
            </p>
        </div>  
    </div>    
</div>