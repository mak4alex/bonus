<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
    <form class="form-horizontal"  method="post" action="${pageContext.request.contextPath}/souvenir/create">
        <fieldset>
            <legend>
                <c:choose>
                    <c:when test="${not empty souvenir.id }">
                        Updating Souvenir
                    </c:when>
                    <c:otherwise>
                        Adding Souvenir
                    </c:otherwise>
                </c:choose>
            </legend>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label" >Name:</label> 
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="name" id="name" required  value="${souvenir.name}" />
                </div>
            </div>
            <div class="form-group">
                <label for="price" class="col-sm-2 control-label" >Price:</label>
                <div class="col-sm-10">
                    <input class="form-control" type="number" min="0.00" step="0.01" name="price" id="price" required  value="${souvenir.price}" />
                </div>      
            </div>
            <div class="form-group">
                <label for="made-date" class="col-sm-2 control-label" >Made Date:</label>
                <div class="col-sm-10">
                    <input class="form-control" type="date" name="made-date" id="made-date" required  value="${souvenir.madeDate}" />
                </div>      
            </div>                
            <div class="form-group">
                <label for="producer-id" class="col-sm-2 control-label" >Producer:</label>
                <div class="col-sm-10">
                    <select id="producer-id" name="producer-id" class="form-control" required>
                        <c:forEach var="producer" items="${producers}">
                            <option value="${producer.id}" >${producer.name}</option>                       
                        </c:forEach>
                    </select>
                </div>
            </div>   
            <c:if test="${not empty souvenir.id}">
                <input type="hidden" name="id" value="${souvenir.id}" />
            </c:if>            
        </fieldset>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a class="btn btn-link" href="${pageContext.request.contextPath}/souvenir">Cancel</a>or 
                <button class="btn btn-primary" type="submit">Submit</button>
            </div>
        </div>
    </form>
</div>