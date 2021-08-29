package baseEntities;

import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
  //  public static Logger logger = Logger.getLogger(BaseApiTest.class);


    @BeforeTest
    public void setup (){
        RestAssured.baseURI = ReadProperties.getInstance().getTestRailURL();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(
                        ReadProperties.getInstance().getApiUsername(),
                        ReadProperties.getInstance().getApiPassword());
    }
}
