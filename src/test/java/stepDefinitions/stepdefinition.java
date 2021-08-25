package stepDefinitions;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import restassured.Testclass;


public class stepdefinition extends Testclass {
	public static Response response;
	public static String jsonresponse;
	Testclass Test=new Testclass();
	JsonPath jsonpath=new JsonPath(jsonresponse);
	List<String> jsonobject;
	String field;
	String check="true";
	@Given("^A rest api$")
	public void a_Rest_api() {
		RestAssured.baseURI ="https://testapi.io/api/ottplatform/media";
	}
	
	@When("^User submits Get request to the api$")
	public void user_Submits_GET_Request() throws IOException {
		  response=   RestAssured.given()
                      .get();
		jsonresponse= response.asString();
		
}
	
	@Then("The HTTP response status code should be {int}")
		public void the_HTTP_Response_Status_Code(int i) {
		 assertTrue("Response status code is ("+response.getStatusCode()+") but expected ("+ i +")", i==response.getStatusCode());
 }
	
	@Then("The HTTP Response time should be below {int} ms")
	public void the_http_response_time_should_be_below_ms(int k) {
		long millis=response.getTime();
        assertTrue("Response Time (" + millis + ") is above (" + k + ")", millis < k);         
	} 

	@Then("The {string} field in response should be never null or empty")
	public void the_id_field_in_response_should_be_never_null_or_empty(String string)  {
	    jsonobject=jsonpath.get("data."+string);
        field= Test.verify_Null_Or_Empty(jsonobject);
        assertTrue("("+string+") field is ("+field+") but expected value", !field.equals(""));
        assertTrue("("+string+") field is ("+field+") but expected value", !field.equals("null"));
	}
	
	@Then("The {string} field should be {string}")
	public void the_segment_type_field_should_be_music(String string,String string2)  {
	   jsonobject = JsonPath.from(jsonresponse).get("data."+string);
	   field=Test.verify_Field_Value(jsonobject,string2);
	   assertTrue("("+string+") field is ("+field+") but expected("+string2+") ",field.equals(string2));
	}
	  
	@Then("The {string} field in {string} on response should be never null or empty")
	public void the_field_in_on_response_should_be_never_null_or_empty(String string, String string2) {
		   jsonobject=	jsonpath.get("data."+string2+"."+string);
		   field=Test.verify_Null_Or_Empty(jsonobject);
		   assertTrue("("+string+") field is ("+field+") but expected value", !field.equals(""));
           assertTrue("("+string+") field is ("+field+") but expected value", !field.equals("null"));
	}

	@Then("The {string} value in {string} field on response should be true for only one track")
	public void the_value_in_field_on_response_should_be_true_for_only_one_track(String string, String string2) {
		jsonobject = JsonPath.from(jsonresponse).get("data."+string+"."+string2);
	    int count= Test.verify_Field_More_Than_Single_Value(jsonobject,"true");
	    assertTrue("More than one or no track in the list has ("+string2+") field in ("+string+") as true", count==1);
	}
	
	@Then("verify the {string} value in response header")
	public void verify_the_value_in_response_header(String string) {
	    field = response.getHeader(string);
	    assertTrue("("+string+") field is ("+field+") but expected value", !field.equals("null"));
	}
}








	   

	

