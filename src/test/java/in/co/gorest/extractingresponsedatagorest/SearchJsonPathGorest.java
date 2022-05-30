package in.co.gorest.extractingresponsedatagorest;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.json.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class SearchJsonPathGorest {

    static ValidatableResponse response;

    JSONArray jsonData = new JSONArray();

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2/users";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }

    //1.Total records are 20
    @Test
    public void test001() {
        int records = response.extract().path("size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + records);
        System.out.println("------------------End of Test---------------------------");
    }

    //2.id 3928 has name = "Jyoti Kakkar" <<<note-need to change id from current response in postman>>>>
    @Test
    public void test002() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id 3928 has name : " + response.extract().path("findAll{it.id == 3928}.name[0]"));
        System.out.println("------------------End of Test---------------------------");
    }

    //3.id 3928 has email = "jyoti_kakkar@gusikowski-weimann.name" <<<note-need to change id from current response in postman>>>>
    @Test
    public void test003() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id 3928 has email : " + response.extract().path("findAll{it.id == 3928}.email[0]"));
        System.out.println("------------------End of Test---------------------------");
    }

    //4.All ID has status = "active"
    @Test
    public void test004() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id has active status  : " + response.extract().path("findAll{it.status == 'active'}"));
        System.out.println("------------------End of Test---------------------------");
    }

    //5.id 3928 has gender = "female"<<<note-need to change id from current response in postman>>>>
    @Test
    public void test005() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id 3928 has gender : " + response.extract().path("findAll{it.id == 3928}.gender[0]"));
        System.out.println("------------------End of Test---------------------------");
    }

    //6.id 3927 has gender = "male"<<<note-need to change id from current response in postman>>>>
    @Test
    public void test006() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id 3927 has gender : " + response.extract().path("findAll{it.id == 3927}.gender[0]"));
        System.out.println("------------------End of Test---------------------------");
    }

}
