package com.challenge.voting.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.voting.component.PollingSessionAdapter;
import com.challenge.voting.dto.PollingSessionDto;
import com.challenge.voting.entity.PollingSession;
import com.challenge.voting.service.PollingSessionService;


@RestController
@RequestMapping("/polling-session")
public class PollingSessionController {

    private final PollingSessionService pollingSessionService;

    public PollingSessionController(PollingSessionService pollingSessionService) {
        this.pollingSessionService = pollingSessionService;
    }

    @PostMapping("/")
    public ResponseEntity<PollingSessionDto> createPollingSession(@RequestBody PollingSessionDto pollingSessionDto) {
        
        PollingSession pollingSession = pollingSessionService.createPollingSession(pollingSessionDto.getId(),pollingSessionDto.getEndDateTime());
        PollingSessionDto createdPollingSessionDto = PollingSessionAdapter.fromPollingSession(pollingSession);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPollingSessionDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PollingSessionDto> getPollingSessionById(@PathVariable UUID id) {
        PollingSession pollingSession = pollingSessionService.getPollingSessionById(id);
        PollingSessionDto pollingSessionDto = PollingSessionAdapter.fromPollingSession(pollingSession);
        return ResponseEntity.ok(pollingSessionDto);
    }

}

