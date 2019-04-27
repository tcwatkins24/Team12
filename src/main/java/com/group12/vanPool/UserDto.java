package com.group12.vanPool;


import com.group12.vanPool.annotations.PasswordMatches;
import com.group12.vanPool.annotations.ValidEmail;

import javax.validation.constraints.NotBlank;

@PasswordMatches
public class UserDto {
    private Long id;
    @NotBlank (message = "Username is required")
    private String username;
    @NotBlank(message = "First Name is required")
    private String firstName;
    @NotBlank (message = "Last Name is required")
    private String lastName;
    @ValidEmail
    @NotBlank (message = "Email is required")
    private String email;
    @NotBlank (message = "Password is required")
    private String password;
    @NotBlank (message = "Matching password is required")
    private String matchingPassword;
    @NotBlank (message = "Security question is required")
    private String securityQuestion;
    @NotBlank (message = "Security answer is required")
    private String securityAnswer;

    private boolean isDriver;


    public UserDto(Long id, String username, String firstName, String lastName, String email, String password, String matchingPassword,String securityQuestion,String securityAnswer, boolean isDriver) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.isDriver = isDriver;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;

    }

    public UserDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public boolean isDriver() {return this.isDriver;}
    public void setDriver(boolean flag) {this.isDriver = flag;}
}
