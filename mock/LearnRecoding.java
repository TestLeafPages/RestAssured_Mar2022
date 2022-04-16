package mock;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LearnRecoding {


	@Test
	public void createIncident() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured 
				.given()
				.contentType(ContentType.JSON)
				.when()
				.post()
				.then()
				.statusCode(201)
				.extract().response();
		System.out.println(response.statusCode());
		response.prettyPrint();
		
	}
	
}
