package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.GsonBuilder;
import endpoints.ProjectEndpoints;
import io.restassured.mapper.ObjectMapperType;
import models.Project;
import models.ProjectTypes;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ChainOfTest extends BaseApiTest {
    private int projectID;

    @Test
    public void addProjectTest(){
        Project project = Project.builder()
                .name("PRO18")
                .suite_mode(ProjectTypes.SINGLE_SUITE_BASELINES)
                .show_announcement(true)
                .build();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(ProjectEndpoints.add_project)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void updateProject(){
        Project updatedProject = Project.builder()
                .name("NewPRO18")
                .is_completed(true)
                .build();

        String json = given()
                .body(updatedProject, ObjectMapperType.GSON)
                .when()
                .post(String.format(ProjectEndpoints.update_project, projectID))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response().asString();

        Project newProject = new GsonBuilder().create().fromJson(json, Project.class);

        Assert.assertEquals(updatedProject.getName(), newProject.getName());
        Assert.assertEquals(updatedProject.is_completed(), newProject.is_completed());
    }
}
