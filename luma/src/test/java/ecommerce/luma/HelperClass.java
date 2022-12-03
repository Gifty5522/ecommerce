package ecommerce.luma;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;	

public class HelperClass {

	Response httpResponse = null;
	String[] split = null;
	JsonPath jsonPath = null;
	RequestSpecification httpRequestSpecification = null;
	
	public void getUserDetails(){
//		RestAssured.baseURI = "https://randomuser.me/";
//		httpRequestSpecification = RestAssured.given();
//		httpResponse = httpRequestSpecification.get("api").pa;
//		System.out.println("User Details : " + httpResponse.getBody().asString());
//		jsonPath= new JsonPath(httpResponse.getBody().asString());
		
		
		RestAssured.baseURI = "https://randomuser.me/";
		given().log().all().
			queryParam("key", "JKL4-Z96P-MPWJ-P98O")
//			queryParam("ref", "wzbn2gcz")
		.when().get("api/wzbn2gcz")
		.then().log().all().assertThat().statusCode(200);
	}
	
}
