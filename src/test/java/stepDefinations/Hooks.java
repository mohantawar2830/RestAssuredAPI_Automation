package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		addPlaceStepDef m = new addPlaceStepDef();
		System.out.println(addPlaceStepDef.place_id);
		if(addPlaceStepDef.place_id==null) {
			m.add_place_payload_with("mohan", "Japanese", "Asia");
			m.user_calls_with_http_request("AddPlaceAPI", "Post");
			m.verify_place_id_created_maps_to_using("mohan", "getPlaceAPI");
		}
		
		
	}

}
