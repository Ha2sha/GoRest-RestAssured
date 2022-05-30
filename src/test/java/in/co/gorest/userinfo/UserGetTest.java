package in.co.gorest.userinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class UserGetTest extends TestBase {

    @Test
    public void getAllUsersInfo() {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleUserInfo() {
        Response response = given()
                .pathParam("id", 3252)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchUserWithParameter() {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("gender", "female");
        qParams.put("status","active");
        Response response = given()
                .queryParams(qParams)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
