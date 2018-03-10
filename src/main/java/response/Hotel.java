package response;
// -----------------------------------Hotel-----------------------------------

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Hotel {

	@JsonProperty("offerDateRange")
	private OfferDateRange offerDateRange;
	@JsonProperty("destination")
	private Destination destination;
	@JsonProperty("hotelInfo")
	private HotelInfo hotelInfo;
	@JsonProperty("hotelPricingInfo")
	private HotelPricingInfo hotelPricingInfo;
	@JsonProperty("hotelUrls")
	private HotelUrls hotelUrls;

}