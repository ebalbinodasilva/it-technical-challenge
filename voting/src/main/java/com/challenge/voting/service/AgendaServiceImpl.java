package com.challenge.voting.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.challenge.voting.entity.Agenda;
import com.challenge.voting.repository.AgendaRepository;

@Service
public class AgendaServiceImpl implements AgendaService{

   
    private AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public Agenda createAgenda(Agenda votingAgenda) {
        return agendaRepository.save(votingAgenda);
    }

    @Override
    public Agenda getAgendabyId(UUID idAgenda) {
        return agendaRepository.getReferenceById(idAgenda);
        
    }

}
