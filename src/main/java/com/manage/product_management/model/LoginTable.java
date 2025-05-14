package com.manage.product_management.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
//import javax.*;//validation.constraints.NotNull;

@Entity
@Table(name = "LoginTable")
public class LoginTable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(name = "Username")
    String username;

    @NotNull
    @Column(name = "FirstName")
    String firstname;

    @NotNull
    @Column(name = "LastName")
    String lastname;

    @NotNull
    @Column(name = "Password")
    String password;

    @NotNull
    @Column(name = "Email")
    String email;


    @Column(name = "Special")
    String special;
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public LoginTable(){

    }

    public LoginTable(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", UserName='" + username + '\'' +
                ", FirstName='" + firstname + '\'' +
                ", LastName='" + lastname + '\'' +
                ", Email='" + email + '\'' +
                ", Password='" + password + '\'' +
                ", special=" + special +
                '}';
    }
}
