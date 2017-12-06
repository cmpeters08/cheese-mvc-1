package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ryanneal on 12/5/17.
 */
public class User {

    @NotNull
    @Size(min=5, max=15)
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min=5, max=15)
    private String password;

    public static int id = 1;

    public final int userId;

    private LocalDateTime date;

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(){
        this.userId= id;
        this.date = LocalDateTime.now();
        id++;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String text = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        return parsedDate;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
