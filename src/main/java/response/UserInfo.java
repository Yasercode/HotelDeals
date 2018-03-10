package response;
// -----------------------------------UserInfo-----------------------------------

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class UserInfo {

	@JsonProperty("persona")
	private Persona persona;
	@JsonProperty("userId")
	private String userId;

}