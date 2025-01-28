package tests;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class Test_POST {

	// we can use gson, jackson(high-performance JSON processor,passer,generator), json, simple json

	@Test
	public void test_01() {
		Map<String , Object> map = new HashMap<String , Object>();
		map.put("name","Stanislav");
		map.put("job", "teacher");
		System.out.println(map);
		
		// parser the data to JSON object
		JSONObject request = new JSONObject(map);  
		System.out.println(request);
		// this is better to be used
		System.out.println(request.toJSONString());
		
		given().
		header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when()
		.post("https://reqres.in/api/users")
		.then().statusCode(201);
	}

	
}
