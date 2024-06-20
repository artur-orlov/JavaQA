package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTests {

    static {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void checkGetMethod() {
        Response response = given()
                .queryParam("name", "Art")
                .queryParam("nick", "Bart")
                .when()
                .get("/get")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response();

        response
                .then()
                .body("args.name", equalTo("Art"))
                .body("args.nick", equalTo("Bart"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.3 (Java/11.0.23)"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/get?name=Art&nick=Bart"))
                .extract()
                .response();
    }

    @Test
    public void checkPostMethodRawText() {
        String requestBody = "{\"name\"=\"Art\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response();

        response
                .then()
                  .body("data", equalTo(requestBody))
                  .body("headers.host", equalTo("postman-echo.com"))
                  .body("headers.x-request-start", notNullValue())
                  .body("headers.content-length", notNullValue())
                  .body("headers.x-forwarded-proto", equalTo("https"))
                  .body("headers.x-forwarded-port", equalTo("443"))
                  .body("headers.x-amzn-trace-id", notNullValue())
                  .body("headers.content-type", equalTo("application/json; charset=UTF-8"))
                  .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.3 (Java/11.0.23)"))
                  .body("headers.accept", equalTo("*/*"))
                  .body("headers.postman-token", equalTo(null))
                  .body("headers.accept-encoding", equalTo("gzip,deflate"))
                  .body("headers.cookie", equalTo(null))
                  .body("json", equalTo(null))
                  .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void checkPostMethodFormData() {
        String requestBody = "{\"name\"=\"Art\"\"nick\"=\"Bart\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response();

        response
                .then()
                .body("args", equalTo(new HashMap<>()))
                .body("data", equalTo("{\"name\"=\"Art\"\"nick\"=\"Bart\"}"))
                .body("files", equalTo(new HashMap<>()))
                .body("form.name", equalTo(null))
                .body("form.nick", equalTo(null))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.content-length", equalTo("27"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.3 (Java/11.0.23)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("application/json; charset=UTF-8"))
                .body("headers.cookie", equalTo(null))
                .body("json.name", equalTo(null))
                .body("json.nick", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void checkPutMethod() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(200)
                .extract()
                .response();

        response
                .then()
                .body("data", equalTo(requestBody))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json; charset=UTF-8"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.3 (Java/11.0.23)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void checkPatchMethod() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .extract()
                .response();

        response
                .then()
                .body("args", equalTo(new HashMap<>()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.3 (Java/11.0.23)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/patch"));
    }


    @Test
    public void checkDeleteMethod() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract()
                .response();

        response
                .then()
                .body("args", equalTo(new HashMap<>()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.3 (Java/11.0.23)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
