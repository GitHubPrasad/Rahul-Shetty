import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;
import Files.ReusableMethods;

public class Basics 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
//		given: All input details
//		when: Submit the API
//		then: Validate the response
//		log().all() is used to show all things in Console after script has ran
		
//		Validate if Add place API is working as expected
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response =
		given().log().all()
		.queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace()).
		when()
		.post("maps/api/place/add/json").
		then()
		.assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.41 (Ubuntu)")
		.extract().response().asString();
	
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);  //For parsing json
		
		String placeId = js.getString("place_id");
		System.out.println("Place Id is: "+ placeId);
		
//		Update Place	
		String newAddress = "Shivaji Nagar";
		given().log().all()
		.queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").
		when()
		.put("maps/api/place/update/json").
		then()
		.assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
//		Get Place
		String getPlaceResponse =
		given().log().all()
		.queryParam("key", "qaclick123").queryParam("place_id", placeId).
		when()
		.get("maps/api/place/get/json").
		then()
		.assertThat().log().all().statusCode(200).extract().response().asString();
				
//		Java Related Code
		JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
//		TestNG assert method
		Assert.assertEquals(actualAddress, newAddress);
		
		
		
		
		
		
		
		
	
	}

}
