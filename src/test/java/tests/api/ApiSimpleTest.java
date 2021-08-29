package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiSimpleTest extends BaseApiTest {

   // ДЗ - 15 тестов REST API- запросов на reqres.in

    @Test
    public void test() {
        String endpoint = "/api/users?page=2";

        //Настройка RestAssured
        RestAssured.baseURI ="https://reqres.in/";

        //Setup Request
        RequestSpecification httpRequest = given();

        //Setup Response
        Response response = httpRequest.request(Method.GET, endpoint);

        //Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        //Get Response status
        int statusCode =  response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    // Второй вариант запроса
    @Test
    public void listUsersTest(){
        given()
                .with()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void singleUserTest(){
        given()
                .with()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void singleUserNotFoundTest(){
        given()
                .with()
                .get("https://reqres.in/api/users/23")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().body();
    }

    @Test
    public void listResourceTest(){
        given()
                .with()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void singleResourceTest(){
        given()
                .with()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void singleResourceNotFoundTest(){
        given()
                .with()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().body();
    }

    @Test
    public void createPostTest(){
        String name = "morpheus";
        String job = "leader";

        given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"job\": \"%s\"\n" +
                        "}", name, job))
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body();
    }

    @Test
    public void updatePutTest(){
        String name = "morpheus";
        String job = "zion resident";

        given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"job\": \"%s\"\n" +
                        "}", name, job))
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void updatePatchTest(){
        String name = "morpheus";
        String job = "zion resident";

        given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"job\": \"%s\"\n" +
                        "}", name, job))
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void deleteTest(){

        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .log().body();
    }

    @Test
    public void registerSuccessfulTest(){
        String email = "eve.holt@reqres.in";
        String password = "pistol";

        given()
                .body(String.format("{\n" +
                        "    \"email\": \"%s\",\n" +
                        "    \"password\": \"%s\"\n" +
                        "}", email, password))
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void registerUnsuccessfulTest(){
        String email = "sydney@fife";

        given()
                .body(String.format("{\n" +
                        "    \"email\": \"%s\"\n" +
                        "}", email))
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body();
    }

    @Test
    public void loginSuccessfulTest(){
        String email = "eve.holt@reqres.in";
        String password = "cityslicka";

        given()
                .body(String.format("{\n" +
                        "    \"email\": \"%s\",\n" +
                        "    \"password\": \"%s\"\n" +
                        "}", email, password))
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void loginUnsuccessfulTest(){
        String email = "peter@klaven";

        given()
                .body(String.format("{\n" +
                        "    \"email\": \"%s\"\n" +
                        "}", email))
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body();
    }

    @Test
    public void delayedResponse() {
        given().
                with()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
