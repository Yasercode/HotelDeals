package response;
// -----------------------------------Offers-----------------------------------

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Offers {

	@JsonProperty("Hotel")
	private List<Hotel> hotels = null;

}