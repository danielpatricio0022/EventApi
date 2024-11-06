package org.api.service;
import org.api.exceptions.ConflictException;
import org.api.model.DTO.ParticipantDTO;
import org.api.model.DTO.ReqParticipantDTO;
import org.api.model.DTO.RequestEventDTO;
import org.api.model.DTO.ResponseEventDTO;
import org.api.model.Event;
import org.api.model.Participant;
import org.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  EventRepository eventRepository;

  public ResponseEventDTO createEvent(RequestEventDTO requestEventDTO) {
    var result = eventRepository.
            existsByNomeAndData(requestEventDTO.getNome(), requestEventDTO.getData());

    if (result) {
      throw new ConflictException("Evento ja cadastrado");// personalized exception
    }

      Event event = new Event( //request
                requestEventDTO.getNome(),
                requestEventDTO.getLocal(),
                requestEventDTO.getData(),
                requestEventDTO.getVagasTotais()
    );

     eventRepository.save(event);

    return new ResponseEventDTO(
            event.getId(),
            event.getName(),
            event.getLocal(),
            event.getDate(),
            event.getVagastotais(),
            event.getVagasDisponiveis()
    ); //Validado

  }



}