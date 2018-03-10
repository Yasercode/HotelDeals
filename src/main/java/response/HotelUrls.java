package response;
// -----------------------------------HotelUrls-----------------------------------

import java.net.URISyntaxException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelUrls {

	@JsonProperty("hotelInfositeUrl")
	private String hotelInfositeUrl;
	@JsonProperty("hotelSearchResultUrl")
	private String hotelSearchResultUrl;
	
	public  String getUrl() throws URISyntaxException{
		return  new java.net.URI(this.hotelInfositeUrl).getPath();	
	}

}