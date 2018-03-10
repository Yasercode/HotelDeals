package response;
//-----------------------------------HotelInfo-----------------------------------

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelInfo {

	@JsonProperty("hotelId")
	private String hotelId;
	@JsonProperty("hotelName")
	private String hotelName;
	@JsonProperty("localizedHotelName")
	private String localizedHotelName;
	@JsonProperty("hotelDestination")
	private String hotelDestination;
	@JsonProperty("hotelDestinationRegionID")
	private String hotelDestinationRegionID;
	@JsonProperty("hotelLongDestination")
	private String hotelLongDestination;
	@JsonProperty("hotelStreetAddress")
	private String hotelStreetAddress;
	@JsonProperty("hotelCity")
	private String hotelCity;
	@JsonProperty("hotelProvince")
	private String hotelProvince;
	@JsonProperty("hotelCountryCode")
	private String hotelCountryCode;
	@JsonProperty("hotelLatitude")
	private Float hotelLatitude;
	@JsonProperty("hotelLongitude")
	private Float hotelLongitude;
	@JsonProperty("hotelStarRating")
	private String hotelStarRating;
	@JsonProperty("hotelGuestReviewRating")
	private Float hotelGuestReviewRating;
	@JsonProperty("hotelReviewTotal")
	private Integer hotelReviewTotal;
	@JsonProperty("hotelImageUrl")
	private String hotelImageUrl;
	@JsonProperty("vipAccess")
	private Boolean vipAccess;
	@JsonProperty("isOfficialRating")
	private Boolean isOfficialRating;
	
	
	//return star rate as image path to view hotel stars as image in result page  
	public String getHotelStarRatingImage(){
		return "/img/"+this.hotelStarRating.substring(0, 1)+".png";
	}

}