package com.server.dto;

public class TweetAirlineDTO {
    private String airline;

    public TweetAirlineDTO() {
    } // Пустой конструктор для Spring

    public TweetAirlineDTO(String airline) {
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
