<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page"%>
<%@ attribute name="message" required="false" type="java.lang.String"%>
  <nav class="navbar navbar-default navbar-fixed-top p-5-bottom box-shadow-2 ">
  <div class="container-fluid ">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header col-md-2">
         <c:url var="home" value="/home"/>
         <a href="${home}"><img src="${pageContext.request.contextPath}/img/hotels.jpg"  width="45" height="55" alt="Logo" style="top: 3px;
    position: relative"></a>
    </div>
    <div class=" row col-md-10 col-sm-12">
            <ul class="nav nav-pills ">
            <li>
             <span class="msg-block">${message}</span>
            </li>
          </ul>
        </div>
     </div>
   <jsp:doBody />
</nav>
