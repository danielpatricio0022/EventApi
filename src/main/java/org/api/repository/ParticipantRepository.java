package org.api.repository;

import org.api.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

  @Query("SELECT p FROM Participant p WHERE p.event.id = :eventId")
  List<Participant> findByEventId(@Param("eventId") int eventId);
}
