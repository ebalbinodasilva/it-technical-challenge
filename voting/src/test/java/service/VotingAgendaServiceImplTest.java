package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.challenge.voting.entity.VotingAgenda;
import com.challenge.voting.repository.VotingAgendaRepository;
import com.challenge.voting.service.VotingAgendaServiceImpl;


public class VotingAgendaServiceImplTest {
    
    @Mock
    private VotingAgendaRepository votingAgendaRepository;

    @InjectMocks
    private VotingAgendaServiceImpl votingAgendaService;

    @Test
    public void testCreateVotingAgenda() {
        VotingAgenda votingAgenda = new VotingAgenda();
        votingAgenda.setTitle("Test Voting Agenda");

        Mockito.when(votingAgendaRepository.save(Mockito.any(VotingAgenda.class))).thenReturn(votingAgenda);

        VotingAgenda createdVotingAgenda = votingAgendaService.createVotingAgenda(votingAgenda);

        Mockito.verify(votingAgendaRepository, Mockito.times(1)).save(Mockito.any(VotingAgenda.class));

        assertEquals(createdVotingAgenda.getId(), votingAgenda.getId());
        assertEquals(createdVotingAgenda.getTitle(), votingAgenda.getTitle());
    }
}
