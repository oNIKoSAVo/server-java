package com.server.models;

import javax.persistence.*;

@Entity
@Table(name = "tweets")
public class Tweet {

    @Id
    @Column(name = "tweet_id") // 🚀 Должно совпадать с БД
    private Long tweetId;

    @Column(name = "airline_sentiment")
    private String airlineSentiment;

    @Column(name = "negativereason")
    private String negativereason;

    @Column(name = "airline")
    private String airline;

    @Column(name = "text")
    private String text;

    public Tweet() {
    }

    public Long getTweetId() {
        return tweetId;
    }

    public String getAirlineSentiment() {
        return airlineSentiment;
    }

    public String getNegativereason() {
        return negativereason;
    }

    public String getAirline() {
        return airline;
    }

    public String getText() {
        return text;
    }
}
