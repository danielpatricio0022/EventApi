package org.api.repository;

import org.api.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface EventRepository extends JpaRepository <Event , Integer >
{
  @Query(value = "SELECT COUNT(*) > 0 FROM evento WHERE nome = :nome AND data = :data", nativeQuery = true)
  boolean existsByNomeAndData(@Param("nome") String nome, @Param("data") LocalDateTime data);

}
