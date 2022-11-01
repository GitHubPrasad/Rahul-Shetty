import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Basics {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//Validate if Add place API is working as expected
		
//		given: All input details
//		when: Submit the API
//		then: Validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all()
		.queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\"location\":{\"lat\":-38.383494,\"lng\":33.427362},\"accuracy\":50,\"name\":\"Frontline house\",\"phone_number\":\"(+91) 983 893 3937\",\"address\":\"29, side layout, cohen 09\",\"types\":[\"shoe park\",\"shop\"],\"website\":\"http://google.com\",\"language\":\"French-IN\"}").
		when().log().all()
		.post("maps/api/place/add/json").
		then().log().all()
		.assertThat().statusCode(200);
	
	
	
	}

}