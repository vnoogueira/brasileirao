package com.brasileirao.championship.dto;

import com.brasileirao.championship.Entities.Brasileirao;
import jakarta.persistence.Column;

import java.io.Serializable;

public class BrasileiraoDto implements Serializable {

    private Long id;
    private Integer season;
    private Integer place;
    private String team;
    private Integer points;
    private Integer played;
    private Integer won;
    private Integer draw;
    private Integer loss;
    private Integer goals;
    private Integer goalsTaken;
    private Integer goalsDiff;

    public BrasileiraoDto(){

    }

    public BrasileiraoDto(Long id, Integer season, Integer place, String team, Integer points, Integer played, Integer won, Integer draw, Integer loss, Integer goals, Integer goalsTaken, Integer goalsDiff) {
        this.id = id;
        this.season = season;
        this.place = place;
        this.team = team;
        this.points = points;
        this.played = played;
        this.won = won;
        this.draw = draw;
        this.loss = loss;
        this.goals = goals;
        this.goalsTaken = goalsTaken;
        this.goalsDiff = goalsDiff;
    }

    public BrasileiraoDto(Brasileirao entity){
        this.id = entity.getId();
        this.season = entity.getSeason();
        this.place = entity.getPlace();
        this.team = entity.getTeam();
        this.points = entity.getPoints();
        this.played = entity.getPlayed();
        this.won = entity.getWon();
        this.draw = entity.getDraw();
        this.loss = entity.getLoss();
        this.goals = entity.getGoals();
        this.goalsTaken = entity.getGoalsTaken();
        this.goalsDiff = entity.getGoalsDiff();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLoss() {
        return loss;
    }

    public void setLoss(Integer loss) {
        this.loss = loss;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoalsTaken() {
        return goalsTaken;
    }

    public void setGoalsTaken(Integer goalsTaken) {
        this.goalsTaken = goalsTaken;
    }

    public Integer getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(Integer goalsDiff) {
        this.goalsDiff = goalsDiff;
    }
}
