package service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.voting.entity.Agenda;
import com.challenge.voting.exception.PollingSessionNotFoundException;

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
        agenda.setId(1L);
        agenda.setTitle("Test Agenda");

        PollingSessionRequest pollingSessionRequest = new PollingSessionRequest();
        pollingSessionRequest.setAgendaId(1L);
        pollingSessionRequest.setDurationInMinutes(5L);

        Mockito.when(pollingSessionRepository.save(Mockito.any(PollingSession.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());

        // Act
        PollingSession pollingSession = pollingSessionService.createPollingSession(pollingSessionRequest);

        // Assert
        Mockito.verify(pollingSessionRepository, Mockito.times(1)).save(Mockito.any(PollingSession.class));
        assertEquals(agenda.getId(), pollingSession.getAgenda().getId());
        assertEquals(pollingSessionRequest.getDurationInMinutes(), pollingSession.getDurationInMinutes());
    }

    @Test
    public void getPollingSessionById_shouldReturnPollingSession() {
        // Arrange
        Agenda agenda = new Agenda();
        agenda.setId(1L);
        agenda.setTitle("Test Agenda");

        PollingSession pollingSession = new PollingSession();
        pollingSession.setId(1L);
        pollingSession.setAgenda(agenda);
        pollingSession.setDurationInMinutes(5L);

        Mockito.when(pollingSessionRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pollingSession));

        // Act
        PollingSession result = pollingSessionService.getPollingSessionById(1L);

        // Assert
        Mockito.verify(pollingSessionRepository, Mockito.times(1)).findById(Mockito.anyLong());
        assertEquals(pollingSession.getId(), result.getId());
        assertEquals(pollingSession.getAgenda().getId(), result.getAgenda().getId());
        assertEquals(pollingSession.getDurationInMinutes(), result.getDurationInMinutes());
    }

    @Test
    public void getPollingSessionById_shouldThrowPollingSessionNotFoundException() {
        // Arrange
        Mockito.when(pollingSessionRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(PollingSessionNotFoundException.class, () -> {
            pollingSessionService.getPollingSessionById(1L);
        });
    }

}