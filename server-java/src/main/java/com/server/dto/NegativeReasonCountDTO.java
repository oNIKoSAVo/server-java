package com.server.dto;

public class NegativeReasonCountDTO {
    private String airline;
    private String negativereason;
    private Long count;

    public NegativeReasonCountDTO(String airline, String negativereason, Long count) {
        this.airline = airline;
        this.negativereason = negativereason;
        this.count = count;
    }

    public String getAirline() {
        return airline;
    }

    public String getNegativereason() {
        return negativereason;
    }

    public Long getCount() {
        return count;
    }
}
