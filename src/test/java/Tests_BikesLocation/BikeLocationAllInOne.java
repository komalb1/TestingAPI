package Tests_BikesLocation;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.request;
import static org.testng.Assert.assertTrue;
//Automation using TestNG Framework
public class BikeLocationAllInOne {
    @Test
      public void GetBikeLocation()
        {
            RestAssured.baseURI ="http://api.citybik.es/v2";
            //requestobject  http://api.citybik.es/v2/networks?fields=visa-frankfurt,VISA,/v2/networks/visa-frankfurt
           // Response getResponse = request(Method.GET,"/networks?fields=id,name,href");
            RequestSpecification requestSpecification =RestAssured.given();
            Response response = request(Method.GET,"/networks?fields=visa-frankfurt,VISA,/v2/networks/visa-frankfurt");

            int statusCode=  response.getStatusCode() ;
            System.out.println("Status code is:" + statusCode);
            Assert.assertEquals(statusCode,200);

            //This will print the response
            String responsebody = response.getBody().asString();
            System.out.println("Response Body is:" + responsebody);
            JsonPath jsonPath = response.jsonPath();
            System.out.println ("City: "+ (jsonPath.get("city")));
            System.out.println ("country: "+ (jsonPath.get("country")));
            System.out.println ("latitude: "+ (jsonPath.get("latitude")));
            System.out.println ("longitude: "+ (jsonPath.get("longitude")));

            assertTrue(responsebody.contains("frankfurt"));

           Assert.assertEquals((jsonPath.get("city")),"Frankfurt");
           Assert.assertEquals((jsonPath.get("country")),"Germany");
           Assert.assertEquals((jsonPath.get("latitude")),"50.1072");
           Assert.assertEquals((jsonPath.get("longitude")),"8.66375");
        }

}
