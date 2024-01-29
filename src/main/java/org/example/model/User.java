package org.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private long userStatus;


    @Override
    public String toString() {
        return String.format("Username: %s\nFirstName: %s\nLastName: %s\nEmail: %s\n", username, firstName, lastName, email);
    }
}
