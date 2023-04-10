package com.challenge.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.voting.entity.Agenda;
import com.challenge.voting.service.AgendaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/voting-agenda")
public class VotingAgendaController {
    
    @Autowired
    private AgendaService votingAgendaService;

   
    @PostMapping
    public ResponseEntity<Agenda> createVotingAgenda(@RequestBody Agenda agenda) {
        Agenda createdAgenda = votingAgendaService.createAgenda(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAgenda);
    }
}

