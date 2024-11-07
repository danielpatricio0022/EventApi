package org.api.service;

import org.api.exceptions.ConflictException;
import org.api.exceptions.NotFoundException;
import org.api.exceptions.UnprocessableException;
import org.api.model.DTO.ParticipantDTO;
import org.api.model.DTO.ReqParticipantDTO;
import org.api.model.Participant;
import org.api.repository.EventRepository;
import org.api.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    EventRepository eventRepository;

    public ParticipantDTO addParticipantInEvent(int id, ReqParticipantDTO reqParticipantDTO) {

        if (reqParticipantDTO.getName() == null || reqParticipantDTO.getName().trim().isEmpty()) {
            throw new UnprocessableException("invalid data");
        }

        var event = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found"));

        if(eventRepository.existsByEmail(reqParticipantDTO.getEmail())) {
            throw new ConflictException("Email already exists");// 409
        }

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
