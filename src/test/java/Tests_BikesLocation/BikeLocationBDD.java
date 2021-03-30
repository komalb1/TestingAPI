package Tests_BikesLocation;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//API testing using BDD framework
public class BikeLocationBDD {

    @Test(priority = 1)
    void testGivenLocation(){

        given()
                .when()
                .get( "http://api.citybik.es/v2/networks?fields=id,name,href")
                .then()
             //   .assertThat().body("city",equalTo("Frankfurt"));
             .body("RestResponse.result.location.city",(equalTo("Frankfurt")));
    }

    @Test(priority = 0)
    void testAllLocation(){

        given()
                .when()
                .get( "http://api.citybik.es/v2/networks?fields=id,name,href")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test(priority = 2)
    void testLatitudeLongitude(){

        given()
                .param("id","visa-frankfurt")
                .param("name","VISA")
                .param("href","/v2/networks/visa-frankfurt")
        .when()
                .get( "http://api.citybik.es/v2/networks?fields=id,name,href")
        .then()
                .statusCode(200)
                .assertThat().body("RestResponse.result.location.latitude",equalTo(notNullValue()));
   }

}
