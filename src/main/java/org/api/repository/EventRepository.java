package org.api.repository;

import org.api.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface EventRepository extends JpaRepository <Event , Integer >
{
  @Query(value = "SELECT EXISTS(SELECT 1 FROM event WHERE name = :name AND date = :date)", nativeQuery = true)
  boolean existsByNomeAndData(@Param("name") String name, @Param("date") LocalDateTime date);

// query to check if the event already exists in the database

  @Query(value = "SELECT EXISTS(SELECT 1 FROM participant WHERE email = :email)", nativeQuery = true)
  boolean existsByEmail(@Param("email") String email);

  // query to check if the participant email already exists in the database


}
