package response;
// -----------------------------------HotelPricingInfo-----------------------------------

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HotelPricingInfo {

	@JsonProperty("averagePriceValue")
	private Float averagePriceValue;
	@JsonProperty("totalPriceValue")
	private Float totalPriceValue;
	@JsonProperty("crossOutPriceValue")
	private Float crossOutPriceValue;
	@JsonProperty("originalPricePerNight")
	private Float originalPricePerNight;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("percentSavings")
	private Float percentSavings;
	@JsonProperty("drr")
	private Boolean drr;

}