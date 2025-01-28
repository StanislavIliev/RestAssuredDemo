package jsonTests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class JsonSchemaValidator {

	@Test
	public void testGet() {
		baseURI = "https://reqes.in/api";
		
		given().get("/users?page=2").
		then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200);
		// .body("data[4].first_name",equalTo("George")).
		// body("data.first_name",hasItems("George","Rachel"));
	}
}
