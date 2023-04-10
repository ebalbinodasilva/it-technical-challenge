package com.challenge.voting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.voting.dto.PollingSessionBuilder;
import com.challenge.voting.entity.Agenda;
import com.challenge.voting.entity.PollingSession;
import com.challenge.voting.exception.PollingSessionNotFoundException;
import com.challenge.voting.repository.PollingSessionRepository;

@ExtendWith(MockitoExtension.class)
public class PollingSessionServiceTest {

    @Mock
    private PollingSessionRepository pollingSessionRepository;

    @InjectMocks
    private PollingSessionService pollingSessionService;

    @Test
    public void createPollingSession_shouldSavePollingSession() {
        // Arrange
        Agenda agenda = new Agenda();
        agenda.setId(UUID.randomUUID());
        agenda.setTitle("Test Agenda");

        PollingSession pollingSession =  new PollingSessionBuilder()
        .withAgenda(agenda)
        .withEndDate(LocalDateTime.now().plusMinutes(30))
        .build();

        Mockito.when(pollingSessionRepository.save(Mockito.any(PollingSession.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());

        // Assert
        Mockito.verify(pollingSessionRepository, Mockito.times(1)).save(Mockito.any(PollingSession.class));
        assertEquals(agenda.getId(), pollingSession.getAgenda().getId());
    }

    @Test
    public void getPollingSessionById_shouldReturnPollingSession() {
        // Arrange
        Agenda agenda = new Agenda();
        agenda.setId(UUID.randomUUID());
        agenda.setTitle("Test Agenda");

        PollingSession pollingSession = new PollingSession();
        pollingSession.setId(UUID.randomUUID());
        pollingSession.setAgenda(agenda);
     
        Mockito.when(pollingSessionRepository.findById(Mockito.any())).thenReturn(Optional.of(pollingSession));

        // Act
        PollingSession result = pollingSessionService.getPollingSessionById(UUID.randomUUID());

        // Assert
        Mockito.verify(pollingSessionRepository, Mockito.times(1)).findById(Mockito.any());
        assertEquals(pollingSession.getId(), result.getId());
        assertEquals(pollingSession.getAgenda().getId(), result.getAgenda().getId());
    }

    @Test
    public void getPollingSessionById_shouldThrowPollingSessionNotFoundException() {
        UUID randomUUID = UUID.randomUUID();
        Mockito.when(pollingSessionRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        assertThrows(PollingSessionNotFoundException.class, () -> pollingSessionService.getPollingSessionById(randomUUID));
    }

}