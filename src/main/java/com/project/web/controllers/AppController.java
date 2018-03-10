package com.project.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.utils.AppUtils;

import response.Hotel;
import response.HotelsResponse;

@Controller
public class AppController {

	@Autowired
	AppUtils appUtils;

	private static final String VIEW_HOME_PAGE = "home";
	private static final String VIEW_RESULT_PAGE = "result";

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String getHomePage(Model model) {
		return VIEW_HOME_PAGE;
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String getHotelsData(@RequestParam(value = "tripMinStartDate", required = false) String tripMinStartDate,
			@RequestParam(value = "tripMaxStartDate", required = false) String tripMaxStartDate,
			@RequestParam(value = "tripDestination", required = false) String tripDestination,
			@RequestParam(value = "lengthOfStay", required = false) String lengthOfStay,
			@RequestParam(value = "minHotelRate", required = false) String minHotelRate,
			@RequestParam(value = "maxHotelRate", required = false) String maxHotelRate,
			@RequestParam(value = "minHotelStars", required = false) String minHotelStars,
			@RequestParam(value = "maxHotelStars", required = false) String maxHotelStars,
			@RequestParam(value = "minGuestRate", required = false) String minGuestRate,
			@RequestParam(value = "maxGuestRate", required = false) String maxGuestRate, Model model) {
		String baseUrl = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
		if (!tripMinStartDate.isEmpty())
			baseUrl += "&minTripStartDate=" + tripMinStartDate;
		if (!tripMaxStartDate.isEmpty())
			baseUrl += "&maxTripStartDate=" + tripMaxStartDate;
		if (tripDestination != null)
			baseUrl += "&destinationName=" + tripDestination;
		if (!lengthOfStay.isEmpty())
			baseUrl += "&lengthOfStay=" + lengthOfStay;
		if (!minHotelRate.isEmpty())
			baseUrl += "&minAverageRate=" + minHotelRate;
		if (!maxHotelRate.isEmpty())
			baseUrl += "&maxAverageRate=" + maxHotelRate;
		if (!minHotelStars.isEmpty())
			baseUrl += "&minHotelStars=" + minHotelStars;
		if (!maxHotelStars.isEmpty())
			baseUrl += "&maxStarRating=" + maxHotelStars;
		if (!minGuestRate.isEmpty())
			baseUrl += "&minGuestRating=" + minGuestRate;
		if (!maxGuestRate.isEmpty())
			baseUrl += "&maxGuestRating=" + maxGuestRate;
		//after checking all search constrains call api with the proper url
		HotelsResponse response = this.appUtils.getHotelsOffers(baseUrl);
		//prepare a list of offers returned to pass it to result page
		List<Hotel> hotels = response.getOffers().getHotels();
		model.addAttribute("hotels", hotels);
		//pass the number of records returned to the page and zero if none
		model.addAttribute("records", hotels != null ? hotels.size() : 0);
		return VIEW_RESULT_PAGE;
	}
	
	@RequestMapping(value = { "/autocomplete" }, method = RequestMethod.GET)
	@ResponseBody
    public String getCities(@RequestParam(value = "part", required = true) String part) {
	    String result=part;
        try {
          result= this.appUtils.getCity(part);
        } catch (Exception e) {
           System.out.println("error while autocomlete city name");
        }
        return result;
    }

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ssz yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		sdf2.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf2, true));
	}

}
