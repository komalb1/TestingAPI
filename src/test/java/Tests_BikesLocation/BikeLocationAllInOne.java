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
          //  System.out.println("Response Body is:" + responsebody);
            JsonPath jsonPath = response.jsonPath();
            jsonPath.param("id","visa-frankfurt");
            jsonPath.param("href","/v2/networks/visa-frankfurt");
            jsonPath.param("name","VISA");
/*            System.out.println ("City: "+ (jsonPath.param(".location.city","Frankfurt")));
            System.out.println ("country: "+ (jsonPath.param(".location.country", "Germany")));
            System.out.println ("latitude: "+ (jsonPath.param(".location.latitude","50.1072")));
            System.out.println ("longitude: "+ (jsonPath.param(".location.longitude","8.66375")));*/

           Assert.assertEquals((jsonPath.get(".location.city")),"Frankfurt");
           Assert.assertEquals((jsonPath.get(".location.country")),"Germany");
           Assert.assertEquals((jsonPath.get(".location.latitude")),"50.1072");
           Assert.assertEquals((jsonPath.get(".location.longitude")),"8.66375");
        }

}
