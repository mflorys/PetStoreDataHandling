package org.example.service;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.example.model.Pet;
import org.example.model.Status;
import org.example.model.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class PetStoreClient {
    private final String baseUrl = "https://petstore.swagger.io/v2";
    private final HttpClient httpClient = HttpClients.createDefault();

    Gson gson = new Gson();

    @SneakyThrows
    public void createUser(User user) {
        String request = gson.toJson(user);
        HttpPost createUserRequest = new HttpPost(baseUrl + "/user");
        createUserRequest.setEntity(new StringEntity(request));
        createUserRequest.setHeader("Content-type", "application/json");
        createUserRequest.setHeader("Accept", "application/json");
        httpClient.execute(createUserRequest).getStatusLine().getStatusCode();
    }

    @SneakyThrows
    public User getUser(String username) {
        HttpGet getUserRequest = new HttpGet(baseUrl + "/user/" + username);
        getUserRequest.setHeader("Content-type", "application/json");
        getUserRequest.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(getUserRequest);
        Gson gson = new Gson();
        return gson.fromJson(getResponseContent(response), User.class);
    }

    @SneakyThrows
    public List<Pet> findPetsByStatus(Status status) {
        HttpGet findPetsRequest = new HttpGet(baseUrl + "/pet/findByStatus?status=" + status.getStatus());
        findPetsRequest.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(findPetsRequest);

        Gson gson = new Gson();
        return Arrays.asList(gson.fromJson(getResponseContent(response), Pet[].class));
    }

    @SneakyThrows
    String getResponseContent(HttpResponse response) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        return content.toString();
    }
}
