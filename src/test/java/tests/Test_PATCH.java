package tests;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Test_PATCH {

	@Test
	public void test_01() {
		
		JSONObject request = new JSONObject();  
		System.out.println(request);
		
		// this is better to be used
		System.out.println(request.toJSONString());
		request.put("name", "Stanislav");
		request.put("job", "teacher");
		
		given().
		header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when()
		.patch("https://reqres.in/api/users/2")
		.then().statusCode(200).log().all();
	}

}
