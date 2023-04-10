package com.challenge.voting.service;

import java.util.UUID;

import com.challenge.voting.entity.Agenda;

public interface AgendaService {
    Agenda createAgenda(Agenda votingAgenda);
    Agenda getAgendabyId(UUID idAgenda);
}
