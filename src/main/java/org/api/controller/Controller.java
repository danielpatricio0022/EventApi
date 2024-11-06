package org.api.controller;
import jakarta.validation.Valid;
import org.api.model.DTO.RequestEventDTO;
import org.api.model.DTO.ResponseEventDTO;
import org.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  EventService eventService;

  @PostMapping("/eventos")
    public ResponseEntity<ResponseEventDTO> createEvent
          (@RequestBody @Valid RequestEventDTO requestEventDTO) {

        ResponseEventDTO response = eventService.createEvent(requestEventDTO);
        return ResponseEntity.status(201).body(response);

    }


}
