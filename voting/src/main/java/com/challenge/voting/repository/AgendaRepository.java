package com.challenge.voting.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challenge.voting.entity.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, UUID>{
    
}
