package com.challenge.voting.component;

import org.springframework.stereotype.Component;

import com.challenge.voting.dto.PollingSessionDto;
import com.challenge.voting.entity.PollingSession;

@Component
public class PollingSessionAdapter {

    public PollingSession toEntity(PollingSessionDto pollingSessionDto) {
        PollingSession entity = new PollingSession();
        return entity;
    }

    public static PollingSessionDto fromPollingSession(PollingSession pollingSession) {
        PollingSessionDto pollingSessionDto = new PollingSessionDto();
        return pollingSessionDto;
        
    }

    public static PollingSession toPollingSession() {
        return new PollingSession();
    }

}