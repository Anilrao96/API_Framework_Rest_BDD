package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPet;
import resources.APIResources;
import resources.TestBuilderData;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepdefinitions extends Utils {
    RequestSpecification res;
    //TestBuilderData data = new TestBuilderData();
    ResponseSpecification resspec;
    TestBuilderData data = new TestBuilderData();
    Response response;
    //ststic String Placeid >> This means, for every scenario run , this palceid value will be stored, if static is not given, placeid is always null
    @Given("Add pet payload with {string} {string}")
    public void add_pet_payload_with(String name, String status) throws IOException {

        // Write code here that turns the phrase above into concrete actions


        res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name, status));




//        Response response = given().log().all()
//                .body(p)
//            .when()
//  .post("/v2/pet").then().extract().response();
//        System.out.println(response.asString());
        System.out.println("hello");

    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        //constructor will be called with value of resource which you pass
        APIResources resourceAPI = APIResources.valueOf(resource);
        resourceAPI.getResource();
        System.out.println(resourceAPI.getResource());
        resspec = new ResponseSpecBuilder().expectStatusCode(200).build();
        if(method.equalsIgnoreCase("POST"))
        response = res.when().post(resourceAPI.getResource()).then().spec(resspec).extract().response();
        else if (method.equalsIgnoreCase("GET"))
            response = res.when().get(resourceAPI.getResource()).then().spec(resspec).extract().response();
        else if (method.equalsIgnoreCase("DELETE"))
            response = res.when().get(resourceAPI.getResource()).then().spec(resspec).extract().response();;

        //;
    }


//    }
    @Then("API call got success with status code {int}")
    public void api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(response.getStatusCode());
        assertEquals(response.getStatusCode(),200);



    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String expectedvalue) {
        // Write code here that turns the phrase above into concrete actions

        assertEquals(getJsonPath(response,key), expectedvalue);

    }


    @Given("DeletePayload Payload")
    public void delete_payload_payload() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        given().spec(requestSpecification()).body(data.deletePet());
    }

}
