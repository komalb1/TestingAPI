package StepFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;

public class stepDefsGetRequest {


    // Given City Bike API is up and running
    @Given("City Bike API is up and running")
    public void city_bike_api_is_up_and_running(){
        given().baseUri("https://api.citybik.es/v2/networks").get();
           }

    // city as "Frankfurt"
    @Then("I search product with location city as {string}")
    public void when_i_search_product_with_location_city_as(String city){
        throw new cucumber.api.PendingException();
    }

    // status code as 200
    @When("API returns the response with status code")
    public void api_return_responce_with_status_code(){
        given().baseUri("https://api.citybik.es/v2/networks").get().then().assertThat().statusCode(200);
    }
    //    id as "visa-frankfurt"
    @And("Validate id is displayed as {string}")
    public void validate_id_display_as(String id){
        throw new cucumber.api.PendingException();
    }


 /* //   href as "/v2/networks/visa-frankfurt"
    @And("Validate type is href as {string}")
  public void validate type_is_href_as (String href) {
        throw new cucumber.api.PendingException();
    }*/
}
