package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.GsonBuilder;
import endpoints.ProjectEndpoints;
import endpoints.UsersEndpoints;
import io.restassured.mapper.ObjectMapperType;
import models.Project;
import models.ProjectTypes;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestRailApiTest extends BaseApiTest {

    @Test
    public void getAllUsers(){
        String endpoint = "/index.php?/api/v2/get_users";

       given().
               when()
               .get(endpoint)
               .then()
               .log().body()
               .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUserDetailsTest() {
        int userID = 1;
        String endpoint = "/index.php?/api/v2/get_user/%s";

        given()
                .when()
                .get(String.format(endpoint, userID))
                .then()
                .log().body()
                .body("name", is("Alex Tros"))
                .body("email", equalTo("atrostyanko+0601@gmail.com"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllUsersDetailsTest() {
        User user = User.builder()
                .name("Alex Tros")
                .email("atrostyanko+0601@gmail.com")
                .build();

        given()
                .when()
                .get(UsersEndpoints.get_users)
                .then()
                .log().body()
                .body("get(0).name", is(user.getName()))
                .body("get(0).email", equalTo(user.getEmail()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectTest(){
        Project project = Project.builder()
                .name("PRO1")
                .suite_mode(ProjectTypes.SINGLE_SUITE_BASELINES)
                .build();
        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\",\n" +
                        "  \"suite_mode\": \"%d\"\n" +
                        "}", project.getName(), project.getSuite_mode()))
                .when()
                .post(ProjectEndpoints.add_project)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectTest1(){
        Project project = Project.builder()
                .name("PRO1")
                .suite_mode(ProjectTypes.SINGLE_SUITE_BASELINES)
                .build();
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getSuite_mode());
        jsonAsMap.put("show_announcement", true);

        given()
                .body(jsonAsMap)
                .when()
                .post(ProjectEndpoints.add_project)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllProjectDetailsTest() {
        int projectID = 1;
        String endpoint = "/index.php?/api/v2/get_user/%s";

        given()
                .when()
                .get(String.format(endpoint, projectID))
                .then()
                .log().body()
                .body("name", is("Alex Tros"))
                .body("email", equalTo("atrostyanko+0601@gmail.com"))
                .statusCode(HttpStatus.SC_OK);
    }
}
