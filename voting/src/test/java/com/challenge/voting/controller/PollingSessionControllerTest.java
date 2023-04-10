package com.challenge.voting.controller;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
        Agenda agenda = new Agenda();
        agenda.setId(1L);
        agenda.setTitle("Test Agenda");

        PollingSession pollingSession = new PollingSession();
        pollingSession.setId(1L);
        pollingSession.setStartTime(LocalDateTime.now());
        pollingSession.setEndTime(LocalDateTime.now().plusMinutes(30));
        pollingSession.setAgenda(agenda);

        Mockito.when(pollingSessionService.openPollingSession(Mockito.anyLong(), Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class)))
                .thenReturn(pollingSession);

        mockMvc.perform(post("/polling-session/open")
                .param("agendaId", "1")
                .param("startTime", LocalDateTime.now().toString())
                .param("endTime", LocalDateTime.now().plusMinutes(30).toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.startTime", is(pollingSession.getStartTime().toString())))
                .andExpect(jsonPath("$.endTime", is(pollingSession.getEndTime().toString())))
                .andExpect(jsonPath("$.agenda.id", is(agenda.getId().intValue())))
                .andExpect(jsonPath("$.agenda.title", is(agenda.getTitle())));
    }
}