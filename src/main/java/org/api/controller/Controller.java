package org.api.controller;
import jakarta.validation.Valid;
import org.api.model.DTO.ParticipantDTO;
import org.api.model.DTO.ReqParticipantDTO;
import org.api.model.DTO.RequestEventDTO;
import org.api.model.DTO.ResponseEventDTO;
import org.api.service.EventService;
import org.api.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  EventService eventService;

  @Autowired
  ParticipantService participantService;

  @PostMapping("/eventos")
    public ResponseEntity<ResponseEventDTO> createEvent
          (@RequestBody @Valid RequestEventDTO requestEventDTO) {

        ResponseEventDTO response = eventService.createEvent(requestEventDTO);
        return ResponseEntity.status(201).body(response);

    }

  @PostMapping("/eventos/{id}/participantes")
  public ResponseEntity<ParticipantDTO> addParticipantInEvent(
          @PathVariable("id") int id,
          @RequestBody @Valid ReqParticipantDTO reqParticipantDTO) {

    ParticipantDTO response = participantService.addParticipantInEvent(id, reqParticipantDTO);
    return ResponseEntity.status(200).body(response);
  }




}
