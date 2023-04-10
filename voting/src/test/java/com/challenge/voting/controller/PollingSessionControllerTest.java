package com.challenge.voting.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.challenge.voting.entity.Agenda;
import com.challenge.voting.entity.PollingSession;
import com.challenge.voting.service.PollingSessionService;

@ExtendWith(MockitoExtension.class)
public class PollingSessionControllerTest {
    @Mock
    private PollingSessionService pollingSessionService;

    @InjectMocks
    private PollingSessionController pollingSessionController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(pollingSessionController).build();
    }

    @Test
    public void testOpenPollingSession() throws Exception {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusMinutes(30);
                
        Agenda agenda = new Agenda();
        agenda.setId(UUID.randomUUID());
        agenda.setTitle("Test Agenda");

        PollingSession pollingSession = new PollingSession();
        pollingSession.setId(UUID.randomUUID());
        pollingSession.setEndDate(LocalDateTime.now().plusMinutes(30));
        
        pollingSession.setAgenda(agenda);

        Mockito.when(pollingSessionService.createPollingSession(Mockito.any(), Mockito.any(LocalDateTime.class)))
                .thenReturn(pollingSession);
        
              
        mockMvc.perform(MockMvcRequestBuilders.post("/polling-session/open")
                .param("agendaId", "1")
                .param("startTime", startTime.toString())
                .param("endTime", endTime.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endTime").value(endTime.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.agenda.id").value(agenda.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.agenda.title").value(agenda.getTitle()));
    }
   
}