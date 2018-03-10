<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<html>
<page:header title="Hotel Search" />
<body>
	<div class="wrapper">
		<c:if test="${records>0}">
			<c:set var="pagesCount" value="${(records-records%3)/3+1}" />

			<fmt:parseNumber var="pages" type="number" value="${pagesCount}" />
			<c:set var="message">${records} records in ${pages}  pages</c:set>
		</c:if>
		<c:if test="${records<1}">
			<c:set var="message">no records found</c:set>
		</c:if>
		<page:nav message="${message}" />
		<div class="container-fluid content-area-pro">
			<ul class="nav nav-pills page-headers">
				<c:set var="active" value="active" />
				<c:forEach var="hotel" items="${hotels}" varStatus="counter">
					<c:if test="${counter.count>1 }">
						<c:set var="active" value="" />
					</c:if>
					<c:if test="${counter.count%3 eq 1 }">
						<c:set var="pageCount" value="${(counter.count+2)/3}" />
						<fmt:parseNumber var="page" type="number" value="${pageCount}" />
						<li class="${active}"><a data-toggle="pill"
							href="#ref${counter.count}">${page}</a></li>
					</c:if>
				</c:forEach>
			</ul>
			<div class="tab-content">
				<c:set var="active" value="active" />
				<c:forEach var="hotel" items="${hotels}" varStatus="counter">
					<c:if test="${counter.count>1 }">
						<c:set var="active" value="" />
					</c:if>
					<c:choose>
						<c:when test="${counter.count%3 eq 1 }">
							<c:if test="${counter.count>3}">
			</div>
			</c:if>
			<div id="ref${counter.count}" class="tab-pane fade in ${active}">
				<!--  each result would be viewed in seperate container -->
				<div class="row option-container">
					<div class="col-sm-3 col-md-2 col-xs-12">
						<a href="${hotel.hotelUrls.getUrl()}" target="_blank"> <img
							class="hotel-image"  height="140"
							src="${hotel.hotelInfo.hotelImageUrl}">
						</a>
					</div>
					<div class="col-sm-8 col-md-6 col-xs-12">
						<div>
							<span class="hotel-name">${hotel.hotelInfo.hotelName}</span>
						</div>
						<div>
							<img src="${pageContext.request.contextPath}${hotel.hotelInfo.getHotelStarRatingImage()}"
								width="70" height="15" /> <small>${hotel.hotelInfo.hotelStarRating}stars</small>${hotel.hotelInfo.vipAccess?'VIP Access':''}
						</div>
						<div>
							<span> ${hotel.hotelInfo.hotelStreetAddress},
								${hotel.hotelInfo.hotelCity} </span>
						</div>
						<div>
							<span> ${hotel.destination.country},
								${hotel.destination.city} </span>
						</div>
						<div>
							<span>starts at </span><span class="bold">${hotel.offerDateRange.travelStartDate}</span>||<span>ends&nbsp;in
							</span><span class="bold">${hotel.offerDateRange.travelEndDate}</span>
						</div>
						<div>
							<span>${hotel.offerDateRange.lengthOfStay}&nbsp;Days</span>
						</div>
					</div>
					<div class="col-sm-4 col-xs-12">
						<div>
							<c:set var="isOfficial">${hotel.hotelInfo.isOfficialRating?'green':'blue'}</c:set>
							<span>${hotel.hotelInfo.hotelReviewTotal} reviews with
								rating <span style="color:${isOfficial}">${hotel.hotelInfo.hotelGuestReviewRating}</span>
							</span>
						</div>
						<div>
							<del>
								<span>${hotel.hotelPricingInfo.originalPricePerNight}&nbsp;${hotel.hotelPricingInfo.currency}
									per night </span>
							</del>
						</div>
						<div>
							<span class="offer-price">${hotel.hotelPricingInfo.averagePriceValue}&nbsp;${hotel.hotelPricingInfo.currency}
								<samll> per night</samll>
							</span>
						</div>
						<div>
							<span>Total
								${hotel.hotelPricingInfo.totalPriceValue}&nbsp;${hotel.hotelPricingInfo.currency}
							</span>
						</div>
						<c:if test="${hotel.hotelPricingInfo.percentSavings > 0}">
							<div>
								<span class="saving-msg-block"><i
									class="fa fa-thumbs-o-up"></i> Saving
									${hotel.hotelPricingInfo.percentSavings}% </span>
							</div>
						</c:if>
					</div>
				</div>
				</c:when>
				<c:otherwise>
					<!--  each result would be viewed in seperate container -->
					<div class="row option-container">
						<div class="col-sm-3 col-md-2  col-xs-12">
							<a href="${hotel.hotelUrls.getUrl()}" target="_blank"> <img
								class="hotel-image"  height="140"
								src="${hotel.hotelInfo.hotelImageUrl}">
							</a>
						</div>
						<div class="col-sm-8 col-md-6 col-xs-12">
							<div>
								<span class="hotel-name">${hotel.hotelInfo.hotelName}</span>
							</div>
							<div>
								<img src="${pageContext.request.contextPath}${hotel.hotelInfo.getHotelStarRatingImage()}"
									width="70" height="15" /> <small>${hotel.hotelInfo.hotelStarRating}stars</small>${hotel.hotelInfo.vipAccess?'VIP Access':''}
							</div>
							<div>
								<span> ${hotel.hotelInfo.hotelStreetAddress},
									${hotel.hotelInfo.hotelCity} </span>
							</div>
							<div>
								<span> ${hotel.destination.country},
									${hotel.destination.city} </span>
							</div>
							<div>
								<span>starts at </span><span class="bold">${hotel.offerDateRange.travelStartDate}</span>||<span>ends&nbsp;in
								</span><span class="bold">${hotel.offerDateRange.travelEndDate}</span>
							</div>
							<div>
								<span>${hotel.offerDateRange.lengthOfStay}&nbsp;Days</span>
							</div>
						</div>
						<div class="col-sm-4 col-xs-12">
							<div>
								<c:set var="isOfficial">${hotel.hotelInfo.isOfficialRating?'green':'blue'}</c:set>
								<span>${hotel.hotelInfo.hotelReviewTotal} reviews with
									rating <span style="color:${isOfficial}">${hotel.hotelInfo.hotelGuestReviewRating}</span>
								</span>
							</div>
							<div>
								<del>
									<span>${hotel.hotelPricingInfo.originalPricePerNight}&nbsp;${hotel.hotelPricingInfo.currency}
										per night </span>
								</del>
							</div>
							<div>
								<span class="offer-price">${hotel.hotelPricingInfo.averagePriceValue}&nbsp;${hotel.hotelPricingInfo.currency}
									<samll> per night</samll>
								</span>
							</div>
							<div>
								<span>Total
									${hotel.hotelPricingInfo.totalPriceValue}&nbsp;${hotel.hotelPricingInfo.currency}
								</span>
							</div>
							<c:if test="${hotel.hotelPricingInfo.percentSavings > 0}">
								<div>
									<span class="saving-msg-block"><i
										class="fa fa-thumbs-o-up"></i> Saving
										${hotel.hotelPricingInfo.percentSavings}% </span>
								</div>
							</c:if>
						</div>
					</div>
				</c:otherwise>
				</c:choose>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>