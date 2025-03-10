package com.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TweetDTO {
    private String text;
    private String airline;
    @JsonProperty("airline_sentiment")
    private String airlineSentiment;

    public TweetDTO(String text, String airline, String airlineSentiment) {
        this.text = text;
        this.airline = airline;
        this.airlineSentiment = airlineSentiment;
    }

    public String getText() {
        return text;
    }

    public String getAirline() {
        return airline;
    }

    public String getAirlineSentiment() {
        return airlineSentiment;
    }
}
