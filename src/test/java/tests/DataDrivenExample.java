package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Parameters;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample {
 
	@DataProvider(name = "DataForPost")
	public Object [][] dataForPost(){
		Object [][] data= new Object[2][3];
		
		data[0][0] = "Albert";
		data[0][1] = "Einstein";
		data[0][2] = "2";
		
		data[1][0] = "Thomas";
		data[1][1] = "Edison";
		data[1][2] = "1";
		return data;
	}
	
	
	@Test(dataProvider = "DataForPost") 
	public void test_01(String firstName, String lastName, int subjectId) {
		
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
		baseURI ="http://localhost:3000/";
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).
		when().post("/users").
		then().
		statusCode(200).log().all();
	
	}
		@DataProvider(name = "DeleteData")
		public Object[] dataForDelete() {
		
			return new Object[]{
					4,5,6,7,8
			};
		}
	
		@Test(dataProvider = "DeleteData")
		public void test_02(int userId) {
		
				given().
				delete("users/"+userId).
				then().
				statusCode(204);
		}
		
		//parameters when we do not have enough information. this usedId is coming from file called s.testNg.xml 
		@Parameters({"userId"})
		@Test
		public void test_03(int userId) {
		
				given().
				delete("users/"+userId).
				then().
				statusCode(204);
		}
}
