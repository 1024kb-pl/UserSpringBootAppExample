package com.example.demo.user.model;


import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String email;
    private String password;


    public User() {

    }

    public User(String login, String email, String pass) {
        this.login = login;
        this.email = email;
        this.password = pass;
    }


    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, email, password);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
