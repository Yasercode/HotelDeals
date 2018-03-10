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
		<page:nav />
		<div class="container-fluid content-area-pro">
			<c:url var="actionUrl" value="/search" />
			<form id="hotel-search-data" action="${actionUrl}" method="post">
				<div id="searchData" class="data-entry-form box-shadow-8">
					<div class="col-xs-12">
						<h3>Search Options</h3>
					</div>
					<div class="col-xs-12 col-md-2">
						<span>Trip would start in</span>
					</div>
					<div class="col-xs-12 col-md-10">
						<input type="text" name="tripMinStartDate"
							class="form-control hasDatePicker" value="" />
					</div>

					<div class="col-xs-12 col-md-2">
						<span>And never after</span>
					</div>
					<div class="col-xs-12 col-md-10">
						<input type="text" name="tripMaxStartDate"
							class="form-control hasDatePicker" value="" />
					</div>
					<div class="col-xs-12 col-md-2">
						<span>Destination</span>
					</div>
					<div class="col-xs-12 col-md-10">
						<input class="ff_elem form-control" type="text"
							name="tripDestination" value="" id="f_elem_city"
							placeholder="enter city name" />
					</div>
					<div class="col-xs-12 col-md-2">
						<span>would stay for(days)</span>
					</div>
					<div class="col-xs-12 col-md-10">
						<input type="number" name="lengthOfStay" value="" min=1
							placeholder="number of days you plan to stay"
							class="form-control">
					</div>
					<div class="col-xs-12 col-md-2">
						<span>Per Night Rate</span>
					</div>
					<div class="col-xs-12 col-md-5">
						<input type="number" name="minHotelRate" value="" min=1
							placeholder="your min target rate" class="form-input" /> USD
					</div>
					<div class="col-xs-12 col-md-5">
						<input type="number" name="maxHotelRate" value="" min=1
							placeholder="your max target rate" class="form-input" /> USD
					</div>
					<div class="col-xs-12 col-md-2">
						<span>Hotel Stars</span>
					</div>
					<div class="col-xs-12 col-md-5">
						<input type="number" name="minHotelStars" value=""
							placeholder=" from ex. 1~5" max="5" class="form-input" /> stars
					</div>
					<div class="col-xs-12 col-md-5">
						<input type="number" name="maxHotelStars" value="" max="5"
							placeholder="enter max star rate" class="form-input" /> stars
					</div>
					<div class="col-xs-12 col-md-2">
						<span>Guest Rating</span>
					</div>
					<div class="col-xs-12 col-md-5">
						<input type="number" name="minGuestRate"
							placeholder="from ex. 0.1~5.0" value="" min="0.1" max="5"
							class="form-input" /> point
					</div>
					<div class="col-xs-12 col-md-5">
						<input type="number" name="maxGuestRate" value="" min="0.1"
							placeholder="enter max rate" max="5" class="form-input" /> point
					</div>
					<div class="col-xs-12 align-right">
						<br />
						<button class="btn btn-primary " type="submit">Search</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>