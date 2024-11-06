package org.api.model.DTO;

public class ParticipantDTO {

  private int participanteId;
  private String name;
  private String email;
  private int eventId;
  private boolean status;

  public ParticipantDTO(int participanteId, String name, String email, boolean status, int eventId) {
    this.participanteId = participanteId;
    this.name = name;
    this.email = email;
    this.status = status;
    this.eventId = eventId;
  }

    public int getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(int participanteId) {
        this.participanteId = participanteId;
    }

  public String getNome() {
    return name;
  }

  public void setNome(String nome) {
    this.name = nome;
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
