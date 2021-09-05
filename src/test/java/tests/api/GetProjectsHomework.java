package tests.api;

import baseEntities.BaseApiTest;
import endpoints.ProjectEndpoints;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProjectsHomework  extends BaseApiTest {
    @Test
    public void getProject(){
        int projectID = 80;

        given()
                .when()
                .get(String.format(ProjectEndpoints.get_project, projectID))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllProjects(){

        given().
                when()
                .get(ProjectEndpoints.get_projects)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
