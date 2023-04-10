package com.challenge.voting.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.challenge.voting.entity.Agenda;
import com.challenge.voting.service.VotingAgendaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class VotingAgendaControllerTest {
    @Mock
    private VotingAgendaService votingAgendaService;

    @InjectMocks
    private VotingAgendaController votingAgendaController;

    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(votingAgendaController).build();
    }

    @Test
    public void testCreateVotingAgenda() throws Exception {
        Agenda votingAgenda = new Agenda();
        votingAgenda.setId(1L);
        votingAgenda.setTitle("Test Voting Agenda");

        Mockito.when(votingAgendaService.createVotingAgenda(Mockito.any(Agenda.class))).thenReturn(votingAgenda);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(votingAgenda);

        mockMvc.perform(MockMvcRequestBuilders.post("/voting-agenda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Test Voting Agenda")));
    }
}
