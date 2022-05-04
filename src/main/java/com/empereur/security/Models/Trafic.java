package com.empereur.security.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Trafic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long traficID;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Personne person;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Date traficDay;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String traficTime;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private String traficType;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Sites traficSite;

    public Trafic() {
    }

    public Trafic(Long traficID, Personne person, Date traficDay, String traficTime, String traficType, Sites traficSite) {
        this.traficID = traficID;
        this.person = person;
        this.traficDay = traficDay;
        this.traficTime = traficTime;
        this.traficType = traficType;
        this.traficSite = traficSite;
    }

    public Sites getTraficSite() {
        return traficSite;
    }

    public void setTraficSite(Sites traficSite) {
        this.traficSite = traficSite;
    }

    public Long getTraficID() {
        return traficID;
    }

    public void setTraficID(Long traficID) {
        this.traficID = traficID;
    }

    public Personne getPerson() {
        return person;
    }

    public void setPerson(Personne person) {
        this.person = person;
    }

    public Date getTraficDay() {
        return traficDay;
    }

    public void setTraficDay(Date traficDay) {
        this.traficDay = traficDay;
    }

    public String getTraficTime() {
        return traficTime;
    }

    public void setTraficTime(String traficTime) {
        this.traficTime = traficTime;
    }

    public String getTraficType() {
        return traficType;
    }

    public void setTraficType(String traficType) {
        this.traficType = traficType;
    }
}
