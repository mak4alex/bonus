<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
    <form class="form-horizontal"  method="post" action="${pageContext.request.contextPath}/producer/create">
        <fieldset>
            <legend>
                <c:choose>
                    <c:when test="${not empty producer.id }">
                        Updating Producer
                    </c:when>
                    <c:otherwise>
                        Adding Producer
                    </c:otherwise>
                </c:choose>
            </legend>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label" >Name:</label> 
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="name" id="name" required  value="${producer.name}" />
                </div>
            </div>
            <div class="form-group">
                <label for="country" class="col-sm-2 control-label" >Country:</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="country" id="country" required  value="${producer.country}" />
                </div>      
            </div>
            <c:if test="${not empty producer.id}">
                <input type="hidden" name="id" value="${producer.id}" />
            </c:if>            
        </fieldset>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a class="btn btn-link" href="${pageContext.request.contextPath}/producer">Cancel</a>or 
                <button class="btn btn-primary" type="submit">Submit</button>
            </div>
        </div>
    </form>
</div>