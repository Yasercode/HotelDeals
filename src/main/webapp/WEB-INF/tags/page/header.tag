<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="title" required="true" type="java.lang.String"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.offcanvas.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/moment.js"></script>
<script src="${pageContext.request.contextPath}/js/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
<script type="text/javascript">
     var contextPath = "${pageContext.request.contextPath}";
</script>     
</head>