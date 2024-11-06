package org.api.model.DTO;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class RequestEventDTO {

  @NotBlank(message = "the name is required and must have between 5 and 100 characters.")
  @Size(min = 5, max = 100, message = "the name must have between 5 and 100 characters.")
  private String nome;

  @NotBlank(message = "The location is required and must have between 5 and 100 characters.")
  @Size(min = 5, max = 100, message = "The location must have between 5 and 100 characters.")
  private String local;

  @NotNull(message = "The date is required.")
  private LocalDateTime data;

  @Positive(message = "the number of total vacancies must be greater than zero.")
  private int vagasTotais;



  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public int getVagasTotais() {
    return vagasTotais;
  }

  public void setVagasTotais(int vagasTotais) {
    this.vagasTotais = vagasTotais;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }
}
