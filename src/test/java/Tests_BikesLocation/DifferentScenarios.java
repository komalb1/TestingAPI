package Tests_BikesLocation;

import commanInfo.testBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DifferentScenarios extends testBase {
    @BeforeClass
    void getAllLocation() throws InterruptedException {
       // logger.info("*******Testcase to see all Location****************");

        RestAssured.baseURI = "http://api.citybik.es/v2";
        requestSpecification = RestAssured.given();
        //requestobject  http://api.citybik.es/v2/networks?fields=visa-frankfurt,VISA,/v2/networks/visa-frankfurt
        // Response getResponse = request(Method.GET,"/networks?fields=id,name,href");
        response = requestSpecification.request(Method.GET, "/networks?fields=id,name,href");
        Thread.sleep(3);
    }

    @Test
    void checkResponseBody() {
      //  logger.info("*********************Checking Response Body********************");

        String responseBody = response.getBody().asString();
      //  logger.info("Response Body:  " + responseBody);
        System.out.println("Response Body:  " + responseBody);
        Assert.assertNotNull(responseBody);
    }

    @Test
    void CheckStatusCode() {
        //logger.info("*********************Checking Response Body********************");
        int statusCode = response.getStatusCode();
     //   logger.info("Status Code is:  " + statusCode);
        System.out.println("Status Code is:  " + statusCode);
        Assert.assertEquals(statusCode,200);
        }


}
