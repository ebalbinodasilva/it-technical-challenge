package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.voting.entity.Agenda;
import com.challenge.voting.repository.VotingAgendaRepository;
import com.challenge.voting.service.VotingAgendaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VotingAgendaServiceImplTest {
    
    @Mock
    private VotingAgendaRepository votingAgendaRepository;

    @InjectMocks
    private VotingAgendaServiceImpl votingAgendaService;

    @Test
    public void testCreateVotingAgenda() {
        Agenda votingAgenda = new Agenda();
        votingAgenda.setTitle("Test Voting Agenda");

        Mockito.when(votingAgendaRepository.save(Mockito.any(Agenda.class))).thenReturn(votingAgenda);

        Agenda createdVotingAgenda = votingAgendaService.createVotingAgenda(votingAgenda);

        Mockito.verify(votingAgendaRepository, Mockito.times(1)).save(Mockito.any(Agenda.class));

        assertEquals(createdVotingAgenda.getId(), votingAgenda.getId());
        assertEquals(createdVotingAgenda.getTitle(), votingAgenda.getTitle());
    }
}
