package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlacePayloadJson;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlacePayloadJson addPlace_Payload(String name,String language,String address)
	
	{
		Location lc = new Location();
		AddPlacePayloadJson payload = new AddPlacePayloadJson();
		payload.setAccuracy("50");
		payload.setAddress(address);
		payload.setName(name);
		payload.setPhone_number("(+91) 983 893 3936");
		payload.setWebsite("http://google.com");
		payload.setLanguage(language);
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		payload.setTypes(types);
		lc.setLat(-38.383494);
		lc.setLng(33.427362);
		payload.setLocation(lc);
		
		return payload;
		
	}
	
	public String deletePlacePayload(String place_id) {
		return "{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}";
	}

}
