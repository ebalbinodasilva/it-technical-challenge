package com.challenge.voting.service;

import org.springframework.stereotype.Service;

import com.challenge.voting.entity.VotingAgenda;
@Service
public interface VotingAgendaService {
    VotingAgenda createVotingAgenda(VotingAgenda votingAgenda);
}
