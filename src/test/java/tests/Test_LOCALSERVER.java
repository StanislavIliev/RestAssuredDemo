package tests;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.json.simple.JSONObject;


public class Test_LOCALSERVER {
	// mockoon.com run mock REST API servers
	// npm install -g json-server
	//json-server --watch db.json
	
	@Test
	public void test_01() {
		baseURI ="http://localhost:3000/";
		given().get("/users").then().statusCode(200).log().all();
	}
	
	
	@Test
	public void test_02() {
		baseURI ="http://localhost:3000/";
		
		given().
		param("name","Automation").
		get("/subjects").then().statusCode(200).log().all();
		
	}

	
	@Test
	public void test_03() {
		baseURI ="http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Tom");
		request.put("lastName", "Cooper");
		request.put("subjectId", 1);
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).when().post("/users").
		then().statusCode(201).log().all();
	}
	
	@Test
	public void test_04() {
		baseURI ="http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Sheper");
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).when().patch("/users/4").
		then().statusCode(200).log().all();
	}
	
	@Test
	public void test_05() {
		baseURI ="http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Mary");
		request.put("lastName", "Jane");
		request.put("subjectId", 1);
		
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).when().put("/users/4").
		then().statusCode(200).log().all();
	}

	@Test
	public void test_06() {
		baseURI ="http://localhost:3000/";
		
		when().delete("/users/4").then().statusCode(204);
	}
}
