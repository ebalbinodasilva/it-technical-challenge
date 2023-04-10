package com.challenge.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.voting.entity.Agenda;
import com.challenge.voting.service.VotingAgendaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/voting-agenda")
public class VotingAgendaController {
    
    @Autowired
    private VotingAgendaService votingAgendaService;

   
    @PostMapping
    public ResponseEntity<Agenda> createVotingAgenda(@RequestBody Agenda votingAgenda) {
        Agenda createdVotingAgenda = votingAgendaService.createVotingAgenda(votingAgenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVotingAgenda);
    }
}

