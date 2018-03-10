package response;
// -----------------------------------Persona-----------------------------------

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {

	@JsonProperty("personaType")
	private String personaType;

}