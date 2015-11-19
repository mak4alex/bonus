<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${param.title}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/themes/green/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.tablesorter.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</head>
<body>    
    <jsp:include page="/WEB-INF/pages/parts/header.jsp"/>  
    <jsp:include page="/WEB-INF/pages/parts/${param.content}.jsp"/>
    <jsp:include page="/WEB-INF/pages/parts/footer.jsp"/>	
</body>
</html>
