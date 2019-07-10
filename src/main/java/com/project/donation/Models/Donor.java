package com.project.donation.Models;

import javax.persistence.*;

@Entity()
@SequenceGenerator(name="USER_SQ", sequenceName="user_sequence")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_SQ")
    private Long idDonor;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean active;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(Long idDonor) {
        this.idDonor = idDonor;
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
