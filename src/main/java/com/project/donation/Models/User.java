package com.project.donation.Models;

import javax.persistence.*;

@Entity(name="account")
@SequenceGenerator(name="USER_SQ", sequenceName="user_sequence")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_SQ")
    private Long idUser;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

}
