package stepDefinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlacePayloadJson;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;

public class addPlaceStepDef extends Utils{
	
	RequestSpecification request;
	ResponseSpecification res;
	Response response;
	static String place_id;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		 request =given().spec(requestSpecification()).body(data.addPlace_Payload(name,language,address));
		 
	}
	
//	@Given("Add Place Payload")
//	public void add_place_payload() throws IOException {
//	   
//	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String Resource,String method) {
		 res =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
// constructor will be called with value of resource which you pass
		 
		APIResources resourceAPI =  APIResources.valueOf(Resource);
		System.out.println(resourceAPI.getResource());
	    if(method.equalsIgnoreCase("Post"))
		 response =request.when().post(resourceAPI.getResource());
	    else if(method.equalsIgnoreCase("Get"))
	    	response =request.when().get(resourceAPI.getResource());
	    
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {  
		
		assertEquals(response.getStatusCode(),200);    
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String value) {
	 
	 assertEquals(getJsonPath(response,keyValue),value);
	}
	
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	 place_id = getJsonPath(response,"place_id");
		request = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource,"GET");
		String actualName = getJsonPath(response,"name");
		assertEquals(actualName,expectedName);
	   
	}
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		request =given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}

}
