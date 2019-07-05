package com.project.donation.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name="DONATION_SQ", sequenceName="donation_sequence")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DONATION_SQ")
    private Long idDonation;

    @ManyToOne
    private User user;
    @ManyToOne
    private Project project;

    public Long getIdDonation() {
        return idDonation;
    }

    public void setIdDonation(Long idDonation) {
        this.idDonation = idDonation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
