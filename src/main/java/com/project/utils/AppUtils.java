package com.project.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import response.HotelsResponse;

@Component
public class AppUtils {

	public HotelsResponse getHotelsOffers(String url) {
	    //initialize a rest template client 
		RestTemplate restTemplate = new RestTemplate();
		HotelsResponse hotelsResponse = new HotelsResponse();
		try {
		    //read response into our response object
			hotelsResponse = restTemplate.getForObject(url, HotelsResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hotelsResponse;
	}
	
	
	public  String getCity(String part) throws Exception {
	    String baseUrl = "http://gd.geobytes.com/AutoCompleteCity?callback=&q="+part;
	    StringBuilder result = new StringBuilder();
	      URL url = new URL(baseUrl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
    }

}
