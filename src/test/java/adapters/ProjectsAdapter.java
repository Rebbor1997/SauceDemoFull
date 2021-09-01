package adapters;

import com.google.common.reflect.TypeToken;
import endpoints.ProjectEndpoints;
import io.restassured.response.Response;
import models.Project;
import models.ProjectsList;
import org.apache.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProjectsAdapter extends BaseAdapter{

    public List<Project> get(){
        Response response = given()
                .when()
                .get(ProjectEndpoints.get_projects)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        return gson.fromJson(response.asString().trim(), new TypeToken<List<Project>>(){}.getType());
    }

    public int get(Project project){
        for (Project actualProject: get()) {
            if (project.equals(actualProject)) return actualProject.getId();
        }
       return 0;
    }

    public Project get(int projectID){

        Response response = given()
                .when()
                .get(String.format(ProjectEndpoints.get_project, projectID))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        return gson.fromJson(response.asString().trim(), Project.class);
    }
}
