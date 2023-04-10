package com.challenge.voting.service;

import org.springframework.stereotype.Service;

import com.challenge.voting.entity.VotingAgenda;
import com.challenge.voting.repository.VotingAgendaRepository;

@Service
public class VotingAgendaServiceImpl implements VotingAgendaService{

   
    private VotingAgendaRepository votingAgendaRepository;

    public VotingAgendaServiceImpl(VotingAgendaRepository votingAgendaRepository) {
        this.votingAgendaRepository = votingAgendaRepository;
    }

    @Override
    public VotingAgenda createVotingAgenda(VotingAgenda votingAgenda) {
        return votingAgendaRepository.save(votingAgenda);
    }

}
