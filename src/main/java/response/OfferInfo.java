package response;
// -----------------------------------OfferInfo-----------------------------------

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferInfo {

	@JsonProperty("siteID")
	private String siteID;
	@JsonProperty("language")
	private String language;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("userSelectedCurrency")
	private String userSelectedCurrency;

}