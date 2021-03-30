package commanInfo;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;

public class testBase {
    public static RequestSpecification requestSpecification;
    public static Response response;
    public Logger logger;
    public String id = "visa-frankfurt";
    public String name = "VISA";
    public String href = "/v2/networks/visa-frankfurt";
  //  response = request(Method.GET,"/networks?fields=visa-frankfurt,VISA,/v2/networks/visa-frankfurt");

    @BeforeClass
    public void setup() {
        logger = Logger.getLogger("BikeLocationAPI");
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
    }
}
