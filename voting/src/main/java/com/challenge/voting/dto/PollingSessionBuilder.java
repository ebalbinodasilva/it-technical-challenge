package com.challenge.voting.dto;

import java.time.LocalDateTime;

import com.challenge.voting.entity.Agenda;
import com.challenge.voting.entity.PollingSession;

public class PollingSessionBuilder {

    private PollingSession pollingSession = new PollingSession();

    public PollingSessionBuilder withAgenda(Agenda agenda) {
        pollingSession.setAgenda(agenda);
        return this;
    }

    public PollingSessionBuilder withStartDate(LocalDateTime startDate) {
        pollingSession.setStartDate(startDate);
        return this;
    }

    public PollingSessionBuilder withEndDate(LocalDateTime endDate) {
        pollingSession.setEndDate(endDate);
        return this;
    }

    public PollingSession build() {
        return pollingSession;
    }

}