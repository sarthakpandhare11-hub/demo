package com.example.model;

public class Player {

    private String playerName;
    private String jerseyNo;
    private String playerCountry;

    public Player() {

    }

    public Player(String playerName, String jerseyNo, String playerCountry) {
        this.playerName = playerName;
        this.jerseyNo = jerseyNo;
        this.playerCountry = playerCountry;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(String jerseyNo) {
        this.jerseyNo = jerseyNo;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }

    public void setPlayerCountry(String playerCountry) {
        this.playerCountry = playerCountry;
    }

}
