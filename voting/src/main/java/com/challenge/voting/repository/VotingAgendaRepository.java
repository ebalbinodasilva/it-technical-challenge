package com.challenge.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.voting.entity.VotingAgenda;
@Repository
public interface VotingAgendaRepository extends JpaRepository<VotingAgenda, Long>{
    
}
