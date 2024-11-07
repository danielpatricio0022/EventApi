package org.api.controller;
import jakarta.validation.Valid;
import org.api.model.DTO.*;
import org.api.service.EventService;
import org.api.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
          @RequestBody @Validated
          ReqParticipantDTO reqParticipantDTO) {

    ParticipantDTO response = participantService.addParticipantInEvent(id, reqParticipantDTO);
    return ResponseEntity.status(200).body(response);
  }

  @PostMapping("/eventos/{id}/presenca")

  public ResponseEntity<ResponsePresencaDTO> addPresenceInEvent(
          @PathVariable("id") int id,
          @RequestBody @Valid ReqPresencaDTO reqPresencaDTO) {

    ResponsePresencaDTO response = participantService.participantIsPresentEvent(reqPresencaDTO, id);
    return ResponseEntity.status(200).body(response);
  }


  @GetMapping("/eventos/{id}/participantes")
      public ResponseEntity<RsEventParticipantsDTO> getParticipantsByEventId(@PathVariable("id") int id) {
          RsEventParticipantsDTO response = participantService.getParticipantsTotal(id);
          return ResponseEntity.status(200).body(response);
      }

}
