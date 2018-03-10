package response;
//-----------------------------------Destination-----------------------------------

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Destination {

	@JsonProperty("regionID")
	private String regionID;
	@JsonProperty("associatedMultiCityRegionId")
	private String associatedMultiCityRegionId;
	@JsonProperty("longName")
	private String longName;
	@JsonProperty("shortName")
	private String shortName;
	@JsonProperty("country")
	private String country;
	@JsonProperty("province")
	private String province;
	@JsonProperty("city")
	private String city;
	@JsonProperty("tla")
	private String tla;
	@JsonProperty("nonLocalizedCity")
	private String nonLocalizedCity;

}
