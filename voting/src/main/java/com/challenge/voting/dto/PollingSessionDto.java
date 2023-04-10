package com.challenge.voting.dto;

import java.time.LocalDateTime;
import java.util.UUID;


public class PollingSessionDto {
    private UUID id;
    private UUID idAgenda;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer duration;
    private Integer votesInFavor;
    private Integer votesAgainst;

    public PollingSessionDto() {}

   

    public PollingSessionDto(UUID id, UUID idAgenda, LocalDateTime startDateTime, LocalDateTime endDateTime,
            Integer duration, Integer votesInFavor, Integer votesAgainst) {
        this.id = id;
        this.idAgenda = idAgenda;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.duration = duration;
        this.votesInFavor = votesInFavor;
        this.votesAgainst = votesAgainst;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

   
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getVotesInFavor() {
        return votesInFavor;
    }

    public void setVotesInFavor(Integer votesInFavor) {
        this.votesInFavor = votesInFavor;
    }

    public Integer getVotesAgainst() {
        return votesAgainst;
    }

    public void setVotesAgainst(Integer votesAgainst) {
        this.votesAgainst = votesAgainst;
    }

    public UUID getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(UUID idAgenda) {
        this.idAgenda = idAgenda;
    }
}
