package com.challenge.voting.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.challenge.voting.entity.PollingSession;

public interface PollingSessionService {
    PollingSession createPollingSession(UUID agendaId, LocalDateTime endDate);

    PollingSession findByAgendaId(UUID agendaId);

    List<PollingSession> findAllExpiredPollingSessions();

    PollingSession getPollingSessionById(UUID id);
}
