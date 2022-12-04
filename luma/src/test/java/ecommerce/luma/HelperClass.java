package ecommerce.luma;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import logs.TestExecutionProp;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;	

public class HelperClass {

	Response httpResponse = null;
	JsonPath jsonPath = null;
	RequestSpecification httpRequestSpecification = null;
	List<String> userDetails = null;
	private final Logger APP_LOGS = TestExecutionProp.getTestExecutionLogsProperties();
	
	public List<String> getUserDetails(){
		RestAssured.baseURI = lumaConstantLib.BASEURI;		
		RequestSpecification request = RestAssured.given(); 
		request.queryParam("key", lumaConstantLib.API_KEY);
		request.queryParam("ref", lumaConstantLib.API_REF);
		
		Response httpResponse = request.get(lumaConstantLib.ENDPOINT);
		APP_LOGS.info("JSON RESPONSE BODY : " + httpResponse.getBody());
		jsonPath= new JsonPath(httpResponse.getBody().asString());

		String name = jsonPath.getString("results[0].customer.name");
		String[] split = name.split("\\s+");
		userDetails = new ArrayList<String>();
		userDetails.add(split[0].toLowerCase());
		userDetails.add(split[1].toLowerCase());
		userDetails.add(userDetails.get(0) + userDetails.get(1) + "@gmail.com");
		userDetails.add(jsonPath.getString("results[0].customer.address.street"));
		userDetails.add(jsonPath.getString("results[0].customer.phone"));
		APP_LOGS.info("User Details : " + userDetails.toString());
		return userDetails;
	}
}
