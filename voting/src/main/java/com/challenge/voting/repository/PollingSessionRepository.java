package com.challenge.voting.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.challenge.voting.entity.PollingSession;


@Repository
public interface PollingSessionRepository extends JpaRepository<PollingSession, UUID> {

    PollingSession findByAgendaId(UUID agendaId);

    List<PollingSession> findAllByEndDateBefore(LocalDateTime now);


}
