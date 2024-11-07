package org.api.service;

import org.api.exceptions.NotFoundException;
import org.api.exceptions.UnprocessableException;
import org.api.model.DTO.ParticipantDTO;
import org.api.model.DTO.ReqParticipantDTO;
import org.api.model.Participant;
import org.api.repository.EventRepository;
import org.api.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    EventRepository eventRepository;

    public ParticipantDTO addParticipantInEvent(int id, ReqParticipantDTO reqParticipantDTO) {
        var event = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found"));

        if (event.getVagasDisponiveis() == 0) {
            throw new UnprocessableException("Event is full");
        }

        Participant participant = new Participant();
        participant.setName(reqParticipantDTO.getName());
        participant.setEmail(reqParticipantDTO.getEmail());
        participant.setStatus(true);
        participant.setEvent(event);

        participantRepository.save(participant);

        event.setVagasDisponiveis(event.getVagasDisponiveis() - 1);
        eventRepository.save(event);

        return new ParticipantDTO(
                participant.getId(),
                participant.getName(),
                participant.getEmail(),
                participant.getStatus(),
                event.getId()
        );
    }


}
