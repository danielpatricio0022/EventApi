package org.api.model.DTO;

import java.util.List;

public class RsEventParticipantsDTO {

  private Long eventoId;
  private String nomeEvento;
  private List<ParticipantDTO> participantes;

    public RsEventParticipantsDTO(Long eventoId, String nomeEvento, List<ParticipantDTO> participantes) {
        this.eventoId = eventoId;
        this.nomeEvento = nomeEvento;
        this.participantes = participantes;
    }

  public Long getEventoId() {
    return eventoId;
  }

  public void setEventoId(Long eventoId) {
    this.eventoId = eventoId;
  }

  public String getNomeEvento() {
    return nomeEvento;
  }

  public void setNomeEvento(String nomeEvento) {
    this.nomeEvento = nomeEvento;
  }

  public List<ParticipantDTO> getParticipantes() {
    return participantes;
  }

  public void setParticipantes(List<ParticipantDTO> participantes) {
    this.participantes = participantes;
  }
}
