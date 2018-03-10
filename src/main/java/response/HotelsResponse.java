
package response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

//-----------------------------------HotelsResponse-----------------------------------

@Getter
@Setter
public class HotelsResponse {

	@JsonProperty("offerInfo")
	private OfferInfo offerInfo;
	@JsonProperty("userInfo")
	private UserInfo userInfo;
	@JsonProperty("offers")
	private Offers offers;

}








