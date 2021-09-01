package tests.api;

import baseEntities.BaseApiTest;
import endpoints.CasesEndpoints;
import models.Cases;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CasesTest extends BaseApiTest {

    @Test
    public void getCaseTest(){
        Cases cases = Cases.builder()
                .id(8)
                .build();
        given()
                .when()
                .get(String.format(CasesEndpoints.get_case, cases.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void getCasesTest() {
        Project project = Project.builder()
                .id(101)
                .build();
        Cases cases = Cases.builder()
                .suiteID(83)
                .build();

        given()
                .when()
                .get(String.format(CasesEndpoints.get_cases, project.getId(), cases.getSuiteID()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getHistoryForCase(){
        Cases cases = Cases.builder()
                .id(8)
                .build();
        given()
                .when()
                .get(String.format(CasesEndpoints.get_history_for_case, cases.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addCase(){
        Cases cases = Cases.builder()
                .title("First cases")
                .sectionID(3)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("title", cases.getTitle());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(CasesEndpoints.add_case, cases.getSectionID()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void copyCasesToSection(){
        Cases cases = Cases.builder()
                .sectionID(3)
                .case_ids("6, 5")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("case_ids", cases.getCase_ids());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(CasesEndpoints.copy_cases_to_section, cases.getSectionID()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void updateCase(){
        Cases cases = Cases.builder()
                .id(5)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", cases.getId());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(CasesEndpoints.update_case, cases.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

   @Test
    public void updateCases(){
        Cases cases = Cases.builder()
                .title("Case1")
                .suiteID(83)
                .case_ids("10, 14")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("title", cases.getTitle());
        jsonAsMap.put("suiteID", cases.getSuiteID());
        jsonAsMap.put("case_ids", cases.getCase_ids());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(CasesEndpoints.update_cases, cases.getSuiteID()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void moveCasesToSection(){
        Cases cases = Cases.builder()
                .sectionID(3)
                .case_ids("6, 5")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("sectionID", cases.getSectionID());
        jsonAsMap.put("case_ids", cases.getCase_ids());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(CasesEndpoints.move_cases_to_section, cases.getSectionID()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deleteCaseTest(){
        Cases cases = Cases.builder()
                .id(5)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", cases.getId());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(CasesEndpoints.delete_case, cases.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void deleteCasesTest(){
        Cases cases = Cases.builder()
                .suiteID(83)
                .build();
        Project project = Project.builder()
                .id(101)
                .build();
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("suiteID", cases.getSuiteID());

        given()
                .body(jsonAsMap)
                .when()
                .post(String.format(CasesEndpoints.delete_cases, project.getId()))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}



