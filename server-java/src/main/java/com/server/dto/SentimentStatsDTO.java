package com.server.dto;

public class SentimentStatsDTO {
    private String airline;
    private Long cntNeg;
    private Long cntNeut;
    private Long cntP;

    public SentimentStatsDTO(String airline, Long cntNeg, Long cntNeut, Long cntP) {
        this.airline = airline;
        this.cntNeg = cntNeg;
        this.cntNeut = cntNeut;
        this.cntP = cntP;
    }

    public String getAirline() {
        return airline;
    }

    public Long getCntNeg() {
        return cntNeg;
    }

    public Long getCntNeut() {
        return cntNeut;
    }

    public Long getCntP() {
        return cntP;
    }
}
