package com.challenge.voting.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.challenge.voting.dto.PollingSessionBuilder;
import com.challenge.voting.entity.PollingSession;
import com.challenge.voting.exception.PollingSessionNotFoundException;
import com.challenge.voting.repository.PollingSessionRepository;


@Service
public class PollingSessionServiceImpl implements PollingSessionService {
    
    private final PollingSessionRepository pollingSessionRepository;
    private final AgendaService agendaService;

    public PollingSessionServiceImpl(PollingSessionRepository pollingSessionRepository, AgendaService agendaService) {
        this.pollingSessionRepository = pollingSessionRepository;
        this.agendaService = agendaService;
    }

    @Override
    public PollingSession createPollingSession(UUID agendaId, LocalDateTime endDate) {
        PollingSession pollingSession = new PollingSessionBuilder()
        .withAgenda(agendaService.getAgendabyId(agendaId))
        .withStartDate(LocalDateTime.now())
        .withEndDate(LocalDateTime.now().plusMinutes(30))
        .build();
        return pollingSessionRepository.save(pollingSession);
        
    }

    @Override
    public PollingSession findByAgendaId(UUID agendaId) {
        return pollingSessionRepository.findByAgendaId(agendaId);
    }

    @Override
    public List<PollingSession> findAllExpiredPollingSessions() {
        return pollingSessionRepository.findAll();
        
    }

    @Override
    public PollingSession getPollingSessionById(UUID id) {
        return pollingSessionRepository.findById(id).orElseThrow(()-> new PollingSessionNotFoundException("PollingSession not found for id: " + id));
    }

   
    
}
