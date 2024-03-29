package com.project.donation.Models;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="ASSOCIATION_SQ", sequenceName="association_sequence")
public class
Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ASSOCIATION_SQ")
    private Long idAssociation;
    private String associationName;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getIdAssociation() {
        return idAssociation;
    }

    public void setIdAssociation(Long idAssociation) {
        this.idAssociation = idAssociation;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }
}
