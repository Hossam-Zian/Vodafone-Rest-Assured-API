import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class ApiAutomationTest {

    @Test
    public void testApiAutomation() {

        RestAssured
                .given()
                .baseUri("https://jsonplaceholder.typicode.com/posts")
                .header("Content-Type", "application/json")
                .body("{\n" + "\"title\": \"foo\",\n" + "\"body\": \"bar\",\n" + "\"userId\": 1,\n" + "\"id\": 101\n" + "}")
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("userId", equalTo(1))
                .body("id", equalTo(101))
                .body("title", equalTo("foo"));
    }
}
