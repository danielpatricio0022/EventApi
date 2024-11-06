package org.api.service;
import org.api.model.DTO.RequestEventDTO;
import org.api.model.DTO.ResponseEventDTO;
import org.api.model.Event;
import org.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  EventRepository eventRepository;

  public ResponseEventDTO createEvent(RequestEventDTO requestEventDTO) {
    var result = eventRepository.
            existsByNomeAndData(requestEventDTO.getNome(), requestEventDTO.getData());

    if (result) {
      throw new RuntimeException("Evento já cadastrado");
    }

    Event event = new Event();
    event.setName(requestEventDTO.getNome());
    event.setLocal(requestEventDTO.getLocal());
    event.setDate(requestEventDTO.getData());
    event.setVagastotais(requestEventDTO.getVagasTotais());
    event.setVagasDisponiveis(requestEventDTO.getVagasTotais());

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