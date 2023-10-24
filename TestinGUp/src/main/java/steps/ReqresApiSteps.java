package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.requestModel.JbRequest;
import models.requestModel.LogRequest;
import models.requestModel.RegRequest;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ReqresApiSteps {
    @Step
    public void getUsersList() {
        given().when().baseUri("https://reqres.in/").contentType(ContentType.JSON)
                .get("api/users?page=2")
                .then().statusCode(200).log().all();
    }

    @Step
    public void getListResource() {
        given().when().baseUri("https://reqres.in/").contentType(ContentType.JSON)
                .get("api/unknown")
                .then().statusCode(200).log().all();
    }

    @Step
    public void getSingleResource() {
        given().when().baseUri("https://reqres.in/").contentType(ContentType.JSON)
                .get("api/unknown/2")
                .then().statusCode(200).log().all();
    }

    @Step
    public void getNotExistResource() {
        given().when().baseUri("https://reqres.in/").contentType(ContentType.JSON)
                .get("api/unknown/23")
                .then().statusCode(404).log().all();
    }

    @Step
    public void getUserById(Integer id) {
        given()
                .when().baseUri("https://reqres.in/").contentType(ContentType.JSON)
                .get("api/users/" + id)
                .then().statusCode(200).log().all();
    }

    @Step
    public void getnoExUser(Integer id) {
        given()
                .when().baseUri("https://reqres.in/").contentType(ContentType.JSON)
                .get("api/users/" + id)
                .then().statusCode(400).log().all();
    }

    @Step
    public void createUser(JbRequest user) {
         given().contentType(ContentType.JSON)
                .when().baseUri("https://reqres.in/")
                .body(user)
                .post("api/users")
                .then().statusCode(201).log().all();
    }

    @Step
    public void updateUser(JbRequest user) {
         given().contentType(ContentType.JSON)
                .when().baseUri("https://reqres.in/")
                .body(user)
                .put("api/users/2")
                .then().statusCode(200).log().all();
    }

    @Step
    public void deleteUser() {
        given().contentType(ContentType.JSON)
                .when().baseUri("https://reqres.in/")
                .delete("api/users/2")
                .then().statusCode(204).log().all();
    }

    @Step
    public void registerSuccessUser(RegRequest registerRequest) {
        given().contentType(ContentType.JSON)
                .when().baseUri("https://reqres.in/")
                .body(registerRequest)
                .post("api/register")
                .then().statusCode(201).log().all();
    }

    @Step
    public void registerUnSuccessUser(RegRequest registerRequest) {
        given().contentType(ContentType.JSON)
                .when().baseUri("https://reqres.in/")
                .body(registerRequest)
                .post("api/register")
                .then().statusCode(400).log().all();
    }

    @Step
    public void loginSuccessUser(LogRequest loginRequest) {
         given().contentType(ContentType.JSON)
                .when().baseUri("https://reqres.in/")
                .body(loginRequest)
                .post("api/login")
                .then().statusCode(200).log().all().extract();
    }

    @Step
    public void loginUnsuccessUser(LogRequest loginRequest) {
        given().contentType(ContentType.JSON)
                .when().baseUri("https://reqres.in/")
                .body(loginRequest)
                .post("api/login")
                .then().statusCode(400).log().all().extract();
    }

    @Step("Получить отложенный список пользователей")
    public void getDelayUserList() {
        given().when().baseUri("https://reqres.in/").contentType(ContentType.JSON)
                .get("api/users?delay=3")
                .then().statusCode(200).log().all();
    }
}
