package org.example.client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetStoreClient {
    private final String BASE_URL = "https://petstore.swagger.io/v2";

    public Response createUser() {
        // Implement logic to create a user and return the response
        // You may need to provide the necessary payload in the request
        // Example:
        Response response = RestAssured.given().contentType(ContentType.JSON).body(userPayload).post(BASE_URL + "/user");
        return response;
    }

    public Response getUserData(String username) {
        // Implement logic to retrieve user data by username and return the response
        // Example:
        // Response response = RestAssured.get(BASE_URL + "/user/" + username);
        // return response;
    }

    public Response getPetsByStatus(String status) {
        // Implement logic to retrieve pets by status and return the response
        // Example:
        // Response response = RestAssured.get(BASE_URL + "/pet/findByStatus?status=" + status);
        // return response;
    }

}
