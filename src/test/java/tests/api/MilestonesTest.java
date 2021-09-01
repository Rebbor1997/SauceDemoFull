package tests.api;

import adapters.ProjectsAdapter;
import baseEntities.BaseApiTest;
import endpoints.MilestonesEndpoints;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class MilestonesTest extends BaseApiTest {

    @Test
    public void getMilestone(){
        Milestone milestone = Milestone.builder()
                .id(10)
                .build();

        given()
                .when()
                .get(String.format(MilestonesEndpoints.get_milestone, milestone.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void getMilestones(){
        Project project = Project.builder()
                .id(80)
                .build();

        given()
                .when()
                .get(String.format(MilestonesEndpoints.get_milestones, project.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addMilestones(){
        Project project = Project.builder()
                .id(80)
                .build();
        Milestone milestone = Milestone.builder()
                .name("Mil")
                .due_on(123456)
                .build();
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestone.getName());
        jsonAsMap.put("due_on", milestone.getDue_on());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(MilestonesEndpoints.add_milestones, project.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void updateMilestones(){
        Milestone milestone = Milestone.builder()
                .id(11)
                .name("milestone2")
                .build();
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestone.getName());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(MilestonesEndpoints.update_milestones, milestone.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deleteMilestones(){
        Milestone milestone = Milestone.builder()
                .id(11)
                .name("milestone2")
                .build();
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", milestone.getName());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(MilestonesEndpoints.delete_milestones, milestone.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
