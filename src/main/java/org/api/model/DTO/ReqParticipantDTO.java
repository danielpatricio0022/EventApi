package org.api.model.DTO;

public class ReqParticipantDTO {
  private String name;
  private String email;

  private int eventoId;

  public int getEventoId() {
    return eventoId;
  }

  public void setEventoId(int eventoId) {
    this.eventoId = eventoId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
