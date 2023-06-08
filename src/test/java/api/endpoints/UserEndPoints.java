package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//Create to perform Create,Read,Update,Delete requests to the user API
public class UserEndPoints {

    public static Response createUser(User payload) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);

        return response;
    }

    public static Response readUser(String username) {

        Response response = given()

                .pathParams("username", username)
                .when()
                .get(Routes.get_url);

        return response;
    }

    public static Response updateUser(User payload, String username) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParams("username", username)
                .when()
                .put(Routes.update_url);

        return response;
    }

    public static Response deleteUser(String username) {

        Response response = given()

                .pathParams("username", username)
                .when()
                .delete(Routes.delete_url);

        return response;
    }
}