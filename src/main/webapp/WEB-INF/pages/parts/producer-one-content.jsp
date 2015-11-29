<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container">
    <div class="panel panel-default">     
        <div class="panel-heading">
            <h3 class="panel-title">${producer.name}</h3>
        </div>
        <div class="panel-body">
          <p>This company is from ${producer.country}. It makes next souvenirs:</p>
        </div>        
        <c:choose>
            <c:when test="${ fn:length(producer.souvenirs) == 0}">
                <ul class="list-group">
                    <li class="list-group-item">There are no souvenirs yet.</li>
                </ul>        
            </c:when>
            <c:otherwise>
                <table id="sortable-table" class="table table-striped tablesorter">
                    <thead>
                        <tr>
                            <th>#id</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Made date</th>
                            <th>Edit</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="souvenir" items="${producer.souvenirs}">
                            <tr>
                                <td>${souvenir.id}</td>
                                <td><a href="${pageContext.request.contextPath}/souvenir?id=${souvenir.id}">${souvenir.name}</a></td>
                                <td>$${souvenir.price}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${souvenir.madeDate}"/></td>
                                <td><a href="${pageContext.request.contextPath}/souvenir/create?id=${souvenir.id}" class="btn btn-link text-warning">Edit</a></td>
                                <td class="text-danger"><a href="${pageContext.request.contextPath}/souvenir/remove?id=${souvenir.id}" class="btn btn-link text-danger">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>       
        <div class="panel-footer">
            </p>
            <div class="row">
                <div class="col-sm-6 text-left">
                    <a href="${pageContext.request.contextPath}/producer/diagram?id=${producer.id}" class="btn btn-link text-primary">Souvenir price value structure</a>
                </div>
                <div class="col-sm-6 text-right">
                    <a href="${pageContext.request.contextPath}/producer/create?id=${producer.id}" class="btn btn-link text-warning">Edit</a>
                    <a href="${pageContext.request.contextPath}/producer/remove?id=${producer.id}" class="btn btn-link text-danger">Delete</a>
                </div>
            </div>
        </div> 
  </div>   
</div>