package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    @Test
    public void createUser() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Shiven Sharma");
        userPojo.setGender("Male");
        userPojo.setEmail("shiven@nodomain.com");
        userPojo.setStatus("active");

        HashMap<String, Object> header1 = new HashMap<>();
        header1.put("Content-Type", "application/json");
        header1.put("Accept", "application/json");
        header1.put("Authorization","Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac");
        Response response = given()
                .headers(header1)
                .body(userPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
//4050

    }
}
