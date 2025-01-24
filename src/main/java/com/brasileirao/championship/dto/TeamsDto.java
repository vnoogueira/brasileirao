package com.brasileirao.championship.dto;

import com.brasileirao.championship.Entities.Teams;

import java.io.Serializable;

public class TeamsDto implements Serializable {

    private Long id;
    private String team;
    private String acronym;
    private String fullName;
    private Integer founded;
    private String stadium;
    private String city;
    private String state;
    private String region;

    public TeamsDto(){

    }

    public TeamsDto(Long id, String team, String acronym, String fullName, Integer founded, String stadium, String city, String state, String region) {
        this.id = id;
        this.team = team;
        this.acronym = acronym;
        this.fullName = fullName;
        this.founded = founded;
        this.stadium = stadium;
        this.city = city;
        this.state = state;
        this.region = region;
    }

    public TeamsDto(Teams teams) {
        this.id = teams.getId();
        this.team = teams.getTeam();
        this.acronym = teams.getAcronym();
        this.fullName = teams.getFullName();
        this.founded = teams.getFounded();
        this.stadium = teams.getStadium();
        this.city = teams.getCity();
        this.state = teams.getState();
        this.region = teams.getRegion();
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
