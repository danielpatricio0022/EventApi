package org.api.model.DTO;

public class ParticipantDTO {

  private Long participanteId;
  private String nome;
  private String email;
  private int eventId;
  private boolean status;

  public Long getParticipanteId() {
    return participanteId;
  }

  public void setParticipanteId(Long participanteId) {
    this.participanteId = participanteId;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }
}
