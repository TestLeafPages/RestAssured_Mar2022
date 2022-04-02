package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentManagement {

	public Response response;
	
	@Given("setup the endpoint")
	public void setEndpoint() {
		RestAssured.baseURI = "https://dev81591.service-now.com/api/now/table/incident";
	}

	@And("setup the authorization")
	public void setAuthentication() {
		RestAssured.authentication = RestAssured.basic("admin", "Test@123");
	}

	@When("send get request")
	public void getIncident() {
		response = RestAssured 
				.given()
				.queryParam("sysparm_fields", "sys_id,number, short_description, category")
				.get();		
	}
	
	@When("send post request with short_description as {string} and category as {string}")
	public void postIncident(String shortDesc,String category) {
		response = RestAssured 
				.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\":\""+shortDesc+"\",\"category\":\""+category+"\"}")
				.post();		
	}

	@Then("Confirm the status code as {int}")
	public void confirmStatusCode(int code) {
		response
		.then()
		.assertThat()
		.statusCode(code);
	}

	@And("print the response")
	public void printResponse() {
		response.prettyPrint();
	}



}
