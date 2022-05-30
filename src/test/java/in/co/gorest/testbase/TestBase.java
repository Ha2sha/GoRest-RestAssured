package in.co.gorest.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void inIt() {
        //set environment
        RestAssured.baseURI="https://gorest.co.in";//test environment
        RestAssured.basePath="/public/v2/users";

    }
}
