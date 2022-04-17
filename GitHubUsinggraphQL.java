package basic;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GitHubUsinggraphQL {

	public String queryValue = "{\r\n" + 
			"  viewer {\r\n" + 
			"    login\r\n" + 
			"  }\r\n" + 
			"  repository(name: \"Leaftaps\", owner: \"SarathTL\") {\r\n" + 
			"    createdAt\r\n" + 
			"    id\r\n" + 
			"    name\r\n" + 
			"    owner {\r\n" + 
			"      url\r\n" + 
			"    }\r\n" + 
			"  }\r\n" + 
			"}";
	
	
	@Test
	public void getDetails() {
		RestAssured.baseURI = "https://api.github.com/graphql";

		RestAssured
		.given()
		.header("Authorization", "Bearer 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")
		.log().all()
		.contentType(ContentType.JSON)
		.body(getQuery())
		.post()
		.prettyPrint();
	}
	
	
	
	private String getQuery() {
		JSONObject obj = new JSONObject();
		obj.put("query", queryValue);
		return obj.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
