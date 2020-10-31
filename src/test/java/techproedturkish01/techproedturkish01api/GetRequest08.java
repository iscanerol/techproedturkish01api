package techproedturkish01.techproedturkish01api;
import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class GetRequest08 extends TestBase{
	/*When I send a GET request to REST API URL
	   https://restful-booker.herokuapp.com/booking/5 
	 Then HTTP Status Code 200 olsun
	 And response content type “application/JSON” olsun
	 And response body asagidaki gibi olsun; 
	 {
	 “firstname”: “Sally”, 
	 “lastname”: “Ericsson”, 
	 “totalprice”: 111,
	 “depositpaid”: false, 
	 “bookingdates”: { 
	          “checkin”: “2017-05-23", 
	          “checkout”:“2019-07-02" }*/
	@Test
	public void get01() {
		spec01.pathParam("bookingid",5);
		Response response = given().
				                spec(spec01).
				            when().
				                get("/booking/5");
		response.prettyPrint();
	//Json formatindaki datalarin icinde gezebilmemizi kolaylastirir
		JsonPath json = response.jsonPath();
		System.out.println(json.getString("firstname"));
		assertEquals("firstname istenilen gibi degil","Sally",json.getString("firstname"));
		
		System.out.println(json.getString("lastname"));
		assertEquals("lastname istenilen gibi degil","Brownn",json.getString("lastname"));
		
		System.out.println(json.getInt("totalprice"));
		assertEquals("totalprice istenilen gibi degil",252,json.getInt("totalprice"));
		
		System.out.println(json.getBoolean("depositpaid"));
		assertEquals("depositpaid istenildigi gibi degil",true,json.getBoolean("depositpaid"));
		
		System.out.println(json.getString("bookingdates.checkin"));
		assertEquals("bookingdates.checkin istenildigi gibi degil","2017-10-22",json.getString("bookingdates.checkin"));
		
		System.out.println(json.getString("bookingdates.checkout"));
		assertEquals("bookingdates.checkout istenildigi gibi degil","2017-10-22",json.getString("bookingdates.checkout"));
	
	
	
	 }

}
