package response;
// -----------------------------------OfferDateRange-----------------------------------

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferDateRange {

	@JsonProperty("travelStartDate")
	private String[] travelStartDate = null;
	@JsonProperty("travelEndDate")
	private String[] travelEndDate = null;
	@JsonProperty("lengthOfStay")
	private Integer lengthOfStay;
	
	//travel dates is returned as array of integers so I had to override the lombok getter and return the dates 
	// with the accepted format 
	// call toString on the array would resolve[2018,5,3] for example
	public String getTravelStartDate(){
		return Arrays.toString(this.travelStartDate).replaceAll("\\D", " ").trim().replace("  ","-");
	}
	public String getTravelEndDate(){
		return Arrays.toString(this.travelEndDate).replaceAll("\\D", " ").trim().replace("  ","-");
	}

}