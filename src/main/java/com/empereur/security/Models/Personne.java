package com.empereur.security.Models;

import javax.persistence.*;

@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long personId;

    @Column(unique = true)
    private  String matricule;

    @Column(unique = true)
    private String code;

    private  String firstName;

    private  String lastName;

    private  String domaine;

    private boolean statusCard;

    private String personType;

    public Personne() {
    }

    public Personne(Long personId, String matricule, String code, String firstName, String lastName,
                    String domaine, boolean statusCard, String personType) {
        this.personId = personId;
        this.matricule = matricule;
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.domaine = domaine;
        this.statusCard = statusCard;
        this.personType = personType;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public boolean isStatusCard() {
        return statusCard;
    }

    public void setStatusCard(boolean statusCard) {
        this.statusCard = statusCard;
    }
}
