package org.api.model.DTO;

import jakarta.validation.constraints.Size;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ReqParticipantDTO {

  @NotBlank(message = "Name is required")
  private String name;

  @NotBlank(message = "Email is required")
  @Email(message = "Email is invalid")
  private String email;

  private int eventoId;

  public int getEventoId() {
    return eventoId;
  }

  public void setEventoId(int eventoId) {
    this.eventoId = eventoId;
  }

  public @NotBlank(message = "Name is required") String getName() {
    return name;
  }

  public void setName(@NotBlank(message = "Name is required") String name) {
    this.name = name;
  }

  public @NotBlank(message = "Email is required") String getEmail() {
    return email;
  }

  public void setEmail(@NotBlank(message = "Email is required") String email) {
    this.email = email;
  }
}
