package com.brasileirao.championship.Entities;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "teams", schema = "public")
public class Teams implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String team;
    private String acronym;
    private String full_name;
    private Integer founded;
    private String stadium;
    private String city;
    private String state;
    private String region;

    public Teams(){
    }

    public Teams(Long id, String team, String acronym, String full_name, Integer founded, String stadium, String city, String state, String region) {
        this.id = id;
        this.team = team;
        this.acronym = acronym;
        this.full_name = full_name;
        this.founded = founded;
        this.stadium = stadium;
        this.city = city;
        this.state = state;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
