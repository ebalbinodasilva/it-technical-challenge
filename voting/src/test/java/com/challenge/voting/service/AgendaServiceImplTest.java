package com.challenge.voting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.challenge.voting.entity.Agenda;
import com.challenge.voting.repository.AgendaRepository;


@ExtendWith(MockitoExtension.class)
public class AgendaServiceImplTest {
    
    @Mock
    private AgendaRepository agendaRepository;

    @InjectMocks
    private AgendaServiceImpl agendaService;

    @Test
    public void testCreateVotingAgenda() {
        Agenda agenda = new Agenda();
        agenda.setTitle("Test Voting Agenda");

        Mockito.when(agendaRepository.save(Mockito.any(Agenda.class))).thenReturn(agenda);

        Agenda createAgenda = agendaRepository.save(agenda);

        Mockito.verify(agendaRepository, Mockito.times(1)).save(Mockito.any(Agenda.class));

        assertEquals(createAgenda.getId(), agenda.getId());
        assertEquals(createAgenda.getTitle(), agenda.getTitle());
    }
}
