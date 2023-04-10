package com.challenge.voting.service;

import org.springframework.stereotype.Service;

import com.challenge.voting.entity.Agenda;
import com.challenge.voting.repository.VotingAgendaRepository;

@Service
public class VotingAgendaServiceImpl implements VotingAgendaService{

   
    private VotingAgendaRepository votingAgendaRepository;

    public VotingAgendaServiceImpl(VotingAgendaRepository votingAgendaRepository) {
        this.votingAgendaRepository = votingAgendaRepository;
    }

    @Override
    public Agenda createVotingAgenda(Agenda votingAgenda) {
        return votingAgendaRepository.save(votingAgenda);
    }

}
